package com.cy8.store.service.ex;

public class PassWordNoCorrect extends ServiceException {
    public PassWordNoCorrect() {
        super();
    }

    public PassWordNoCorrect(String message) {
        super(message);
    }

    public PassWordNoCorrect(String message, Throwable cause) {
        super(message, cause);
    }

    public PassWordNoCorrect(Throwable cause) {
        super(cause);
    }

    protected PassWordNoCorrect(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
