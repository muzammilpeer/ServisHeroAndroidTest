package com.muzammilpeer.servishero.activity;

import com.muzammilpeer.baselayer.activity.BaseActivity;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.fragment.HomeServiceFragment;

/**
 * Created by muzammilpeer on 01/11/2017.
 */

public class HomeServiceActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_home_service;
    }

    @Override
    public void initViews() {
        super.initViews();

        HomeServiceFragment fragment = new HomeServiceFragment();
        addFragment(fragment, R.id.container_main);
    }

    @Override
    public void initObjects() {

    }

    @Override
    public void initListenerOrAdapter() {

    }

    @Override
    public void initNetworkCalls() {

    }

}
