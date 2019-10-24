package com.bigkoo.pickerview.adapter;

import android.net.ParseException;

import com.bigkoo.pickerview.R;
import com.contrarywind.adapter.WheelAdapter;

import java.util.Calendar;

/**
 * 自訂 adapter 為了讓禮拜一到禮拜日能顯示出來  不顯示請直接用 NumericWheelAdapter
 */
public class WeekDaysWheelAdapter implements WheelAdapter {

    private int minValue;
    private int maxValue;

    private int year;
    private int month;

//    /**
//     * Constructor
//     *
//     * @param minValue the wheel min value
//     * @param maxValue the wheel max value
//     */
//    public WeekDaysWheelAdapter(int minValue, int maxValue) {
//        this.minValue = minValue;
//        this.maxValue = maxValue;
//    }


    /**
     * Constructor
     *
     * @param year   the year
     * @param month  the month
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     */
    public WeekDaysWheelAdapter(int year, int month, int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        this.year = year;
        this.month = month;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int date = minValue + index;

            /*原本是 1.2.3.4.5 幾號這樣, 現在變成 1週一 2週二 3週三 這樣*/
            String value = date + " " + getWeekday(year, month, date);

            return value;
        }
        return 0;
    }

    @Override
    public int getItemsCount() {
        return maxValue - minValue + 1;
    }

    @Override
    public int indexOf(Object o) {
        try {
            return (int) o - minValue;
        } catch (Exception e) {
            return -1;
        }
    }

    /*新增的 判斷禮拜一到日 (1-7)*/
    private String getWeekday(int year, final int month, int day) {

        String weekDays = "";

        Calendar c = Calendar.getInstance();
        try {
            c.set(year, month, day);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                weekDays = "週日";
                break;

            case Calendar.MONDAY:
                weekDays = "週一";
                break;

            case Calendar.TUESDAY:
                weekDays = "週二";
                break;

            case Calendar.WEDNESDAY:
                weekDays = "週三";
                break;

            case Calendar.THURSDAY:
                weekDays = "週四";
                break;

            case Calendar.FRIDAY:
                weekDays = "週五";
                break;

            case Calendar.SATURDAY:
                weekDays = "週六";
                break;

            default:
                break;
        }
        return weekDays;
    }
}