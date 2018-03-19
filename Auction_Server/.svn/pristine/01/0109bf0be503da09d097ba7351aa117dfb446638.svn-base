package com.hwua.auction.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.hwua.auction.po.Users;
import com.hwua.auction.service.UsersService;
import com.hwua.auction.util.JsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 登录控制层
 *
 */
public class LoginController extends ActionSupport implements ModelDriven<Object> {
	
	// log4j日志对象
	private Logger log = Logger.getLogger(this.getClass());

	//用于接收表单数据
	private Users users = new Users();

	//验证码
	private String code;

	//输入流，用于验证码图片的显示
	private InputStream inputStream;

	@Resource //告诉spring，当扫描到这里时，注入UsersService对象进来，初始此属性
	private UsersService usersService;// 业务逻辑层对象


	/**
	 * 
	 * @param req
	 * @param users
	 *            接收登录表单提交过来的数据
	 * @param code
	 *            接收验证码
	 * @return
	 */
	@Action(value = "/index", results = { @Result(name = "success", location = "/WEB-INF/content/index.jsp")})
	public String index() {
		return "success";
	}

	/**
	 * 
	 * @param req
	 * @param users
	 *            接收登录表单提交过来的数据
	 * @param code
	 *            接收验证码
	 * @return
	 */
	@Action(value = "/main", results = { @Result(name = "success", location = "/WEB-INF/content/main.jsp")})
	public String main() {
		return "success";
	}
	
	/**
	 * 
	 * @param req
	 * @param users
	 *            接收登录表单提交过来的数据
	 * @param code
	 *            接收验证码
	 * @return
	 */
	@Action(value = "/login", 
			results = { 
			@Result(name = "success", type="redirectAction" , params = {"actionName" , "main"}),
			@Result(name = "input", location = "/WEB-INF/content/index.jsp") 
			})
	public String login() {

		log.info("接收到登录信息:" + users + "," + ",验证码:" + code);// 把users放到日志

		try {
			// 从服务器缓存中拿出先前放置的验证码
			String sessionCode = (String) ActionContext.getContext().getSession().get("code");
			if (!sessionCode.equals(code)) {// 与页面传过来的验证码对比
				addFieldError("code", "验证码不正确");
				return "input";
			}
			// 通过用户名去获取管理员
			Users dbUsers = usersService.getUsersByUserName(users.getUserName());
			if (dbUsers == null) {// 如果拿不到管理员

				addFieldError("userName", "账号不存在");
				return "input";
			}

			if (!users.getUserPass().equals(dbUsers.getUserPass())) {// 验证当前录入的密码与数据库返回来的密码是否相等

				addFieldError("userPass", "密码不正确");
				return "input";
			}

			ActionContext.getContext().getSession().put("ADMIN", dbUsers);// 将管理员对象放入session缓存中，方便其他模块使用

		} catch (Exception e) {
			log.error("登录失败", e);
		}

		return "success";

	}

	/**
	 * 
	 * @param req
	 * @param users
	 *            接收登录表单提交过来的数据
	 * @param code
	 *            接收验证码
	 * @return
	 */
	@Action(value = "/ajaxLogin")
	public String ajaxLogin() {

		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			// 通过用户名去获取管理员
			Users dbUsers = usersService.getUsersByUserName(users.getUserName());
			if (dbUsers == null) {// 如果拿不到管理员

				jsonDatas.put("msg", "账号不存在");
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}

			if (!users.getUserPass().equals(dbUsers.getUserPass())) {// 验证当前录入的密码与数据库返回来的密码是否相等

				jsonDatas.put("msg", "密码不正确");
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}

			jsonDatas.put("status", 1);// 默认状态为1，表示操作成功
			ActionContext.getContext().getSession().put("ADMIN", dbUsers);// 将管理员对象放入session缓存中，方便其他模块使用

		} catch (Exception e) {
			log.error("登录失败", e);
		}

		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}
	
	/**
	 * 生成验证码 // GET /code
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Action(value = "/code", results = { @Result(name = "code", type = "stream") })
	public String code() throws ServletException, IOException {
		// 在内存中创建图像
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 创建随机数对象
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设置字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(60, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 随机产生认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}

		// 将认证码存入SESSION范围
		ActionContext.getContext().getSession().put("code", sRand);
		// 图象生效
		g.dispose();

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.close();
		inputStream = new ByteArrayInputStream(output.toByteArray());
		return "code";
	}

	private Color getRandColor(int fc, int bc) {
		// 创建随机数对象
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}

		if (bc > 255) {
			bc = 255;
		}

		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	@Override
	public Object getModel() {
		return users;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

}