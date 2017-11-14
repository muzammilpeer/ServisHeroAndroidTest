package com.muzammilpeer.servishero.cell;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.muzammilpeer.baselayer.cell.BaseCell;
import com.muzammilpeer.baselayer.model.BaseModel;
import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.Response;

/**
 * Created by muzammilpeer on 03/11/2017.
 */

public class IconSelectionCell extends BaseCell  implements  View.OnClickListener{

    ImageButton iconImageButton;
    TextView iconTextView;

    public IconSelectionCell(View itemView) {
        super(itemView);

        iconImageButton = baseView.findViewById(R.id.iconImageButton);
        iconTextView = baseView.findViewById(R.id.iconTextView);

        iconImageButton.setOnClickListener(this);
    }

    @Override
    public void updateCell(BaseModel model) {
        mDataSource = model;

        if (mDataSource instanceof Response)
        {
            Response rowModel = (Response) mDataSource;
            iconImageButton.setSelected(rowModel.isSelected);

            iconTextView.setText(rowModel.getResponseText());

            Ion.with(iconImageButton)
                    .placeholder(R.drawable.ic_landscape_black_24dp)
                    .error(R.drawable.ic_broken_image_black_24dp)
                    .load(rowModel.getImageUrl());
        }
    }

    @Override
    public void onClick(View view) {
        if (mDataSource instanceof Response)
        {
            Response rowModel = (Response) mDataSource;
            rowModel.isSelected = !rowModel.isSelected;
            iconImageButton.setSelected(rowModel.isSelected);
        }
    }
}
