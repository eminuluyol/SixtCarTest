package com.taurus.sixtcartest.carinfo.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.baseadapter.viewholder.BaseViewHolder;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoViewHolder extends BaseViewHolder {

  @BindView(R.id.carInfoImageViewCar)
  ImageView imageViewCar;

  @BindView(R.id.carInfoTextViewName)
  TextView textViewName;

  @BindView(R.id.carInfoTextViewSeries)
  TextView textViewSeries;

  @BindView(R.id.carInfoTextViewFuelType)
  TextView textViewFuelType;

  @BindView(R.id.carInfoTextViewFuelLevel)
  TextView textViewFuelLevel;

  @BindView(R.id.carInfoTextViewCleanliness)
  TextView textViewCleanliness;

  public CarInfoViewHolder(@NonNull ViewGroup parentView, int layoutId) {
    super(parentView, layoutId);
  }

  void bind(CarInfoUIModel item) {


    Glide.with(itemView.getContext())
        .load(item.getCarImageUrl())
        .placeholder(R.drawable.no_image_placeholder)
        .crossFade()
        .into(imageViewCar);

    textViewName.setText(item.getName());
    textViewSeries.setText(item.getSeries());
    textViewFuelType.setText(item.getFuelType());
    textViewFuelLevel.setText(item.getFuelLevel());
    textViewCleanliness.setText(item.getInnerCleanliness());

  }

}
