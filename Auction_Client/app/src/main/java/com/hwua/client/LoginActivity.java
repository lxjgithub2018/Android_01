package com.hwua.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hwua.client.util.DialogUtil;
import com.hwua.client.util.HttpUtil;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/**登录界面*/
public class LoginActivity extends Activity {

    // 定义界面中两个文本框
    private EditText etName, etPass;
    // 定义界面中两个按钮
    private Button bnLogin, bnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 获取界面中两个编辑框
        etName = (EditText) findViewById(R.id.userEditText);
        etPass = (EditText) findViewById(R.id.pwdEditText);
        // 获取界面中的两个按钮
        bnLogin = (Button) findViewById(R.id.bnLogin);
        bnCancel = (Button) findViewById(R.id.bnCancel);
        // 为bnCancal按钮的单击事件绑定事件监听器
        bnCancel.setOnClickListener(new HomeListener(this));
        bnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 执行输入校验
                if (validate())  // ①
                {
                    // 如果登录成功
                    if (loginPro())  // ②
                    {
                        // 启动Main Activity
                        Intent intent = new Intent(LoginActivity.this, AuctionClientActivity.class);
                        startActivity(intent);
                        // 结束该Activity
                        finish();
                    }
                    else
                    {
                        DialogUtil.showDialog(LoginActivity.this, "用户名称或者密码错误，请重新输入！", false);
                    }
                }
            }
        });
    }

    private boolean loginPro()
    {
        // 获取用户输入的用户名、密码
        String userName = etName.getText().toString();
        String userPass = etPass.getText().toString();
        JSONObject jsonObj;
        try
        {
            jsonObj = query(userName, userPass);
            // status等于1
            if (jsonObj.getInt("status")==1)
            {
                return true;
            }
        }
        catch (Exception e)
        {
            DialogUtil.showDialog(this, "服务器响应异常，请稍后再试！", false);
            e.printStackTrace();
        }

        return false;
    }

    // 对用户输入的用户名、密码进行校验
    private boolean validate()
    {
        String userName = etName.getText().toString().trim();
        if (userName.equals(""))
        {
            DialogUtil.showDialog(this, "用户账户是必填项！", false);
            return false;
        }
        String userPass = etPass.getText().toString().trim();
        if (userPass.equals(""))
        {
            DialogUtil.showDialog(this, "用户口令是必填项！", false);
            return false;
        }
        return true;
    }

    // 定义发送请求的方法
    private JSONObject query(String userName, String userPass)
            throws Exception
    {
        // 使用Map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userPass", userPass);
        // 定义发送请求的URL
        String url = HttpUtil.BASE_URL + "ajaxLogin.action";
        // 发送请求
        return new JSONObject(HttpUtil.postRequest(url, map));
    }

}
