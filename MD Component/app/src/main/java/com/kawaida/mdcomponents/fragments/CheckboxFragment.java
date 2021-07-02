package com.kawaida.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
public class CheckboxFragment extends Fragment {

    public static final String TAG = "Checkbox";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.cbEnable)
    CheckBox cbEnable;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CheckboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkbox, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        cbEnable.setOnClickListener(view1 -> {
            String status = cbEnable.isChecked() ? "Activo." : "Inactivo.";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
