package com.taurus.sixtcartest.carinfo;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import butterknife.BindView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.core.BaseFragment;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoFragment extends BaseFragment<CarInfoView, CarInfoPresenter> implements CarInfoView {

  public static CarInfoFragment newInstance() {
    return new CarInfoFragment();
  }

  @BindView(R.id.carInfoRecyclerView)
  RecyclerView carInfoRecyclerView;

  @BindView(R.id.emptyView)
  NestedScrollView emptyView;

  @BindView(R.id.carInfoButtonOpenMap)
  ImageButton buttonOpenMap;

  @BindView(R.id.sliding_layout)
  SlidingUpPanelLayout slidingLayout;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_car_info;
  }

  @Override
  public CarInfoPresenter createPresenter() {
    return new CarInfoPresenter();
  }
}
