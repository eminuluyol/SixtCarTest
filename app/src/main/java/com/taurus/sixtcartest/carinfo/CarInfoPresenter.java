package com.taurus.sixtcartest.carinfo;

import com.taurus.sixtcartest.core.BasePresenter;
import com.taurus.sixtcartest.core.injection.Injector;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoPresenter extends BasePresenter<CarInfoView> {

  CarInfoPresenter() {
    Injector.getInstance().getActivityComponent().inject(this);
  }

}
