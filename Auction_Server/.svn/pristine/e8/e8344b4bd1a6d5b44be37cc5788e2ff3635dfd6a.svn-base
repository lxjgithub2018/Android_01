package com.hwua.auction.controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

//定义全局结果集
@Results({
	//type为redirectAction表示重定向到另一个控制器,params用于配置参数,这里配置的是要跳转的另一个控制器的名字
    @Result(name="success", type="redirectAction", params = {"actionName" , "index"})
})
public class IndexController {

	
    @Action("/")
    public String index() {
        return "success";//跳转到上面定义的name为success的结果
    }
}