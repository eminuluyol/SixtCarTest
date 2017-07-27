package com.taurus.sixtcartest.network;

import com.taurus.sixtcartest.network.model.CarInfo;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public interface CarInfoApi {

  Observable<List<CarInfo>> getCarInfos();
}
