package com.kawaida.mdcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.kawaida.mdcomponent.utils.CommonUtils;
import com.kawaida.mdcomponent.utils.Constants;

public class StaticActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String nameFragment = null;
        if(savedInstanceState == null){
            nameFragment = getIntent().getStringExtra(Constants.ARG_NAME);

            CommonUtils.setFragment(this, nameFragment, R.id.content_static);
        }

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(nameFragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}