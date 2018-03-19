package com.hwua.client;

import android.app.Fragment;
import android.os.Bundle;

import com.hwua.app.base.FragmentActivity;

/**
 * 查看商品
 */
public class ViewItem extends FragmentActivity
{
	// 重写getFragment()方法，该Activity显示该方法返回的Fragment
	@Override
	protected Fragment getFragment()
	{
		ViewItemFragment fragment = new ViewItemFragment();
		Bundle arguments = new Bundle();
		arguments.putString("action", getIntent().getStringExtra("action"));
		fragment.setArguments(arguments);
		return fragment;
	}
}
