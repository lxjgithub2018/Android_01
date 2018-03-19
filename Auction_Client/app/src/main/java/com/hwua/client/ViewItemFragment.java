package com.hwua.client;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.hwua.client.util.DialogUtil;
import com.hwua.client.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 查看商品子界面
 */
public class ViewItemFragment extends Fragment
{
	private Button bnHome;
	private ListView succList;
	private TextView viewTitle;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.view_item, container , false);
		// 获取界面上的返回按钮
		bnHome = (Button) rootView.findViewById(R.id.bn_home);
		succList = (ListView) rootView.findViewById(R.id.succList);
		viewTitle = (TextView) rootView.findViewById(R.id.view_titile);
		// 为返回按钮的单击事件绑定事件监听器
		bnHome.setOnClickListener(new HomeListener(getActivity()));
		String action = getArguments().getString("action");
		// 定义发送请求的URL
		String url = HttpUtil.BASE_URL + action;
		// 如果是查看流拍物品，修改标题
		if (action.equals("items_selectDatas.action?states.stateId=3&page=1&rows=100"))
		{
			viewTitle.setText(R.string.view_fail);
		}
		try
		{
			// 向指定URL发送请求，并把服务器响应转换成JSONArray对象
			JSONArray jsonArray = new JSONObject(HttpUtil.getRequest(url)).getJSONArray("rows");  // ①
			// 将JSONArray包装成Adapter
			JSONArrayAdapter adapter = new JSONArrayAdapter(getActivity(), jsonArray, "itemName", true);  // ②
			succList.setAdapter(adapter);
		}
		catch (Exception e)
		{
			DialogUtil.showDialog(getActivity(), "服务器响应异常，请稍后再试！"+5, false);
			e.printStackTrace();
		}
		succList.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id)
			{
				// 查看指定物品的详细情况。
				viewItemDetail(position);  // ③
			}
		});
		return rootView;
	}

	/**
	 * 查看物品详情
	 * @param position
	 */
	private void viewItemDetail(int position)
	{
		// 加载detail.xml界面布局代表的视图
		View detailView = getActivity().getLayoutInflater()
				.inflate(R.layout.detail, null);
		// 获取detail.xml界面布局中的文本框
		TextView itemName = (TextView) detailView
				.findViewById(R.id.itemName);
		TextView itemKind = (TextView) detailView
				.findViewById(R.id.itemKind);
		TextView maxPrice = (TextView) detailView
				.findViewById(R.id.maxPrice);
		TextView itemRemark = (TextView) detailView
				.findViewById(R.id.itemRemark);
		// 获取被单击的列表项
		JSONObject jsonObj = (JSONObject) succList.getAdapter().getItem(position);
		try
		{
			// 通过文本框显示物品详情
			itemName.setText(jsonObj.getString("itemName"));
			itemKind.setText(jsonObj.getJSONObject("kinds").getString("kindName"));
			maxPrice.setText(jsonObj.getString("maxPrice"));
			itemRemark.setText(jsonObj.getString("itemDesc"));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		DialogUtil.showDialog(getActivity(), detailView);
	}
}