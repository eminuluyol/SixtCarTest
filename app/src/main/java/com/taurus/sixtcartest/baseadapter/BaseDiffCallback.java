package com.taurus.sixtcartest.baseadapter;

import android.support.v7.util.DiffUtil;
import com.taurus.sixtcartest.baseadapter.model.GenericItem;
import java.util.List;

public class BaseDiffCallback extends DiffUtil.Callback  {

    private final List<GenericItem> oldList;
    private final List<GenericItem> newList;

    public BaseDiffCallback(List<GenericItem> oldList, List<GenericItem> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        return oldList.get(oldItemPosition).getItemRecognitionFiled() == newList.get(newItemPosition).getItemRecognitionFiled();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final GenericItem oldItem = oldList.get(oldItemPosition);
        final GenericItem newItem = newList.get(newItemPosition);

        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

}
