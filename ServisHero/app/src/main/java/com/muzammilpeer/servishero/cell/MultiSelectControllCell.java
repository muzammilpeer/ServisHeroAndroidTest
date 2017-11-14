package com.muzammilpeer.servishero.cell;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.muzammilpeer.baselayer.adapter.DynamicRecyclerViewAdapter;
import com.muzammilpeer.baselayer.adapter.SimpleRecyclerViewAdapter;
import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.logic.HomeServicesDataSource;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muzammilpeer on 03/11/2017.
 */

public class MultiSelectControllCell extends BaseCell {

    TextView titleTextView;
    TextView subTitleTextView;
    RecyclerView multipleSelectionRecyclerView;
    SimpleRecyclerViewAdapter multipleSelectionAdapter;
    List<BaseModel> localDataSources = new ArrayList<BaseModel>();


    public MultiSelectControllCell(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
        multipleSelectionRecyclerView = itemView.findViewById(R.id.multipleSelectionRecyclerView);
        final LinearLayoutManager layoutManager1 = new LinearLayoutManager(getBaseActivity());
        layoutManager1.setOrientation(LinearLayout.HORIZONTAL);
        multipleSelectionRecyclerView.setLayoutManager(layoutManager1);

        multipleSelectionAdapter = new SimpleRecyclerViewAdapter(localDataSources,IconSelectionCell.class,R.layout.cell_icon_selection);
        multipleSelectionAdapter.isMultipleSelectionAllowed = true;
        multipleSelectionRecyclerView.setAdapter(multipleSelectionAdapter);
    }

    @Override
    public void updateCell(BaseModel model) {

        if (model instanceof DynamicRowModel)
        {
            DynamicRowModel rowModel = (DynamicRowModel)model;
            Question question = (Question)rowModel.rawData;
            titleTextView.setText(question.getQuestionText());
            subTitleTextView.setText(question.getQuestionSubText());
            populateRecyclerViewAndUpdate(question);
        }
    }

    private void populateRecyclerViewAndUpdate(Question question) {
        if (question != null && question.getResponses() != null) {
            localDataSources.clear();

            for (int i=0; i< question.getResponses().size();i++) {
                localDataSources.add(question.getResponses().get(i));
            }
            multipleSelectionAdapter.notifyDataSetChanged();
        }
    }
}
