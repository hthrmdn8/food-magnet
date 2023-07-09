package com.github.foodmagnet.models.restaurantmodels;

import com.github.foodmagnet.models.restaurantmodels.Geometry;

public class Restaurant {

    private String name;
    private String business_status;
    private Hours opening_hours;

    private Geometry geometry;

    private String icon;
    private String icon_background_color;
    private String icon_mask_base_uri;

    public Restaurant() {}

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", business_status='" + business_status + '\'' +
                ", opening_hours=" + opening_hours +
                ", geometry=" + geometry +
                ", icon='" + icon + '\'' +
                ", icon_background_color='" + icon_background_color + '\'' +
                ", icon_mask_base_uri='" + icon_mask_base_uri + '\'' +
                '}';
    }

    public Hours getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(Hours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon_mask_base_uri() {
        return icon_mask_base_uri;
    }

    public void setIcon_mask_base_uri(String icon_mask_base_uri) {
        this.icon_mask_base_uri = icon_mask_base_uri;
    }

    public String getIcon_background_color() {
        return icon_background_color;
    }

    public void setIcon_background_color(String icon_background_color) {
        this.icon_background_color = icon_background_color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

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

}
