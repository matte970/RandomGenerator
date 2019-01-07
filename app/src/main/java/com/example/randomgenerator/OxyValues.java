package com.example.randomgenerator;

import android.os.Parcel;
import android.os.Parcelable;

public class OxyValues implements Parcelable {
    /**
     * value of the data point (y-axis)
     */
    private int mvalue;
    /**
     * time of the data point (x-axis)
     */
    private long mtime;

    /**
     * Constructs a new {@link OxyValues} object
     *
     * @param value is value of the data point (y-axis)
     * @param time  is time of the data point (x-axis)
     */
    public OxyValues(int value, long time) {
        mvalue = value;
        mtime = time;
    }

    /**
     * LEAVE THIS CONSTRUCTOR ALONE!
     * Is for the Parceling and sending
     */
    protected OxyValues(Parcel in) {
        mvalue = in.readInt();
        mtime = in.readLong();
    }

    /**
     * LEAVE THIS METHOD ALONE!
     * Is for the Parceling and sending
     */
    public static final Creator<OxyValues> CREATOR = new Creator<OxyValues>() {
        @Override
        public OxyValues createFromParcel(Parcel in) {
            return new OxyValues(in);
        }

        @Override
        public OxyValues[] newArray(int size) {
            return new OxyValues[size];
        }
    };

    /**
     * returns the y-axis value
     */
    public int getValue() {
        return mvalue;
    }

    /**
     * returns the x-axis value
     */
    public long getTime() {
        return mtime;
    }

    /**
     * LEAVE THIS METHOD ALONE!
     * Is for the Parceling and sending
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * LEAVE THIS METHOD ALONE!
     * Is for the Parceling and sending
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mvalue);
        dest.writeLong(mtime);
    }
}
