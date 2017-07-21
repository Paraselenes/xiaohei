package com.test.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Button btn;
    private Button bt1;
    private Button seek;
    private ImageView cha;
    private TextView tv;
    /**
     * 是否单行显示
     */
    public boolean isSingleLine = false;
    /**
     * AutoCompleteTextView外部线性布局的宽
     */
    private int width;
    /**
     * AutoCompleteTextView外部线性布局的宽
     */
    private int height;
    /**
     * 自动补全控件
     */
    private AutoCompleteTextView act;
    /**带LisetView的Dialog*/
    private ListDialog ld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog();
            }
        });
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showListViewDialog();
            }
        });

        seek = (Button) findViewById(R.id.seek);
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSeekDialog();
            }
        });

        tv = (TextView) findViewById(R.id.tv);
        tv.setText("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setSingleLine(isSingleLine);
                isSingleLine = !isSingleLine;
            }
        });

    }

    private void showLoginDialog() {
        View view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        final TextView tvTitle = (TextView) view.findViewById(R.id.down);

        final MyDialog builder = new MyDialog(MainActivity.this, 0, 0, view, R.style.DialogTheme);

        builder.setCancelable(false);
        builder.show();
        //设置对话框显示的View
        //点击确定是的监听
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this, "确定按钮。。。", Toast.LENGTH_SHORT).show();
                builder.cancel();
            }
        });
    }

    private void showSeekDialog() {
        List<String> countries = new ArrayList<String>();
        countries.add("Aqqghanistan");
        countries.add("Aqbania");
        countries.add("Aqgeria");
        countries.add("Aqerican");
        countries.add("Aqdorra");
        countries.add("Aqqguilla");
        countries.add("Aqgola");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");
        countries.add("Aqtarctica");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        View view = getLayoutInflater().inflate(R.layout.dialog_seek, null);
        final LinearLayout seek_ll = (LinearLayout) view.findViewById(R.id.seek_ll);

        /**获取线性布局的宽高*/
        seek_ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                width = seek_ll.getWidth();
                height = seek_ll.getHeight();
                /**AutoCompleteTextView设置下拉列表的宽度*/
                act.setDropDownWidth(width);
                /**获取屏幕的高度*/
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
//                int screenWidth = dm.widthPixels;
                int screenHeigh = dm.heightPixels;
                /**设置AutoCompleteTextView下拉列的的高度为屏幕的3.5分之一*/
                act.setDropDownHeight((int) (screenHeigh / 3.5));
                /**设置ImageView与AutoCompleteTextView之间的间距*/
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cha.getLayoutParams();
                layoutParams.setMargins(0, (int) ((screenHeigh / 3.5) + 50), 0, 0);
                cha.setLayoutParams(layoutParams);
                /**移除这个监听器*/
                seek_ll.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);

            }
        });

        act = (AutoCompleteTextView) view.findViewById(R.id.act);
        act.setAdapter(adapter);

        final MyDialog builder = new MyDialog(MainActivity.this, 0, 0, view, R.style.DialogTheme);
        builder.setCancelable(false);
        builder.show();


        final TextView tvTitle = (TextView) view.findViewById(R.id.seek_tv);
        //点击查找的监听
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this, "点击了查找按钮", Toast.LENGTH_SHORT).show();
                // builder.cancel();

            }
        });
        cha = (ImageView) view.findViewById(R.id.cha);
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });

    }


    private void showListViewDialog() {
        ld = new ListDialog(MainActivity.this, R.style.DialogTheme);
        ld.setCancelable(false);
        ld.show();
        final ListView listview = ld.getmListView();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
                ld.dismiss();
            }
        });
    }
}
