package com.taurus.sixtcartest.baseadapter.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GenericItem implements Parcelable {

    private int itemRecognitionFiled;

    public GenericItem() {
    }

    protected GenericItem(Parcel in) {
        itemRecognitionFiled = in.readInt();
    }

    public static final Creator<GenericItem> CREATOR = new Creator<GenericItem>() {
        @Override
        public GenericItem createFromParcel(Parcel in) {
            return new GenericItem(in);
        }

        @Override
        public GenericItem[] newArray(int size) {
            return new GenericItem[size];
        }
    };

    public int getItemRecognitionFiled() {
        return itemRecognitionFiled;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(itemRecognitionFiled);
    }
}
