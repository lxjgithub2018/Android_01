package com.hwua.auction.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hwua.auction.dao.BidsDao;
import com.hwua.auction.dao.ItemsDao;
import com.hwua.auction.po.Bids;
import com.hwua.auction.po.Items;
import com.hwua.auction.po.States;
import com.hwua.auction.util.Page;

/**
 * 竞拍结果业务逻辑层实现类
 * @author hwua
 *
 */
@Component("bidOpeningService") //当spring扫描到这里时，创建这个类的对象，并存入容器中，它的ID编号为:bidOpeningService
@Lazy(value=false)//要求spring一启动容器就要创建这个类的实例
public class BidOpeningServiceImpl extends AbstractBaseService<Items, Integer> implements BidOpeningService {

	@Resource //告诉spring，当扫描到这里时，注入ItemsDao对象进来，初始此属性
	private ItemsDao dao;//商品数据访问层对象
	
	@Resource
	private BidsDao bidsDao;//商品数据访问层对象
	
	public ItemsDao getDao() {
		return dao;
	}

	public void setDao(ItemsDao dao) {
		this.dao = dao;
	}

	public BidOpeningServiceImpl() {
		super();
	}
	
	/**
	 * 此方法用于定期扫描数据库中的商品表，看哪一个商品已经到了结束竞拍时间
	 */
	@Scheduled(cron = "*/60 * * * * ?")//每隔60秒执行一次
    public void add() throws Exception {
        System.out.println("准备开标......");
        //构造查询条件
        Items obj=new Items();
        States states = new States();
        states.setStateId(1);//状态为拍卖中的商品
		obj.setStates(states);
		
		List<Items> list = this.getList(obj);
		for(Items item:list){//增强for循环
			
			if(item.getEndTime().compareTo(new Date())<0){//比较日期，拿结束竞拍日期与当前系统日期进行对比，如果是当前日期大过于竞拍日期则结束
				Bids bids=new Bids();
				bids.setItems(item);//通过商品编号去找竞拍记录
				List<Bids> list2 = bidsDao.getList(bids);
				if(list2.size()>0){//如果有竞拍记录
					Bids bids2 = list2.get(0);// 拿价格最高的那条记录出来
					States st = new States();
			        st.setStateId(2);//设置状态拍卖成功
					item.setStates(st);//关联状态对象
					item.setWinerUsers(bids2.getUsers());//设置赢得这次拍卖的用户
				}else{//如果有竞拍记录
					States st = new States();
			        st.setStateId(3);//设置状态流拍
					item.setStates(st);//关联状态对象
				}
				
				this.update(item);//更新商品信息
				
			}
		}
    }
	 
	/**
	 * 添加商品
	 * @throws Exception 
	 *  
	 */
	@Override
	public boolean add(Items obj) throws Exception {
		boolean flag=false;
		this.getDao().add(obj);
		flag=true;
		return flag;
	}

	/**
	 * 修改商品
	 * @throws Exception 
	 */
	@Override
	public boolean update(Items obj) throws Exception {
		boolean flag=false;
		this.getDao().update(obj);
		flag=true;
		return flag;
	}

	/**
	 * 删除商品
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public boolean delete(Integer id) throws Exception {
		boolean flag=false;
		this.getDao().delete(id);
		flag=true;
		return flag;
	}

	/**
	 * 获取商品
	 * @param id 编号
	 * @throws Exception 
	 */
	@Override
	public Items get(Integer id) throws Exception {
		Items items=null;
		items = this.getDao().get(id);
		return items;
	}

	/**
	 * 获得商品表所有记录
	 * @throws Exception 
	 */
	@Override
	public List<Items> getList() throws Exception {
		List<Items> list=null;
		list = this.getDao().getList();
		
		return list;
	}

	/**
	 * 带条件获取商品记录
	 * @throws Exception 
	 */
	@Override
	public List<Items> getList(Items obj) throws Exception {
		List<Items> list=null;
		list = this.getDao().getList(obj);
		
		return list;
	}

	@Override
	public Page<Items> getList(Items obj, Integer page, Integer limit) throws Exception {
		return this.getDao().getList(obj, page, limit);
	}

}