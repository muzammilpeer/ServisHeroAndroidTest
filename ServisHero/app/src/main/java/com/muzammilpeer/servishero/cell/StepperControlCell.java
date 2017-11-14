package com.muzammilpeer.servishero.cell;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.Response;

import java.util.List;

/**
 * Created by muzammilpeer on 02/11/2017.
 */

public class StepperControlCell extends BaseCell implements  View.OnClickListener{


    ImageButton minusButton;
    ImageButton plusButton;
    TextView numberStepperTextView;
    TextView questionTextView;


    private int stepperCurrentValue = 1;
    private int minValue = 1;
    private int maxValue = 1;

    public StepperControlCell(View itemView) {
        super(itemView);
        minusButton = baseView.findViewById(R.id.decrementImageButton);
        plusButton = baseView.findViewById(R.id.incrementImageButton);
        numberStepperTextView = baseView.findViewById(R.id.numericStepperTextView);
        questionTextView = baseView.findViewById(R.id.questionTextView);

        minusButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);

    }

    @Override
    public void updateCell(BaseModel model) {

        if (model instanceof DynamicRowModel)
        {
            DynamicRowModel rowModel = (DynamicRowModel)model;
            Question question = (Question)rowModel.rawData;
            questionTextView.setText(question.getQuestionText());
            setupNumbericStepper(question.getResponses());
        }

    }

    private void  setupNumbericStepper(List<Response> values)
    {
        minValue = getMinValueForResponses(values);
        maxValue = getMaxValueForResponses(values);
    }

    private Integer getMinValueForResponses(List<Response> values){
        Integer currentMin = 100000000;
        for (int i=0;i<values.size();i++) {

            Response model = values.get(i);

            if (currentMin > Integer.parseInt(model.getResponseValue()))
            {
                currentMin = Integer.parseInt(model.getResponseValue());
            }
        }
        return currentMin;
    }

    private Integer getMaxValueForResponses(List<Response> values){
        Integer currentMax = 0;

        for (int i=0;i<values.size();i++) {

            Response model = values.get(i);

            if (currentMax < Integer.parseInt(model.getResponseValue()))
            {
                currentMax = Integer.parseInt(model.getResponseValue());
            }
        }
        return currentMax;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.incrementImageButton : {

                if (stepperCurrentValue >=maxValue)
                {
                    stepperCurrentValue = maxValue;
                }else {
                    stepperCurrentValue++;
                }
                numberStepperTextView.setText(""+stepperCurrentValue);
            } break;
            case R.id.decrementImageButton : {

                if (stepperCurrentValue <= minValue)
                {
                    stepperCurrentValue = minValue;
                }else {
                    stepperCurrentValue--;
                }
                numberStepperTextView.setText(""+stepperCurrentValue);
            } break;

        }
    }
}
