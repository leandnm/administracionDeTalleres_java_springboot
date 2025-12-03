package com.talleres.talleres.response;

import java.time.LocalDateTime;

public class ApiResponse {

    // code
    // message
    // success
    // timestamps
    // data

    private Integer code;
    private String message;
    private Boolean success;
    private LocalDateTime timestamp;
    private Object data;

    public ApiResponse(Integer code, String message, Boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse() {
    }

    public static ApiResponse success(String message, Object data){

        ApiResponse response = new ApiResponse();
        response.setSuccess(true);
        response.setCode(200);
        response.setTimestamp(LocalDateTime.now());
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public static ApiResponse errorNotFound(String message){

        ApiResponse response = new ApiResponse();
        response.setSuccess(false);
        response.setCode(404);
        response.setTimestamp(LocalDateTime.now());
        response.setMessage(message);
        response.setData(null);

        return response;
    }

    public static ApiResponse recursoCreado(String message, Object data){

        ApiResponse response = new ApiResponse();
        response.setSuccess(true);
        response.setCode(201);
        response.setTimestamp(LocalDateTime.now());
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
