package com.hwua.client;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.hwua.app.base.FragmentActivity;

/**
 * 类别管理界面
 */
public class ManageKind extends FragmentActivity implements Callbacks
{
	@Override
	public Fragment getFragment()
	{
		return new ManageKindFragment();
	}
	@Override
	public void onItemSelected(Integer id, Bundle bundle)
	{
		// 当用户单击ManageKindFragment中添加按钮时，启动AddKind Activity
		Intent intent = new Intent(this , AddKind.class);
		startActivity(intent);
	}
}
