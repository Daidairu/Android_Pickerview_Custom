package tw.com.boobi.android_pickerview_custom;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

/**
 * https://github.com/Bigkoo/Android-PickerView
 * 上面是原版,我這版新加 setShowWeekDay(boolean) 這個方法
 * 可以讓顯示禮拜幾
 * ex:今天是2019/10/24星期四 , true="24 周四" ; false="24日"
 */
public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    Calendar startTimeCalendar = Calendar.getInstance();
    Calendar endTimeCalendar = Calendar.getInstance();
    Button button;
    TextView textView;
    EditText editTextTimeRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_view);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        editTextTimeRange = findViewById(R.id.editTextTimeRange);
        endTimeCalendar.setTime(new Date(System.currentTimeMillis() + 31536000000L));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                openTimePicker();
                break;
            default:
                break;
        }
    }

    //開啟時間選擇器 pickerView
    private void openTimePicker() {
        int timeRange;

        if("".equals(editTextTimeRange.getText().toString()))
        {
            timeRange=1;
        }
        else{
            timeRange=Integer.valueOf(editTextTimeRange.getText().toString());
        }
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(SampleActivity.this, new
                OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //先行定義時間格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

//                        //透過SimpleDateFormat的format方法將Date轉為字串
                        String dateString = sdf.format(date);
                        textView.setText(dateString);

                        Log.e("HELLO", dateString + "...");
                    }
                })
                .setType(new boolean[]{true, true, true, true, true, false})// 默认全部显示
                .setCancelText(getString(R.string.pickerCancel))//取消按钮文字
                .setSubmitText(getString(R.string.pickerFinish))//确认按钮文字;
                .setSubmitColor(Color.WHITE)//確定按鈕文字顏色
                .setCancelColor(Color.WHITE)//取消按鈕文字顏色
                .setTitleColor(Color.WHITE)//标题文字颜色
                .setTitleBgColor(getColor(R.color.colorMain))//标题背景颜色 Night mode
                .setTitleText("時間")//標題文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .setRangDate(startTimeCalendar, endTimeCalendar)//起始终止年月日设定
                .setShowWeekDay(true)/**我自己新加的 操 決定你要不要顯示星期幾 幹*/
                .setTimeRange(timeRange)/**我自己新加的 用來判斷顯示時間間距 (ex:5.10.15.20)*/
                .setLabel("年", "月", "日", "時", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .build();

        pvTime.show();
    }
}
