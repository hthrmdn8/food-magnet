package com.github.foodmagnet.models.restaurantmodels;

import com.github.foodmagnet.models.restaurantmodels.Geometry;

public class Restaurant {

    private String business_status;

    private Geometry geometry;

    public Restaurant() {}

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

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
                ", geometry=" + geometry +
                '}';
    }
}
