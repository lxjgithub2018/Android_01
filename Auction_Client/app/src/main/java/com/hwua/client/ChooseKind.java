package com.hwua.client;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.hwua.app.base.FragmentActivity;

/**
 * 选择类别
 */
public class ChooseKind extends FragmentActivity implements Callbacks
{
	@Override
	public Fragment getFragment()
	{
		return new ChooseKindFragment();
	}
	@Override
	public void onItemSelected(Integer id, Bundle bundle)
	{
		Intent intent = new Intent(this , ChooseItem.class);
		intent.putExtra("kindId", bundle.getLong("kindId"));
		startActivity(intent);
	}
}
