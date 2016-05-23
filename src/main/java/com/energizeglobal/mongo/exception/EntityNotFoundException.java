package com.energizeglobal.mongo.exception;

/**
 * Company: WeDooApps
 * Date: 5/23/16
 * <p/>
 * Created by Adam Madoyan.
 */
public class EntityNotFoundException extends DatabaseException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
