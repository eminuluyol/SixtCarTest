package com.taurus.sixtcartest.carinfo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.baseadapter.RecyclerAdapter;
import com.taurus.sixtcartest.baseadapter.model.GenericItem;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoAdapterDelegate;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoUIModel;
import com.taurus.sixtcartest.carinfo.listener.MyOnMapReadyCallback;
import com.taurus.sixtcartest.core.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoFragment extends BaseFragment<CarInfoView, CarInfoPresenter>
    implements CarInfoView, SlidingUpPanelLayout.PanelSlideListener{

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

  private List<CarInfoUIModel> carInfoUIModels;
  private RecyclerAdapter carInfoAdapter;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_car_info;
  }

  @Override
  public CarInfoPresenter createPresenter() {
    return new CarInfoPresenter();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    slidingLayout.addPanelSlideListener(this);

    carInfoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    carInfoAdapter = RecyclerAdapter.with(new CarInfoAdapterDelegate());
    carInfoRecyclerView.setAdapter(carInfoAdapter);

    getPresenter().checkGoogleServiceAvailability();
    getPresenter().onCarInfoRequested();

  }

  @Override
  public void showGetCarInfoSuccess(List<CarInfoUIModel> carInfoUIModels) {

    this.carInfoUIModels = carInfoUIModels;
    List<GenericItem> data = new ArrayList<>(carInfoUIModels);
    carInfoAdapter.swapItems(data);

  }

  @OnClick(R.id.carInfoButtonOpenMap)
  public void onViewClicked(View view) {
    YoYo.with(Techniques.BounceInUp)
        .duration(850)
        .playOn(view);
    toggleMap();
  }

  private void toggleMap() {

    if (slidingLayout.getPanelState().equals(SlidingUpPanelLayout.PanelState.COLLAPSED)) {
      slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.ANCHORED);
    } else {
      slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }
  }

  @Override
  public void onPanelSlide(View panel, float slideOffset) {
    //Nothing to do
  }

  @Override
  public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState,
      SlidingUpPanelLayout.PanelState newState) {

    if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
      buttonOpenMap.setImageResource(R.drawable.ic_map);
    }

    if (newState == SlidingUpPanelLayout.PanelState.ANCHORED) {
      buttonOpenMap.setImageResource(R.drawable.ic_arrow_down);
    }

    if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
      buttonOpenMap.setImageResource(R.drawable.ic_arrow_down);
    }

  }

  @Override
  public void showEmptyView() {
    emptyView.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideEmptyView() {
    emptyView.setVisibility(View.GONE);
  }

  @Override
  public void showInformationDialog(GoogleApiAvailability apiAvailability, int isAvailable) {
    Dialog dialog = apiAvailability.getErrorDialog(getActivity(), isAvailable, 0);
    dialog.show();

  }

  @Override
  public void showGoogleServiceError() {
    Toast.makeText(getContext(), getResources().getString(R.string.google_maps_error), Toast.LENGTH_LONG).show();
  }

  @Override
  public void showMap() {

    FragmentManager fm = getActivity().getSupportFragmentManager();
    SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

    if (supportMapFragment == null) {
      supportMapFragment = SupportMapFragment.newInstance();
      fm.beginTransaction().replace(R.id.map, supportMapFragment).commit();
    }

    supportMapFragment.getMapAsync(new MyOnMapReadyCallback(carInfoUIModels) {
      @Override
      public void onMapReadyMarkers(GoogleMap googleMap, List<CarInfoUIModel> carInfoUIModels) {
        drawPlaceMarkersOnMap(googleMap, carInfoUIModels);
      }
    });

  }


  private void drawPlaceMarkersOnMap(GoogleMap googleMap, List<CarInfoUIModel> carInfoUIModels) {

    // Add a marker in Map
    for (CarInfoUIModel marker : carInfoUIModels) {

      LatLng place = new LatLng(marker.getLatitude(), marker.getLongitude());
      googleMap.addMarker(new MarkerOptions().position(place)
          .title(marker.getName())
          .snippet(marker.getFuelType())
          .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_location)));

    }

    // move the camera
    if (!carInfoUIModels.isEmpty()) {
      CarInfoUIModel item = carInfoUIModels.get(0);
      LatLng firstPlace = new LatLng(item.getLatitude(), item.getLongitude());
      googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstPlace, 11.1f));
    }

    setInfoWindowAdapter(googleMap);

  }

  private void setInfoWindowAdapter(GoogleMap googleMap) {

    googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

      @Override
      public View getInfoWindow(Marker arg0) {
        return null;
      }

      @Override
      public View getInfoContents(Marker marker) {

        LinearLayout info = new LinearLayout(getContext());
        info.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(getContext());
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setText(marker.getTitle());

        TextView snippet = new TextView(getContext());
        int padding = (int) getContext().getResources().getDimension(R.dimen.space_small);
        snippet.setPadding(padding, 0, padding, 0);
        snippet.setTextColor(Color.GRAY);
        snippet.setText(marker.getSnippet());

        info.addView(title);
        info.addView(snippet);

        return info;
      }
    });
  }
}
