package com.muzammilpeer.servishero.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.muzammilpeer.baselayer.utils.Log4a;
import com.muzammilpeer.servishero.R;

/**
 * Created by muzammilpeer on 03/11/2017.
 */

public class PopupFragmentBottomSheet extends BottomSheetDialogFragment {

    public TextView popupContentTextView;
    public ImageView popupIconImageView;
    public Button dismissButton;



    private BottomSheetBehavior bottomSheetBehavior ;


    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            switch (newState) {

                case BottomSheetBehavior.STATE_COLLAPSED:{

                    Log4a.d("BSB","collapsed") ;
                }
                case BottomSheetBehavior.STATE_SETTLING:{

                    Log4a.d("BSB","settling") ;
                }
                case BottomSheetBehavior.STATE_EXPANDED:{

                    Log4a.d("BSB","expanded") ;
                }
                case BottomSheetBehavior.STATE_HIDDEN: {

                    Log4a.d("BSB" , "hidden") ;
                    dismiss();
                }
                case BottomSheetBehavior.STATE_DRAGGING: {

                    Log4a.d("BSB","dragging") ;
                }
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            Log4a.d("BSB","sliding " + slideOffset ) ;
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.bottomsheet_popup_fragment, null);
        dialog.setContentView(contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if( behavior != null && behavior instanceof BottomSheetBehavior ) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
        bottomSheetBehavior = BottomSheetBehavior.from((View) contentView.getParent());
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);


        contentView.measure(0, 0);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        // Calculate ActionBar height
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }

        int screenHeight = displaymetrics.heightPixels;

        bottomSheetBehavior.setPeekHeight(screenHeight);

        params.height = screenHeight;
        View parent = (View) contentView.getParent();
        parent.setLayoutParams(params);

        //create views
        popupContentTextView = contentView.findViewById(R.id.popupContentTextView);
        popupIconImageView = contentView.findViewById(R.id.popupIconImageView);
        dismissButton = contentView.findViewById(R.id.dismissButton);

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView  = super.onCreateView(inflater,container,savedInstanceState);

        if (getArguments() != null) {
            Bundle mArgs = getArguments();

            if (mArgs.getString("content") != null) {
                makeSpannableString(mArgs.getString("content"));
            }

            if (mArgs.getString("image") != null) {

                Ion.with(popupIconImageView)
                        .placeholder(R.drawable.ic_landscape_black_24dp)
                        .error(R.drawable.ic_broken_image_black_24dp)
                        .load(mArgs.getString("image"));
            }

        }


        return contentView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        int screenHeight = view.getHeight();
//
//        bottomSheetBehavior.setPeekHeight(screenHeight);
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams();
//
//        params.height = screenHeight;
//        View parent = (View) view.getParent();
//        parent.setLayoutParams(params);



    }

    private void makeSpannableString(String orignalText)
    {
        Drawable goButtonDrawable = getActivity().getResources().getDrawable(R.drawable.ic_stop_black_18dp);
        goButtonDrawable.setBounds(0, 0, goButtonDrawable.getIntrinsicWidth(), goButtonDrawable.getIntrinsicHeight());

        CharSequence fullSpannableString = "";
        String[] allParts = orignalText.split("\n");


        for (int i=0;i<allParts.length;i++)
        {
            if (allParts[i].contains("[") && allParts[i].contains(":]") )
            {
                fullSpannableString = TextUtils.concat(fullSpannableString,allParts[i]).toString() + "\n\r\n\r";

            }else {
                //bullets

                String text = "[GO]" + allParts[i] +" \n\r";
                String replace = "[GO]";
                final int index = text.indexOf(replace);
                final int endIndex = index + replace.length();

                Log4a.e("string ",allParts[i]);

                final ImageSpan imageSpan = new ImageSpan(goButtonDrawable, ImageSpan.ALIGN_BASELINE);
                SpannableString spannedText = new SpannableString(text);
                spannedText.setSpan(imageSpan, index, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                fullSpannableString = TextUtils.concat(fullSpannableString,spannedText);
//                popupContentTextView.setText(TextUtils.concat(fullSpannableString,spannedText));

            }


        }
        //at the end
        popupContentTextView.setText(fullSpannableString);

        popupContentTextView.setTransformationMethod(null);


    }

    @Override
    public void onCancel(DialogInterface dialog)
    {
//        super.onCancel(dialog);
    }


}
