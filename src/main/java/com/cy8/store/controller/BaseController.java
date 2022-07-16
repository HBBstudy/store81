package com.cy8.store.controller;


import com.cy8.store.service.ex.*;
import com.cy8.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {
    public static final Integer OK=200;

        @ExceptionHandler(ServiceException.class)
        public JsonResult<Void> handlerException(Throwable e){
            JsonResult<Void> result=new JsonResult<>();
            if(e instanceof UserNoExistException){
                result.setState(400);
            }else if(e instanceof InsertException){
                result.setState(500);
            }else if(e instanceof UserexistException){
                result.setState(500);
            }else if(e instanceof PassWordNoCorrect) {
                result.setState(500);
            }
            return result;
    }
}
