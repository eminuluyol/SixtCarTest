package com.taurus.sixtcartest.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfo {

  @SerializedName("id")
  @Expose
  private String id;

  @SerializedName("modelIdentifier")
  @Expose
  private String modelIdentifier;

  @SerializedName("modelName")
  @Expose
  private String modelName;

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("make")
  @Expose
  private String make;

  @SerializedName("group")
  @Expose
  private String group;

  @SerializedName("color")
  @Expose
  private String color;
  @SerializedName("series")
  @Expose
  private String series;

  @SerializedName("fuelType")
  @Expose
  private String fuelType;

  @SerializedName("fuelLevel")
  @Expose
  private double fuelLevel;

  @SerializedName("transmission")
  @Expose
  private String transmission;

  @SerializedName("licensePlate")
  @Expose
  private String licensePlate;

  @SerializedName("latitude")
  @Expose
  private double latitude;

  @SerializedName("longitude")
  @Expose
  private double longitude;

  @SerializedName("innerCleanliness")
  @Expose
  private String innerCleanliness;

  @SerializedName("carImageUrl")
  @Expose
  private String carImageUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getModelIdentifier() {
    return modelIdentifier;
  }

  public void setModelIdentifier(String modelIdentifier) {
    this.modelIdentifier = modelIdentifier;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public double getFuelLevel() {
    return fuelLevel;
  }

  public void setFuelLevel(double fuelLevel) {
    this.fuelLevel = fuelLevel;
  }

  public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getInnerCleanliness() {
    return innerCleanliness;
  }

  public void setInnerCleanliness(String innerCleanliness) {
    this.innerCleanliness = innerCleanliness;
  }

  public String getCarImageUrl() {
    return carImageUrl;
  }

  public void setCarImageUrl(String carImageUrl) {
    this.carImageUrl = carImageUrl;
  }

}
