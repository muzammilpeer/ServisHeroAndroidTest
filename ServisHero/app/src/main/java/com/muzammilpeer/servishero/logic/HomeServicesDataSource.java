package com.muzammilpeer.servishero.logic;

import android.content.Context;

import com.muzammilpeer.baselayer.model.DynamicRowModel;
import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.cell.SampleCell;
import com.muzammilpeer.servishero.enums.FormControlsEnum;
import com.muzammilpeer.servishero.models.Question;
import com.muzammilpeer.servishero.models.QuestionType;
import com.muzammilpeer.servishero.models.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muzammilpeer on 02/11/2017.
 */

public class HomeServicesDataSource {

    public  static String readJsonFromLocalRawFolder(Context context)
    {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.service_detail);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return  new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }


    public  static ArrayList<DynamicRowModel> generateDataSourceForHomeServices(List<Question> questions)
    {
        ArrayList<DynamicRowModel> datasource = new ArrayList<DynamicRowModel>();

        for (Question question : questions) {

            DynamicRowModel row = new DynamicRowModel();

            QuestionType questionType = question.getQuestionType();

            FormControlsEnum currentEnum = FormControlsEnum.getEnumFromObjectId(questionType.getId());

            row.cellLayoutID = currentEnum.getResourceId();
            row.cellClazz = currentEnum.getCellClass();
            row.rawData = question;

            datasource.add(row);
        }
        return datasource;
    }

}
