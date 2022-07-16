package com.cy8.store.service.ex;

public class UserNoExistException extends ServiceException{
    public UserNoExistException() {
        super();
    }

    public UserNoExistException(String message) {
        super(message);
    }

    public UserNoExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNoExistException(Throwable cause) {
        super(cause);
    }

    protected UserNoExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
