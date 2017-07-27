package com.taurus.sixtcartest.network.retrofit;

import com.taurus.sixtcartest.network.model.CarInfo;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public interface CarInfoService {

  @GET("/cars.json")
  Observable<List<CarInfo>> getCarInfos();

}
