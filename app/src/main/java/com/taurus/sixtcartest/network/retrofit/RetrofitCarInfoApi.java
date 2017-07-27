package com.taurus.sixtcartest.network.retrofit;

import com.taurus.sixtcartest.network.CarInfoApi;
import com.taurus.sixtcartest.network.model.CarInfo;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class RetrofitCarInfoApi implements CarInfoApi {

  public RetrofitCarInfoApi() {
  }

  @Override
  public Observable<List<CarInfo>> getCarInfos() {
    CarInfoService endpoints = APIRestClient.getInstanceRx().create(CarInfoService.class);
    return endpoints.getCarInfos();
  }
}
