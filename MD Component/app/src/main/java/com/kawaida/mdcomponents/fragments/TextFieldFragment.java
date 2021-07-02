package com.kawaida.mdcomponents.fragments;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kawaida.mdcomponents.R;
import com.kawaida.mdcomponents.utils.Component;
import com.kawaida.mdcomponents.utils.Constants;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFieldFragment extends Fragment {

    public static final String TAG = "Text Fields";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;
    @BindView(R.id.tilCapitalLetter)
    TextInputLayout tilCapitalLetter;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }


    public TextFieldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_filed, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        tilCapitalLetter.setEndIconOnClickListener(view1 -> {
            if (etCapitalLetter.getText() != null){
                String contentStr = etCapitalLetter.getText().toString();
                etCapitalLetter.setText(contentStr.toUpperCase());
            }
        });

        etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty() && Integer.valueOf(editable.toString()) < 5){
                    etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
