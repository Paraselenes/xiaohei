package com.test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/18.
 */

public class ListDialog extends Dialog{

    private final Context mContext;

    public ListView getmListView() {
        return mListView;
    }

    private ListView mListView;

    public ListDialog(@NonNull Context context,int style) {
        super(context,style);
        mContext = context;
        initView();
        initListView();
    }

    private void initView() {
        View contentView = View.inflate(mContext, R.layout.dialog_list, null);
        mListView = (ListView) contentView.findViewById(R.id.lv);
        setContentView(contentView);
    }

    private void initListView() {
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_expandable_list_item_1);
        for (int i = 0; i < 10; i++) {
            stringArrayAdapter.add("item " + i);
        }
        mListView.setAdapter(stringArrayAdapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mContext,""+position,Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {
            return;
        }
        setHeight();
    }

    private void setHeight() {
        Window window = getWindow();
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (window.getDecorView().getHeight() >= (int) (displayMetrics.heightPixels * 0.6)) {
            attributes.height = (int) (displayMetrics.heightPixels * 0.6);
        }
        window.setAttributes(attributes);
    }



}
