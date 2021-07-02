package com.kawaida.mdcomponents.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
public class BottomNavigationBarFragment extends Fragment {

    public static final String TAG = "Bottom Navigation";

    private static Component mInstance;

    Unbinder mUnbinder;
    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }


    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        bottomNavigation.getOrCreateBadge(R.id.action_start);
        //bottomNavigation.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(999);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
