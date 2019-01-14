package com.boco.itc.screenmatchtest;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class CustomPopupWindow extends PopupWindow implements View.OnClickListener {
    private View mPopupView;
    private Button btnCancel;
    public CustomPopupWindow(Context context){
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mPopupView = inflater.inflate(R.layout.pop_window_view,null);

        btnCancel =mPopupView.findViewById(R.id.id_btn_cancelo);
        btnCancel.setOnClickListener(this);

        setPopupWindow();
    }

    private void setPopupWindow() {
        this.setContentView(mPopupView);

        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);

        this.setAnimationStyle(R.style.mypopwindow_anim_style);
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明


        mPopupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int height = mPopupView.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(y < height){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    public interface OnItemClickListener{
        void setOnClick(View view);
    }

    private OnItemClickListener mListener;
    public void setOnClick(OnItemClickListener onItemClickListener){
        this.mListener = onItemClickListener;
    }

    @Override
    public void onClick(View view) {
        if(this.mListener != null){
            mListener.setOnClick(view);
        }
    }
}
