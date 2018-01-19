package com.xmsmartcity.Userinfo.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.xmsmartcity.Userinfo.Mapper.Entity.Result;

/**
 * Created by lingyun on 2018/1/19.
 */
public class ResultInfo {

    public  static Result responseSucess(){
       return  responseSucess(null);
    }
    public  static Result responseSucess(Object object ){

        Result result =  new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return  result;

    }
    public  static Result responseFlase(Integer code,String msg){

        Result result =  new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
