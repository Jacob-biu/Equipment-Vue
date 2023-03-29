package com.equipment.common.email.bean;

/**
 * @Author: weisong
 * @CreateTime: 2023-02-18  22:56
 * @Description: TODO
 * @Version: 1.0
 */
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    public RespBean(int i, String message, Object o) {
        this.code=i;
        this.message=message;
        this.obj=o;
    }

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param data
     * @return
     */
    public static RespBean success(String message,Object data){
        return new RespBean(200,message,data);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param data
     * @return
     */
    public static RespBean error(String message,Object data){
        return new RespBean(500,message,data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
