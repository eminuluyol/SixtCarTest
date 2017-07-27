package com.taurus.sixtcartest.carinfo.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.taurus.sixtcartest.R;
import com.taurus.sixtcartest.baseadapter.BaseAdapterDelegate;
import com.taurus.sixtcartest.baseadapter.model.GenericItem;
import java.util.List;

/**
 * Created by eminuluyol on 27/07/2017.
 */

public class CarInfoAdapterDelegate
    extends BaseAdapterDelegate<CarInfoUIModel, GenericItem, CarInfoViewHolder> {

  @Override
  protected boolean isForViewType(@NonNull GenericItem item, @NonNull List<GenericItem> items,
      int position) {
    return item instanceof CarInfoUIModel;
  }

  @NonNull @Override protected CarInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
    return new CarInfoViewHolder(parent, R.layout.list_item_car_info);
  }

  @Override protected void onBindViewHolder(@NonNull CarInfoUIModel item,
      @NonNull CarInfoViewHolder viewHolder, @NonNull List<Object> payloads) {
    viewHolder.bind(item);
  }
}
