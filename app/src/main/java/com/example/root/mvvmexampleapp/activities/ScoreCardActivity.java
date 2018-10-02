package com.example.root.mvvmexampleapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.mvvmexampleapp.R;
import com.example.root.mvvmexampleapp.ui.SetScoreFragment;
import com.example.root.mvvmexampleapp.ui.ShowCountFragment;

import butterknife.ButterKnife;

public class ScoreCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        addFragment(R.id.set_fragment, SetScoreFragment.newInstance());
        addFragment(R.id.show_fragment, ShowCountFragment.newInstance());
    }

    public void addFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(layoutId, fragment);
        ft.commitAllowingStateLoss();
    }

}
