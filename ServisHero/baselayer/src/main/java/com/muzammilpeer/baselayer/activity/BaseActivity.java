package com.muzammilpeer.baselayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.muzammilpeer.baselayer.R;
import com.muzammilpeer.baselayer.utils.Log4a;

import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.ButterKnife;

/**
 * Created by muzammilpeer on 01/11/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected AtomicBoolean isFragmentLoaded = new AtomicBoolean(false);

    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        setupActivity();
    }


    public void initViews() {
        //Injection Views
        ButterKnife.bind(this);
    }

    public abstract void initObjects();

    public abstract void initListenerOrAdapter();


    public abstract void initNetworkCalls();

    //setup will be called by oncreateView
    protected void setupActivity() {
        try {
            // 1. inject view with butterknife or manually
            initViews();

            if (isFragmentLoaded.get() == false) {
                //2. Load object once
                initObjects();
                //3. Network calls once
                initNetworkCalls();
            }

            //4. rebind the views with listeners or adapter again for renewal created views.
            initListenerOrAdapter();


            //mark current fragment as loaded just recreate the views only.
            isFragmentLoaded.set(true);

        } catch (Exception e) {
            Log4a.printException(e);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    /////////////////////////////////Common methods///////////////////////////////////

    public void replaceFragment(Fragment frag, int containerID) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, frag).addToBackStack(null)
                .commit();
    }

    public void replaceFragmentWithoutStack(Fragment frag, int containerID) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, frag)
                .commit();
    }

    public void addFragment(Fragment frag, int containerID) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerID,
                        frag).commit();
    }


    public void popAllFragment() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public Fragment getLastFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            return fm.getFragments().get(fm.getBackStackEntryCount());
        }
        return null;
    }

    public int getFragmentsCount() {
        FragmentManager fm = getSupportFragmentManager();
        return fm.getBackStackEntryCount();
    }


}
