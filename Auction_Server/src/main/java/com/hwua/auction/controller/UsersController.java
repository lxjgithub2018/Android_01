package com.hwua.auction.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.hwua.auction.po.Users;
import com.hwua.auction.service.UsersService;
import com.hwua.auction.util.JsonUtils;
import com.hwua.auction.util.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *  用户管理控制层
 *
 */
public class UsersController extends ActionSupport implements ModelDriven<Object> {

	// log4j日志对象
	private Logger log = Logger.getLogger(this.getClass());
	
	//用于接收表单数据
	private Users users = new Users();

	private Integer page;//当前页
	private Integer rows;//一页显示的记录数

	@Resource //告诉spring，当扫描到这里时，注入UsersService对象进来，初始此属性
	private UsersService usersService;//接收业务逻辑层对象

	/**
	 *  用户添加页面
	 * 
	 * @return
	 */
	@Action(value = "/users_add", results = {
			@Result(name = "input", location = "/WEB-INF/content/UsersAdd.jsp") })
	public String add(){
		log.info("进入 用户添加页面");
		return "input";
	}
	
	/**
	 * 保存添加
	 * 
	 * @return
	 */
	@Action("/users_addSave")
	public String addSave() {

		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			boolean flag = usersService.add(users);// 然后把users添加进去
			if (flag) {
				jsonDatas.put("status", 1);// 设置状态为1，表示操作成功
			}

		} catch (Exception e) {
			log.error("添加失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}

	/**
	 *  用户修改页面
	 * 
	 * @return
	 */
	@Action(value = "/users_edit", results = {
			@Result(name = "input", location = "/WEB-INF/content/UsersEdit.jsp") })
	public String edit(){
		log.info("进入 用户修改页面");
		return "input";
	}
	
	/**
	 * 初始化修改
	 * 
	 * @return
	 */
	@Action("/users_update")
	public String update() {
		Integer id = users.getUserId();
		log.info("开始初始化编号为" + id + "的 用户数据供前端修改");// 把id放到日志
		Users users = null;
		try {
			// 通过id去获取 用户信息
			users = usersService.get(id);// 通过id拿到用户对象赋给users变量
		} catch (Exception e) {
			log.error("初始化修改失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(users));
		return "json";

	}

	/**
	 * 保存修改
	 * 
	 * @return
	 */
	@Action("/users_updateSave")
	public String updateSave() {

		log.info("接收到页面修改的数据：" + users);// 把users放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {

			Users oldUsers = usersService.get(users.getUserId());// 通过id找到对应的这一条 用户信息
			// 找到之后，把名字放进去给它
			oldUsers.setUserName(users.getUserName());
			oldUsers.setUserPass(users.getUserPass());
			
			// 调用修改的方法，修改原先的信息
			boolean flag = usersService.update(oldUsers);

			if (flag) {
				jsonDatas.put("status", 1);// 设置状态为1，表示操作成功
			}

		} catch (Exception e) {
			log.error("修改失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";
	}

	/**
	 * 删除 用户
	 * 
	 * @return
	 */
	@Action("/users_delete")
	public String delete() {
		Integer id = users.getUserId();
		log.info("开始删除编号为" + id + "的 用户");// 把id放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			// 通过id去删除数据
			boolean flag = usersService.delete(id);
			if (flag) {
				jsonDatas.put("status", 1);// 设置状态为1，表示操作成功
			}
		} catch (Exception e) {
			log.error("删除失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";
	}

	/**
	 *  用户管理页面
	 * 
	 * @return
	 */
	@Action(value = "/users_select", results = {
			@Result(name = "input", location = "/WEB-INF/content/UsersList.jsp") })
	public String select() {
		log.info("进入 用户管理页面");
		return "input";
	}

	/**
	 *  用户管理表格数据
	 * 
	 * @return
	 */
	@Action("/users_selectDatas")
	public String selectDatas() {

		log.info("开始获取 用户管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			// 分页处理
			Page<Users> pageObj = usersService.getList(users, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 用户管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}

	/**
	 *  用户查询页面
	 * 
	 * @return
	 */
	@Action(value = "/users_search", results = {
			@Result(name = "input", location = "/WEB-INF/content/UsersSearch.jsp") })
	public String search(){
		log.info("进入 用户查询页面");
		return "input";
	}

	@Override
	public Object getModel() {
		return users;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
