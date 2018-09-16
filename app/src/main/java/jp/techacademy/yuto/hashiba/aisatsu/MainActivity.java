package jp.techacademy.yuto.hashiba.aisatsu;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI_PARTS", "ボタンをタップしました");
                showTimePickerDialog();
            }
        });

    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        TextView mTextView;
                        mTextView = (TextView) findViewById(R.id.TextView01);

                        int i = Integer.parseInt(String.valueOf(hourOfDay));
                        int flag=0;
                        if ( 2<=i && i<=9){
                            flag = 0;
                            Log.d("UI-PARTS", flag + "_01");
                        } else if ( 10<=i && i<=17){
                            flag = 1;
                            Log.d("UI-PARTS", flag + "_01");
                        } else if ( 18<=i || i<=1){
                            flag = 2;
                            Log.d("UI-PARTS", flag + "_01");
                        }

                        switch (flag ){
                            case 0:
                                mTextView.setText("おはよう");
                                Log.d("UI-PARTS", flag + "_02");
                                break;
                            case 1:
                                mTextView.setText("こんにちは");
                                Log.d("UI-PARTS", flag + "_02");
                                break;
                            case 2:
                                mTextView.setText("こんばんは");
                                Log.d("UI-PARTS", flag + "_02");
                                break;
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();



    }


}
