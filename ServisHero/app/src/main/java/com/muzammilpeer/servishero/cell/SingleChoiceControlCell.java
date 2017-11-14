package com.muzammilpeer.servishero.cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.fragment.PopupFragmentBottomSheet;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.Response;

/**
 * Created by muzammilpeer on 02/11/2017.
 */

public class SingleChoiceControlCell extends BaseCell {

    RadioGroup optionsRadioGroup;
    TextView questionTextView;



    public SingleChoiceControlCell(View itemView) {
        super(itemView);
        questionTextView = itemView.findViewById(R.id.questionTextView);
        optionsRadioGroup = itemView.findViewById(R.id.optionRadioGroup);
    }

    @Override
    public void updateCell(BaseModel model) {
        mDataSource = model;

        if (model instanceof DynamicRowModel)
        {
            DynamicRowModel rowModel = (DynamicRowModel)model;
            Question question = (Question)rowModel.rawData;
            createQuestionWithToolTip(question);
            createRadioOptionViews(question);
        }
    }

    private void  createQuestionWithToolTip(Question question)
    {
        if (question.getIsTooltip() == true ) {
            Drawable goButtonDrawable = getBaseActivity().getResources().getDrawable(R.drawable.information_tool_tip);
            goButtonDrawable.setBounds(0, 0, goButtonDrawable.getIntrinsicWidth(), goButtonDrawable.getIntrinsicHeight());


            String text = question.getQuestionText();
            String replace = "";
            if (question.getIsTooltip() == true ) {
                replace = "[GO]";
                text = question.getQuestionText() +  " [GO]";
            }


            final int index = text.indexOf(replace);
            final int endIndex = index + replace.length();

            final ImageSpan imageSpan = new ImageSpan(goButtonDrawable, ImageSpan.ALIGN_BASELINE);

            final ClickableSpan clickSpan = new ClickableSpan() {
                @Override public void onClick(View clicked) {
                    // Do your [GO] action
                    showInputNameDialog();

                }
            };

            SpannableString spannedText = new SpannableString(text);
            spannedText.setSpan(imageSpan, index, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannedText.setSpan(clickSpan, index, endIndex , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            questionTextView.setText(spannedText);
            questionTextView.setTransformationMethod(null);
            questionTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }else {
            questionTextView.setText(question.getQuestionText());
        }
    }

    private void showInputNameDialog() {

        DynamicRowModel rowModel = (DynamicRowModel)mDataSource;
        Question question = (Question)rowModel.rawData;


        PopupFragmentBottomSheet fragmentModalBottomSheet = new PopupFragmentBottomSheet();


        Bundle args = new Bundle();
        args.putString("content", question.getTooltipText());
        args.putString("image", question.getTooltipImageUrl());
        fragmentModalBottomSheet.setArguments(args);
        fragmentModalBottomSheet.show(getBaseActivity().getSupportFragmentManager(),"BottomSheet Fragment");

    }



    private void createRadioOptionViews(Question question) {
        if (question != null && question.getResponses() != null) {
            for (Response choice : question.getResponses()) {
                RadioButton radioButton = (RadioButton) ((LayoutInflater) getBaseActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_radio_button, null);
                radioButton.setId(choice.getId());
                radioButton.setTextColor(getBaseActivity().getResources().getColor(R.color.gray));
                radioButton.setText(choice.getResponseText());
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);

                radioButton.setLayoutParams(param);

                optionsRadioGroup.addView(radioButton);
                optionsRadioGroup.setVisibility(View.VISIBLE);
            }
        }
    }
}
