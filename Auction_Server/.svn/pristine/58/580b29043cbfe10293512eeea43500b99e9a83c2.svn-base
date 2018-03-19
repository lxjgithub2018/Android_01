package com.hwua.auction.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.hwua.auction.po.Items;
import com.hwua.auction.po.Kinds;
import com.hwua.auction.po.States;
import com.hwua.auction.po.Users;
import com.hwua.auction.service.ItemsService;
import com.hwua.auction.service.KindsService;
import com.hwua.auction.service.StatesService;
import com.hwua.auction.service.UsersService;
import com.hwua.auction.util.JsonUtils;
import com.hwua.auction.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *  商品管理控制层
 *
 */
public class ItemsController extends ActionSupport implements ModelDriven<Object> {

	// log4j日志对象
	private Logger log = Logger.getLogger(this.getClass());
	
	//用于接收表单数据
	private Items items = new Items();

	private Integer page;//当前页
	private Integer rows;//一页显示的记录数

	@Resource //告诉spring，当扫描到这里时，注入ItemsService对象进来，初始此属性
	private ItemsService itemsService;//接收业务逻辑层对象

	@Resource //告诉spring，当扫描到这里时，注入StatesService对象进来，初始此属性
	private StatesService statesService;//接收业务逻辑层对象
	
	@Resource //告诉spring，当扫描到这里时，注入KindsService对象进来，初始此属性
	private KindsService kindsService;//接收业务逻辑层对象
	
	@Resource //告诉spring，当扫描到这里时，注入UsersService对象进来，初始此属性
	private UsersService usersService;//接收业务逻辑层对象
	
	/**
	 *  商品添加页面
	 * 
	 * @return
	 */
	@Action(value = "/items_add", results = {
			@Result(name = "input", location = "/WEB-INF/content/ItemsAdd.jsp") })
	public String add(){
		log.info("进入 商品添加页面");
		return "input";
	}
	
