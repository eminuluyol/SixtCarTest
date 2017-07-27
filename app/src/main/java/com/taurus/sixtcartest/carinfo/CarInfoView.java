package com.taurus.sixtcartest.carinfo;

import com.google.android.gms.common.GoogleApiAvailability;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoUIModel;
import com.taurus.sixtcartest.core.BaseView;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public interface CarInfoView extends BaseView {

  void showEmptyView();

  void hideEmptyView();

  void showInformationDialog(GoogleApiAvailability apiAvailability, int isAvailable);

  void showGoogleServiceError();

  void showMap();

  void showGetCarInfoSuccess(List<CarInfoUIModel> carInfoUIModels);
}
