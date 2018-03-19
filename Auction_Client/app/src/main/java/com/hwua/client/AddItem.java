package com.hwua.client;

import android.app.Fragment;

import com.hwua.app.base.FragmentActivity;

/**
 * 添加商品
 */
public class AddItem extends FragmentActivity
{
	@Override
	public Fragment getFragment()
	{
		return new AddItemFragment();
	}
}