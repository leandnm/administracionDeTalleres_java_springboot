package com.talleres.talleres.dto;

public class VehicleRequest {


    private String mark;
    private String model;
    private String tuition;
    private Long userId;

    public VehicleRequest() {
    }

    public VehicleRequest(String mark, String model, String tuition, Long userId) {
        this.mark = mark;
        this.model = model;
        this.tuition = tuition;
        this.userId = userId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
