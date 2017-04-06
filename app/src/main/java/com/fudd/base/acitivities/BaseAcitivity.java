package com.fudd.base.acitivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by fudd-office on 2017-4-6 13:37.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public abstract class BaseAcitivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initBundle(getIntent().getExtras())){
            setContentView(getContentView());

            initWindow();

            ButterKnife.bind(this);
            initWidget();
            initDate();

        }else {
            finish();
        }


    }

    protected void initWindow() {
    }
    protected void initWidget() {
    }
    protected void initDate() {
    }
    protected abstract int getContentView();

    protected boolean initBundle(Bundle bundle){
        return true;
    }
}
