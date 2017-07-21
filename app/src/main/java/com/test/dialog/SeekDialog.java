package com.test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/7/18.
 */

public class SeekDialog extends Dialog {
    private Context mContext;
    //style引用style样式
    public SeekDialog(Context context, int width, int height, View layout, int style) {

        super(context, style);

        setContentView(layout);

        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();

        params.gravity = Gravity.CENTER;

        window.setAttributes(params);

        mContext = context;
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {
            return;
        }
        setHeight();
        setWide();
    }

    /**测量Dialog的高，并设置高为屏幕的0.6倍*/
    private void setHeight() {
        Window window = getWindow();
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (window.getDecorView().getHeight() >= (int) (displayMetrics.heightPixels * 0.6)) {
            attributes.height = (int) (displayMetrics.heightPixels * 0.6);
        }
        window.setAttributes(attributes);
    }

    /**测量Dialog的宽，并设置高为屏幕的0.6倍*/
    private void setWide() {
        Window window = getWindow();
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();

            attributes.width = (int) (displayMetrics.widthPixels * 0.6);

        window.setAttributes(attributes);
    }
}
