package com.cy8.store.service.ex;

public class UserexistException extends ServiceException {
    public UserexistException() {
        super();
    }

    public UserexistException(String message) {
        super(message);
    }

    public UserexistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserexistException(Throwable cause) {
        super(cause);
    }

    protected UserexistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
