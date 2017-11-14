package com.muzammilpeer.baselayer.cell;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.muzammilpeer.baselayer.activity.BaseActivity;
import com.muzammilpeer.baselayer.adapter.DynamicRecyclerViewAdapter;
import com.muzammilpeer.baselayer.adapter.SimpleRecyclerViewAdapter;
import com.muzammilpeer.baselayer.model.BaseModel;

import butterknife.ButterKnife;

/**
 * Created by muzammilpeer on 01/11/2017.
 */

public abstract class BaseCell<T extends BaseModel> extends RecyclerView.ViewHolder {

    protected T mDataSource;
    protected long position;

//    protected DynamicRecyclerViewAdapter mAdapter;
    protected RecyclerView.Adapter mAdapter;

    public View baseView;

    public BaseCell(View itemView) {
        super(itemView);
        baseView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) itemView.getContext();
    }

    public abstract void updateCell(T model);

    public void setAdapter(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
    }

}