package com.taurus.sixtcartest.baseadapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.taurus.sixtcartest.carinfo.adapter.CarInfoUIModel;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull ViewGroup parentView, int layoutId) {
        super(LayoutInflater.from(parentView.getContext()).inflate(layoutId, parentView, false));
        ButterKnife.bind(this, itemView);
    }


}