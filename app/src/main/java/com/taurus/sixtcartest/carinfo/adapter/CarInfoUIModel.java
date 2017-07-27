package com.taurus.sixtcartest.carinfo.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.taurus.sixtcartest.baseadapter.model.GenericItem;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoUIModel extends GenericItem {

  private String id;

  private String name;

  private String series;

  private String fuelType;

  private String fuelLevel;

  private double latitude;

  private double longitude;

  private String innerCleanliness;

  private String carImageUrl;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getFuelLevel() {
    return fuelLevel;
  }

  public void setFuelLevel(String fuelLevel) {
    this.fuelLevel = fuelLevel;
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
