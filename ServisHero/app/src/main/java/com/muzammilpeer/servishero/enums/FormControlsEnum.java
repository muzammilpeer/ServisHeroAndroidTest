package com.muzammilpeer.servishero.enums;

import android.annotation.SuppressLint;

import com.muzammilpeer.servishero.R;
import com.muzammilpeer.servishero.cell.MultiSelectControllCell;
import com.muzammilpeer.servishero.cell.PopupControllCell;
import com.muzammilpeer.servishero.cell.SingleChoiceControlCell;
import com.muzammilpeer.servishero.cell.StepperControlCell;
import com.muzammilpeer.servishero.cell.TextFieldControlCell;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muzammilpeer on 02/11/2017.
 */
@SuppressLint("UseSparseArrays")
public enum FormControlsEnum {
    SINGLE_CHOICE(0,1, SingleChoiceControlCell.class, R.layout.cell_single_choice_control),
    STEPPER(1,4,StepperControlCell.class, R.layout.cell_stepper_control),
    POPUP(2,7,PopupControllCell.class, R.layout.cell_popup_control),
    MULTI_ICON_SELECT(3,5,MultiSelectControllCell.class, R.layout.cell_multi_icon_control),
    EDIT_TEXT(4,3,TextFieldControlCell.class, R.layout.cell_textfield_control)

    ;// semicolon needed when fields / methods follow

    private int code;
    private int objectId;
    private Class cellClass;
    private int resourceId;


    /**
     * A mapping between the integer code and its corresponding Status to
     * facilitate lookup by code.
     */
    private static Map<Integer, FormControlsEnum> codeToStatusMapping;

    private FormControlsEnum(int cd,int id, Class cClass, int rId) {
        this.code = cd;
        this.objectId = id;
        this.cellClass = cClass;
        this.resourceId = rId;
    }

    public static FormControlsEnum getEnumFromObjectId(Integer id) {
        if (codeToStatusMapping == null) {
            initMapping();
        }

        for (Map.Entry<Integer, FormControlsEnum> entry : codeToStatusMapping.entrySet())
        {
            if (id == entry.getKey()) {
                return  entry.getValue();
            }
        }
        return null;
    }

    public static FormControlsEnum getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }


    @SuppressLint("UseSparseArrays")
    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, FormControlsEnum>();
        for (FormControlsEnum s : values()) {
            codeToStatusMapping.put(s.objectId, s);
        }
    }

    public int getObjectId() {
        return objectId;
    }

    public Class getCellClass() {
        return cellClass;
    }

    public int getResourceId() {
        return resourceId;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FormControlsEnum");
        sb.append("{objectId=").append(objectId);
        sb.append(", cellClass='").append(cellClass).append('\'');
        sb.append(", resourceId='").append(resourceId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}