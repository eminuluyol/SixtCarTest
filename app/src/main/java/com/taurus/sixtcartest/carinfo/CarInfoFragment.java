package com.taurus.sixtcartest.carinfo;

import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.core.BaseFragment;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoFragment extends BaseFragment<CarInfoView, CarInfoPresenter> implements CarInfoView {

  public static CarInfoFragment newInstance() {
    return new CarInfoFragment();
  }

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_car_info;
  }

  @Override
  public CarInfoPresenter createPresenter() {
    return new CarInfoPresenter();
  }
}
