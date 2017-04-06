package com.fudd.base.acitivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.ButterKnife;

/**
 * Created by fudd-office on 2017-4-6 13:37.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public abstract class BaseAcitivity extends AppCompatActivity {

    private Fragment mFragment;
    private boolean mIsDestroy;
    protected RequestManager mImageLoader;

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
        // 此处  友盟统计未添加

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }

    protected void addFragment(int fragmentLayoutId, Fragment fragment){
        if (fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()){
                if (mFragment != null){
                    transaction.hide(mFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mFragment != null){
                    transaction.hide(mFragment).add(fragmentLayoutId,fragment);
                } else {
                    transaction.add(fragmentLayoutId, fragment);
                }
            }
            mFragment = fragment;
            transaction.commit();
        }
    }

    protected void replaceFragment(int fragmentLayoutId, Fragment fragment){
        if (fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(fragmentLayoutId,fragment);
            transaction.commit();
        }
    }

    public synchronized  RequestManager getImageLoader(){
        if (mImageLoader  == null){
            mImageLoader = Glide.with(this);
        }
        return mImageLoader;
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
    }

    public boolean isDestroy(){
        return  mIsDestroy;
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
