package com.bigkoo.pickerview.adapter;

import com.contrarywind.adapter.WheelAdapter;

/**
 * 自訂的adapter
 * 可以過濾時間間距 EX 5 10 15 20
 */
public class TimeRangeWheelAdapter implements WheelAdapter {

    private int minValue;
    private int maxValue;
    private int range;

    /**
     * Constructor
     *
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     * @param range    時間間距，每幾分一個選項，最低為1(不過濾)，最高為59，不符合的情況下就直接當作1(不過濾)
     */
    public TimeRangeWheelAdapter(int minValue, int maxValue, int range) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.range = range;

        if (range < 1 || range > 59) {
            this.range = 1;
        }
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int value = minValue + index * range;
            return value;
        }
        return 0;
    }

    @Override
    public int getItemsCount() {
        return ((maxValue - minValue + 1) % range == 0) ? (maxValue - minValue + 1) / range :
                (maxValue - minValue + 1) / range + 1;
    }

    @Override
    public int indexOf(Object o) {
        try {
            return (int) o - minValue;
        } catch (Exception e) {
            return -1;
        }
    }


}