package com.kawaida.mdcomponents.utils;

import com.kawaida.mdcomponents.fragments.BottomNavigationBarFragment;
import com.kawaida.mdcomponents.fragments.ButtonFragment;
import com.kawaida.mdcomponents.fragments.CheckboxFragment;
import com.kawaida.mdcomponents.fragments.FloatingActionButtonFragment;
import com.kawaida.mdcomponents.fragments.SnackBarFragment;
import com.kawaida.mdcomponents.fragments.TextFieldFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CheckboxFragment.TAG:
                fragment = new CheckboxFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
        }

        return fragment;
    }
}
