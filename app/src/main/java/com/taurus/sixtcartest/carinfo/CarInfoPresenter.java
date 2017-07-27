package com.taurus.sixtcartest.carinfo;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoUIModel;
import com.taurus.sixtcartest.core.BasePresenter;
import com.taurus.sixtcartest.core.injection.Injector;
import com.taurus.sixtcartest.network.model.CarInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoPresenter extends BasePresenter<CarInfoView> {

  CarInfoPresenter() {
    Injector.getInstance().getActivityComponent().inject(this);
  }

  void onProgressBarShow() {

    if(isViewAttached()) {

      getView().showProgress();
    }
  }

  void onProgressBarHide() {

    if(isViewAttached()) {

      getView().dismissProgress();
    }
  }

  void checkGoogleServiceAvailability() {

    GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
    int isAvailable = apiAvailability.isGooglePlayServicesAvailable(getApplication());

    if(isAvailable == ConnectionResult.SUCCESS){

      getView().showMap();

    } else if(apiAvailability.isUserResolvableError(isAvailable)) {

      if(isViewAttached()) {
        getView().showInformationDialog(apiAvailability, isAvailable);
      }

    }else {

      if(isViewAttached()) {
        getView().showGoogleServiceError();
      }

    }
  }

  void onCarInfoRequested() {

    onProgressBarShow();

    getApi().getCarInfos()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .map(CarInfo::createList)
        .subscribe(this::handleResponse, this::handleError);

  }

  private void handleResponse(List<CarInfoUIModel> carInfoUIModels) {

    onProgressBarHide();

    if(isViewAttached()) {
      getView().showGetCarInfoSuccess(carInfoUIModels);
    }

  }

  private void handleError(Throwable throwable) {

    onProgressBarHide();

    if(isViewAttached()) {
      getView().showError(throwable.getMessage());
    }

  }
}
