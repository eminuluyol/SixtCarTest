package com.taurus.sixtcartest.baseadapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;
import com.taurus.sixtcartest.baseadapter.model.GenericItem;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends ListDelegationAdapter<List<GenericItem>> {

    public static RecyclerAdapter with(BaseAdapterDelegate... delegates) {
        final AdapterDelegatesManager<List<GenericItem>> delegatesManager = new AdapterDelegatesManager<>();
        for (BaseAdapterDelegate delegate : delegates) {
            delegatesManager.addDelegate(delegate);
        }
        return new RecyclerAdapter(delegatesManager);
    }

    public RecyclerAdapter(@NonNull AdapterDelegatesManager<List<GenericItem>> delegatesManager) {
        super(delegatesManager);
        setItems(new ArrayList<>());
    }

    public GenericItem getItem(int position) {

        if (getItemCount() > position) {
            return items.get(position);
        }

        return null;
    }

    public void setIems(List<GenericItem> list){
        if(list == null) list = new ArrayList<>();
        setItems(list);
    }

    public void addAll(List<GenericItem> list) {

        if (items == null) items = new ArrayList<>();

        items.addAll(list);
        notifyDataSetChanged();
    }

    public void  swapItems(List<GenericItem> list) {
        final BaseDiffCallback diffCallback = new BaseDiffCallback(this.items, list);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.items.clear();
        this.items.addAll(list);
        diffResult.dispatchUpdatesTo(this);
    }

}