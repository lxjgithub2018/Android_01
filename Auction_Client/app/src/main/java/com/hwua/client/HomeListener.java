package com.hwua.client;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * 公用监听器，用于返回主界面
 * Created by hwua on 2017/5/29.
 */

public class HomeListener implements View.OnClickListener {
    private Activity activity;
    public HomeListener(Activity activity)
    {
        this.activity = activity;
    }
    @Override
    public void onClick(View source)
    {
        Intent intent = new Intent(activity , AuctionClientActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);//跳转到主界面
    }
}
