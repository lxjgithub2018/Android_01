package com.hwua.client;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.hwua.app.base.FragmentActivity;

/**
 * 浏览拍卖物品（选择物品种类）
 */
public class ManageItem extends FragmentActivity implements Callbacks
{
	@Override
	public Fragment getFragment()
	{
		return new ManageItemFragment();
	}
	@Override
	public void onItemSelected(Integer id, Bundle bundle)
	{
		// 当用户单击添加按钮时，将会启动AddItem Activity
		Intent intent = new Intent(this , AddItem.class);
		startActivity(intent);
	}
}