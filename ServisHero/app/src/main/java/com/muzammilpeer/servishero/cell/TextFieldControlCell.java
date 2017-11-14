package com.muzammilpeer.servishero.cell;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.models.Question;

/**
 * Created by muzammilpeer on 02/11/2017.
 */

public class TextFieldControlCell extends BaseCell {


    TextView titleTextView;
    TextView subTitleTextView;
    EditText commentsEditText;

    public TextFieldControlCell(View itemView) {
        super(itemView);

        titleTextView = baseView.findViewById(R.id.titleTextView);
        subTitleTextView = baseView.findViewById(R.id.subTitleTextView);
        commentsEditText = baseView.findViewById(R.id.commentsEditText);
    }



    @Override
    public void updateCell(BaseModel model) {
        if (model instanceof DynamicRowModel)
        {
            DynamicRowModel rowModel = (DynamicRowModel)model;
            Question question = (Question)rowModel.rawData;
            titleTextView.setText(question.getQuestionText());
            subTitleTextView.setText(question.getQuestionSubText());
        }
    }
}
