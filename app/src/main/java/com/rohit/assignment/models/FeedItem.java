package com.rohit.assignment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedItem {

    @SerializedName("screen")
    @Expose
    private String screen;

    @SerializedName("component_position")
    @Expose
    private int componentPosition;

    @SerializedName("image_url")
    @Expose
    private String carImageUrl;

    @SerializedName("car_name")
    @Expose
    private String carName;

    @SerializedName("car_reg_no")
    @Expose
    private String carRegNo;

    @SerializedName("car_type")
    @Expose
    private String carType;

    @SerializedName("fuel_type")
    @Expose
    private String fuelType;

    @SerializedName("banners")
    @Expose
    List<OfferItem> banners;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getComponentPosition() {
        return componentPosition;
    }

    public void setComponentPosition(int componentPosition) {
        this.componentPosition = componentPosition;
    }

    public String getCarImageUrl() {
        return carImageUrl;
    }

    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public void setCarRegNo(String carRegNo) {
        this.carRegNo = carRegNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public List<OfferItem> getBanners() {
        return banners;
    }

    public void setBanners(List<OfferItem> banners) {
        this.banners = banners;
    }
}
