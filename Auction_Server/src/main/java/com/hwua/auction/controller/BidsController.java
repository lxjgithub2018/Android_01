package com.hwua.auction.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.hwua.auction.po.Bids;
import com.hwua.auction.po.Items;
import com.hwua.auction.po.Users;
import com.hwua.auction.service.BidsService;
import com.hwua.auction.service.ItemsService;
import com.hwua.auction.service.UsersService;
import com.hwua.auction.util.JsonUtils;
import com.hwua.auction.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *  竞拍记录管理控制层
 *
 */
public class BidsController extends ActionSupport implements ModelDriven<Object> {

	// log4j日志对象
	private Logger log = Logger.getLogger(this.getClass());
	
	//用于接收表单数据
	private Bids bids = new Bids();

	private Integer page;//当前页
	private Integer rows;//一页显示的记录数

	@Resource //告诉spring，当扫描到这里时，注入ItemsService对象进来，初始此属性
	private ItemsService itemsService;//接收业务逻辑层对象
	
	@Resource //告诉spring，当扫描到这里时，注入BidsService对象进来，初始此属性
	private BidsService bidsService;//接收业务逻辑层对象

	@Resource //告诉spring，当扫描到这里时，注入UsersService对象进来，初始此属性
	private UsersService usersService;//接收业务逻辑层对象
	
	/**
	 * 保存添加
	 * 
	 * @return
	 */
	@Action("/bids_addSave")
	public String addSave() {

		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			Users users=(Users)ActionContext.getContext().getSession().get("ADMIN");
			
			Items items = itemsService.get(bids.getItems().getItemId());
			bids.setItems(items);
			bids.setUsers(usersService.get(users.getUserId()));
			bids.setBidDate(new Date());
			boolean flag = bidsService.add(bids);// 然后把bids添加进去
			if (flag) {
				items.setMaxPrice(bids.getBidPrice());
				itemsService.update(items);
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
	 * 初始化修改
	 * 
	 * @return
	 */
	@Action("/bids_update")
	public String update() {
		Integer id = bids.getBidId();
		log.info("开始初始化编号为" + id + "的 竞拍记录数据供前端修改");// 把id放到日志
		Bids bids = null;
		try {
			// 通过id去获取 竞拍记录信息
			bids = bidsService.get(id);// 通过id拿到竞拍记录对象赋给bids变量
		} catch (Exception e) {
			log.error("初始化修改失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(bids));
		return "json";

	}

	/**
	 * 保存修改
	 * 
	 * @return
	 */
	@Action("/bids_updateSave")
	public String updateSave() {

		log.info("接收到页面修改的数据：" + bids);// 把bids放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {

			Bids oldBids = bidsService.get(bids.getBidId());// 通过id找到对应的这一条 竞拍记录信息
			// 找到之后，把名字放进去给它
			oldBids.setBidPrice(bids.getBidPrice());
			
			// 调用修改的方法，修改原先的信息
			boolean flag = bidsService.update(oldBids);

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
	 * 删除 竞拍记录
	 * 
	 * @return
	 */
	@Action("/bids_delete")
	public String delete() {
		Integer id = bids.getBidId();
		log.info("开始删除编号为" + id + "的 竞拍记录");// 把id放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			// 通过id去删除数据
			boolean flag = bidsService.delete(id);
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
	 * 竞拍记录管理页面
	 * @return
	 */
	@Action(value = "/bids_select", results = {
			@Result(name = "input", location = "/WEB-INF/content/BidsList.jsp") })
	public String select() {
		log.info("进入 竞拍记录管理页面");
		return "input";
	}

	/**
	 *  竞拍记录管理表格数据
	 * 
	 * @return
	 */
	@Action("/bids_selectDatas")
	public String selectDatas() {

		log.info("开始获取 竞拍记录管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			// 分页处理
			Page<Bids> pageObj = bidsService.getList(bids, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 竞拍记录管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}
	
	/**
	 *  竞拍记录管理表格数据
	 * 
	 * @return
	 */
	@Action("/bids_myBidsDatas")
	public String myBidsDatas() {

		log.info("开始获取 竞拍记录管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			Users users=(Users)ActionContext.getContext().getSession().get("ADMIN");
			if(users==null){
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			
			bids.setUsers(users);
			// 分页处理
			Page<Bids> pageObj = bidsService.getList(bids, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 竞拍记录管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}

	/**
	 *  竞拍记录查询页面
	 * 
	 * @return
	 */
	@Action(value = "/bids_search", results = {
			@Result(name = "input", location = "/WEB-INF/content/BidsSearch.jsp") })
	public String search(){
		log.info("进入 竞拍记录查询页面");
		return "input";
	}

	@Override
	public Object getModel() {
		bids.setItems(new Items());
		bids.setUsers(new Users());
		return bids;
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