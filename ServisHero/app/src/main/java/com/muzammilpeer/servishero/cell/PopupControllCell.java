package com.muzammilpeer.servishero.cell;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.fragment.PopupFragmentBottomSheet;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.Response;

/**
 * Created by muzammilpeer on 03/11/2017.
 */

public class PopupControllCell extends BaseCell implements View.OnClickListener{

    TextView questionTextView;
    ImageView iconImageView;


    public PopupControllCell(View itemView) {
        super(itemView);
        questionTextView = itemView.findViewById(R.id.questionTextView);
        iconImageView = baseView.findViewById(R.id.iconImageView);
        baseView.setOnClickListener(this);

    }

    @Override
    public void updateCell(BaseModel model) {
        mDataSource = model;

        if (mDataSource instanceof DynamicRowModel)
        {
            DynamicRowModel rowModel = (DynamicRowModel)mDataSource;
            Question question = (Question)rowModel.rawData;
            questionTextView.setText(question.getQuestionText());

            Response firstObject = question.getResponses().get(0);

            Ion.with(iconImageView)
                    .placeholder(R.drawable.ic_landscape_black_24dp)
                    .error(R.drawable.ic_broken_image_black_24dp)
                    .load(firstObject.getImageUrl());

        }
    }


    private void showInputNameDialog() {

        DynamicRowModel rowModel = (DynamicRowModel)mDataSource;
        Question question = (Question)rowModel.rawData;
        Response response = question.getResponses().get(0);


        PopupFragmentBottomSheet fragmentModalBottomSheet = new PopupFragmentBottomSheet();

        Bundle args = new Bundle();
        args.putString("content", response.getResponseText());
        args.putString("image", response.getImageUrl());
        fragmentModalBottomSheet.setArguments(args);
        fragmentModalBottomSheet.show(getBaseActivity().getSupportFragmentManager(),"BottomSheet Fragment");

    }

    @Override
    public void onClick(View view) {
        showInputNameDialog();
    }
}
