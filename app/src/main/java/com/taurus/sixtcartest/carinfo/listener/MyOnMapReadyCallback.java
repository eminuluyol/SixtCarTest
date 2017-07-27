package com.taurus.sixtcartest.carinfo.listener;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoUIModel;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public abstract class MyOnMapReadyCallback implements OnMapReadyCallback {

  List<CarInfoUIModel> carInfos;

  public MyOnMapReadyCallback(List<CarInfoUIModel> carInfos){
    this.carInfos = carInfos;
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    this.onMapReadyMarkers(googleMap, carInfos);
  }

  public abstract void onMapReadyMarkers(GoogleMap googleMap, List<CarInfoUIModel> carInfos);
}
