package com.example.blackbird.myapplication.model;


/**
 * Created by blackbird on 7/10/17.
 */

public class ApiError {

    private int code;
    private int httpCode;
    private String cause;
    private String prettyMessage;
    private String title;
    public static final int UNKNOWN_FAILURE = 9000;

    public ApiError(Throwable t) {
        setTitle("Unknown Error");
        setPrettyMessage(t.getLocalizedMessage());
        setCause(t.getMessage());
        setCode(ApiError.UNKNOWN_FAILURE);
        setHttpCode(ApiError.UNKNOWN_FAILURE);
    }

    public ApiError() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getPrettyMessage() {
        return prettyMessage;
    }

    public void setPrettyMessage(String prettyMessage) {
        this.prettyMessage = prettyMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public static ApiError unknownError(String message)
    {
        ApiError error = new ApiError();
        error.setTitle("Unknown Error");
        error.setPrettyMessage(message);
        error.setCause(message);
        error.setCode(ApiError.UNKNOWN_FAILURE);
        error.setHttpCode(ApiError.UNKNOWN_FAILURE);
        return error;
    }
}
