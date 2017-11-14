package com.muzammilpeer.baselayer.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.baselayer.utils.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muzammilpeer on 01/11/2017.
 */

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<BaseCell> {

    // The items to display in your RecyclerView
    protected List<BaseModel> mObjects = new ArrayList<BaseModel>();

    private int currentColumnWidth;

    private Class cellClassName;
    private int cellLayoutId;

    public boolean isMultipleSelectionAllowed = false;

//    public SimpleRecyclerViewAdapter() {
//        super();
//        this.mObjects = new ArrayList<BaseModel>();
//    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SimpleRecyclerViewAdapter(List<BaseModel> items,Class clazz,int layoutId) {
        mObjects = items;
        cellClassName = clazz;
        cellLayoutId = layoutId;
    }


    @Override
    public BaseCell onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseCell viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflatedView = inflater.inflate(cellLayoutId, parent, false);
        viewHolder = (BaseCell) ReflectionUtil.instantiate(cellClassName, View.class, inflatedView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseCell holder, int position) {
        final BaseModel model = mObjects.get(position);

//        if (isMultipleSelectionAllowed == true ) {
//            holder.baseView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    model.isSelected = !model.isSelected;
//                    view.setBackgroundColor(model.isSelected ? Color.CYAN : Color.WHITE);
//                }
//            });
//        }
        holder.setAdapter(this);
        holder.updateCell(getItem(position));
    }

    @Override
    public int getItemCount() {
        return this.mObjects.size();
    }

    //utils
    public BaseModel getItem(int position) {
        return mObjects.get(position);
    }

    public int getCurrentColumnWidth() {
        return currentColumnWidth;
    }

    public void setCurrentColumnWidth(int currentColumnWidth) {
        this.currentColumnWidth = currentColumnWidth;
    }
}