	/**
	 * 保存添加
	 * 
	 * @return
	 */
	@Action("/items_addSave")
	public String addSave() {

		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			Users users=(Users)ActionContext.getContext().getSession().get("ADMIN");
			if(users==null){
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			
			if(items.getKinds().getKindId()!=null){
				items.setKinds(kindsService.get(items.getKinds().getKindId()));
			}else{
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			
			if(items.getStates().getStateId()!=null){
				items.setStates(statesService.get(items.getStates().getStateId()));
			}else{
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			items.setWinerUsers(null);
			items.setOwnerUsers(usersService.get(users.getUserId()));//设置发布者
			items.setAddTime(new Date());
			items.setMaxPrice(items.getInitPrice());
			boolean flag = itemsService.add(items);// 然后把items添加进去
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
	 *  商品修改页面
	 * 
	 * @return
	 */
	@Action(value = "/items_edit", results = {
			@Result(name = "input", location = "/WEB-INF/content/ItemsEdit.jsp") })
	public String edit(){
		log.info("进入 商品修改页面");
		return "input";
	}
	
	/**
	 * 初始化修改
	 * 
	 * @return
	 */
	@Action("/items_update")
	public String update() {
		Integer id = items.getItemId();
		log.info("开始初始化编号为" + id + "的 商品数据供前端修改");// 把id放到日志
		Items items = null;
		try {
			// 通过id去获取 商品信息
			items = itemsService.get(id);// 通过id拿到商品对象赋给items变量
		} catch (Exception e) {
			log.error("初始化修改失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(items));
		return "json";

	}

	/**
	 * 保存修改
	 * 
	 * @return
	 */
	@Action("/items_updateSave")
	public String updateSave() {

		log.info("接收到页面修改的数据：" + items);// 把items放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {

			Items oldItems = itemsService.get(items.getItemId());// 通过id找到对应的这一条 商品信息
			// 找到之后，把名字放进去给它
			oldItems.setItemName(items.getItemName());
			oldItems.setItemRemark(items.getItemRemark());
			oldItems.setEndTime(items.getEndTime());
			oldItems.setInitPrice(items.getInitPrice());
			oldItems.setMaxPrice(items.getMaxPrice());
			oldItems.setItemDesc(items.getItemDesc());
			if(items.getKinds().getKindId()!=null){
				oldItems.setKinds(kindsService.get(items.getKinds().getKindId()));
			}
			
			if(items.getStates().getStateId()!=null){
				oldItems.setStates(statesService.get(items.getStates().getStateId()));
			}
			
			if(items.getWinerUsers().getUserId()!=null){
				oldItems.setWinerUsers(usersService.get(items.getWinerUsers().getUserId()));
			}
			
			// 调用修改的方法，修改原先的信息
			boolean flag = itemsService.update(oldItems);

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
	 * 删除 商品
	 * 
	 * @return
	 */
	@Action("/items_delete")
	public String delete() {
		Integer id = items.getItemId();
		log.info("开始删除编号为" + id + "的 商品");// 把id放到日志
		Map jsonDatas = new HashMap();// 存放json数据的集合
		jsonDatas.put("status", 0);// 默认状态为0，表示操作失败
		try {
			// 通过id去删除数据
			boolean flag = itemsService.delete(id);
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
	 * 商品管理页面
	 * @return
	 */
	@Action(value = "/items_select", results = {
			@Result(name = "input", location = "/WEB-INF/content/ItemsList.jsp") })
	public String select() {
		log.info("进入 商品管理页面");
		return "input";
	}

	/**
	 *  商品管理表格数据
	 * 
	 * @return
	 */
	@Action("/items_selectDatas")
	public String selectDatas() {

		log.info("开始获取 商品管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			// 分页处理
			Page<Items> pageObj = itemsService.getList(items, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 商品管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}
	
	/**
	 *  商品管理表格数据
	 * 
	 * @return
	 */
	@Action("/items_ownerItems")
	public String ownerItems() {

		log.info("开始获取 商品管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			Users users=(Users)ActionContext.getContext().getSession().get("ADMIN");
			if(users==null){
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			
			items.setOwnerUsers(users);
			// 分页处理
			Page<Items> pageObj = itemsService.getList(items, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 商品管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}
	
	/**
	 *  商品管理表格数据
	 * 
	 * @return
	 */
	@Action("/items_winerItems")
	public String winerItems() {

		log.info("开始获取 商品管理表格数据");
		Map jsonDatas = new HashMap();// 待返回json集合数据;
		try {
			Users users=(Users)ActionContext.getContext().getSession().get("ADMIN");
			if(users==null){
				// 最终给JsonUtils转换为json数据输出给浏览器
				ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
				return "json";
			}
			items.setWinerUsers(users);
			// 分页处理
			Page<Items> pageObj = itemsService.getList(items, page, rows);
			// 取记录总条数
			jsonDatas.put("total", pageObj.getTotal());// 总数
			jsonDatas.put("rows", pageObj.getResultlist());// 前端需要的行数据

		} catch (Exception e) {
			log.error("获取 商品管理表格数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(jsonDatas));
		return "json";

	}

	/**
	 *  商品查询页面
	 * 
	 * @return
	 */
	@Action(value = "/items_search", results = {
			@Result(name = "input", location = "/WEB-INF/content/ItemsSearch.jsp") })
	public String search(){
		log.info("进入 商品查询页面");
		return "input";
	}

	/**
	 *  商品类别数据
	 * 
	 * @return
	 */
	@Action("/items_kindsDatas")
	public String kindsDatas() {
		List<Kinds> list=null;
		log.info("开始获取 商品类别数据");
		try {
			list = kindsService.getList();
		} catch (Exception e) {
			log.error("获取 商品类别数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(list));
		return "json";

	}
	
	/**
	 *  商品状态数据
	 * 
	 * @return
	 */
	@Action("/items_statesDatas")
	public String statesDatas() {
		List<States> list=null;
		log.info("开始获取商品状态数据");
		try {
			list = statesService.getList();
		} catch (Exception e) {
			log.error("获取 商品状态数据失败", e);
		}
		// 最终给JsonUtils转换为json数据输出给浏览器
		ServletActionContext.getRequest().setAttribute("jsonDatas", JsonUtils.objectToJson(list));
		return "json";

	}
	
	@Override
	public Object getModel() {
		items.setKinds(new Kinds());
		items.setStates(new States());
		items.setWinerUsers(new Users());
		items.setOwnerUsers(new Users());
		return items;
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