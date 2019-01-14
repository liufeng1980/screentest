package com.boco.itc.screenmatchtest;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    TextView mTextView;

    /**
     * 添加
     */
    CustomPopupWindow myPopup;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mTextView = findViewById(R.id.tv);
        DisplayMetrics dm = getDisplayMetrics();
        Log.i("TAG",">>>density="+ dm.density);
        Log.i("TAG",">>>densityDpi="+ dm.densityDpi);



        myPopup = new CustomPopupWindow(this);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPopup.showAtLocation(MainActivity.this.findViewById(R.id.main),Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
            }
        });

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThread = new MyThread();
                myThread.start();
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThread.cancel();
            }
        });

        myPopup.setOnClick(new CustomPopupWindow.OnItemClickListener() {
            @Override
            public void setOnClick(View view) {
//                ScrollView sv;
//                sv.requestDisallowInterceptTouchEvent();
                switch (view.getId()){
                    case R.id.id_btn_cancelo:
                        myPopup.dismiss();
                        break;
                }
            }
        });
    }

    private DisplayMetrics getDisplayMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        return dm;
    }


}
