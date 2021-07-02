package com.kawaida.mdcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.kawaida.mdcomponents.adapters.ComponentAdapter;
import com.kawaida.mdcomponents.fragments.BottomNavigationBarFragment;
import com.kawaida.mdcomponents.fragments.ButtonFragment;
import com.kawaida.mdcomponents.fragments.CheckboxFragment;
import com.kawaida.mdcomponents.fragments.FloatingActionButtonFragment;
import com.kawaida.mdcomponents.fragments.SnackBarFragment;
import com.kawaida.mdcomponents.fragments.TextFieldFragment;
import com.kawaida.mdcomponents.utils.Component;
import com.kawaida.mdcomponents.utils.Constants;
import com.kawaida.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    RecyclerView recyclerView;
    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckboxFragment.getmInstance());
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(Component component) {
        Intent intent;
        if(component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollingActivity.class);
        }else{
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}