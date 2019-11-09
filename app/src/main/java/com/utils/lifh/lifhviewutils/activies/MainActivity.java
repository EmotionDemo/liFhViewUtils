package com.utils.lifh.lifhviewutils.activies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.utils.lifh.lifhviewutils.R;
import com.utils.lifh.lifhviewutils.utils.LiViewsUtils;
import com.utils.lifh.lifhviewutils.utils.OnClick;
import com.utils.lifh.lifhviewutils.utils.ViewInject;


public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_tv1)
    private TextView tv_1;

    @ViewInject(R.id.tv_tv2)
    private TextView tv_2;


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiViewsUtils.inject(this);

        Log.d("tv1===", tv_1.getText().toString());
        Log.d("tv2===", tv_2.getText().toString());

    }


    @OnClick(R.id.btn_btn1)
    private void clickViews(View view) {
        Toast.makeText(MainActivity.this, new StringBuffer(tv_1.getText()).append(tv_2.getText()), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.tv_tv1)
    private void clickViewsTv_1(View view) {
        Toast.makeText(MainActivity.this, "这里是TextView1", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.tv_tv2)
    private void clickViewsTv_2(View view) {
        Toast.makeText(MainActivity.this, "这里是TextView2", Toast.LENGTH_LONG).show();
    }

}
