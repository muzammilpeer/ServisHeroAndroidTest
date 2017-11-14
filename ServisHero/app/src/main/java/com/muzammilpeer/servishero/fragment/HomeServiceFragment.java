package com.muzammilpeer.servishero.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.muzammilpeer.baselayer.adapter.DynamicRecyclerViewAdapter;
import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.fragment.BaseFragment;
import com.muzammilpeer.baselayer.utils.Log4a;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.logic.HomeServicesDataSource;
import com.muzammilpeer.servishero.models.HomeServicesResponseModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muzammilpeer on 01/11/2017.
 */

public class HomeServiceFragment extends BaseFragment {

    RecyclerView question1RecyclerView;
    RecyclerView question3RecyclerView;


    DynamicRecyclerViewAdapter question1Adapter;
    DynamicRecyclerViewAdapter question3Adapter;

    HomeServicesResponseModel responseModel;

    public HomeServiceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);

        return mView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_service;
    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {

        question1RecyclerView = ButterKnife.findById(mView,R.id.rv_question1);
        question3RecyclerView = ButterKnife.findById(mView,R.id.rv_question3);
    }

    @Override
    public void initObjects() {
        Gson gson = new Gson();
        String jsonString = HomeServicesDataSource.readJsonFromLocalRawFolder(getBaseActivity());
        if (jsonString != null) {
            responseModel = gson.fromJson(jsonString, HomeServicesResponseModel.class);
            Log4a.e("DATA here " ,""+ responseModel.toString());
        }

    }

    @Override
    public void initListenerOrAdapter() {

        final LinearLayoutManager layoutManager1 = new LinearLayoutManager(mContext);
        final LinearLayoutManager layoutManager2 = new LinearLayoutManager(mContext);

        question1RecyclerView.setLayoutManager(layoutManager1);
        question3RecyclerView.setLayoutManager(layoutManager2);

        question1Adapter = new DynamicRecyclerViewAdapter(HomeServicesDataSource.generateDataSourceForHomeServices(responseModel.getQuestionSubsets().getQuestion1()));
        question1RecyclerView.setAdapter(question1Adapter);

        question3Adapter = new DynamicRecyclerViewAdapter(HomeServicesDataSource.generateDataSourceForHomeServices(responseModel.getQuestionSubsets().getQuestion3()));
        question3RecyclerView.setAdapter(question3Adapter);

    }

    @Override
    public void initNetworkCalls() {

    }
}
