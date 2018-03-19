package com.hwua.client;

import android.app.Fragment;

import com.hwua.app.base.FragmentActivity;

/**
 * 查看自己的竞标
 */
public class ViewBid extends FragmentActivity
{
	@Override
	protected Fragment getFragment()
	{
		return new ViewBidFragment();
	}
}
