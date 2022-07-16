package com.cy8.store.util;

public class JsonResult<E>{
    private Integer state;
    private String message;
    private E data;

    public JsonResult(){
    }

    public JsonResult(Integer state){
        super();
        this.state=state;
    }

    public JsonResult(Integer state,String message){
        super();
        this.state=state;
        this.message=message;
    }

    public JsonResult(Integer state,E data){
        super();
        this.state=state;
        this.data=data;
    }

    public JsonResult(Throwable a){
        super();
        this.message=a.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
