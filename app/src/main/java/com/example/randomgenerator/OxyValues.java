package com.example.randomgenerator;

public class OxyValues {
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

    public int getValue() {
        return mvalue;
    }

    public long getTime() {
        return mtime;
    }
}
