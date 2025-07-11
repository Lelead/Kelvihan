package com.kelvihanl.common;

/**
 * 统一返回包装类
 * 统一后端返回数据类型
 */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(){
        Result result = new Result();
        result.setCode(100);
        result.setMsg("请求成功");
        return result;
    }

    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("系统错误");
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public Object getData(){
        return data;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public void setData(Object data){
        this.data = data;
    }

}
