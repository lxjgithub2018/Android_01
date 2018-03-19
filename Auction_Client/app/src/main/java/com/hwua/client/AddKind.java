package com.hwua.client;

import android.app.Fragment;

import com.hwua.app.base.FragmentActivity;

/**
 * 添加类别
 */
public class AddKind extends FragmentActivity
{
	@Override
	public Fragment getFragment()
	{
		return new AddKindFragment();
	}
}
