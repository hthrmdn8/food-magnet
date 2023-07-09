package com.github.foodmagnet.models;

public class Restaurant {

    private String business_status;

    public Restaurant() {}

    public String getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(String business_status) {
        this.business_status = business_status;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "business_status='" + business_status + '\'' +
                '}';
    }
}
