package com.hwua.client;

import android.app.Fragment;
import android.os.Bundle;

import com.hwua.app.base.FragmentActivity;

/**
 * 参与竞拍
 */
public class AddBid extends FragmentActivity
{
	@Override
	public Fragment getFragment()
	{
		AddBidFragment fragment = new AddBidFragment();
		Bundle args = new Bundle();
		args.putInt("itemId", getIntent().getIntExtra("itemId", -1));
		fragment.setArguments(args);
		return fragment;
	}
}
