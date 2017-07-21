package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        ll = (LinearLayout) findViewById(R.id.ll);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
//                params.setMargins(0, 100, 0,0);
//                bt3.setLayoutParams(params);
                /**设置控件的间距*/
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)bt3.getLayoutParams();
                layoutParams.setMargins(0,300,0,0);
                bt3.setLayoutParams(layoutParams);
            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"aaaaaaaaaa",Toast.LENGTH_SHORT).show();
            }
        });


//        bt3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                Log.e("++++++++++++++++++++++","ViewTreeObserver : v_view1.getWidth():" + bt3.getWidth()
//                        + "  v_view1.getHeight():" + bt3.getHeight());
//                Log.e("hehe","宽："+bt3.getWidth()+"高："+bt3.getHeight());
//               Log.i("hehe","宽："+bt3.getWidth()+"高："+bt3.getHeight());
//            }
//        });

        ll.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.e("哒哒哒","宽："+ll.getWidth()+"高："+ll.getHeight());
            }
        });

    }
}
