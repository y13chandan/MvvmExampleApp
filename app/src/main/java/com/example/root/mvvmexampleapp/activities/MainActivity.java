package com.example.root.mvvmexampleapp.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.root.mvvmexampleapp.R;
import com.example.root.mvvmexampleapp.model.User;
import com.example.root.mvvmexampleapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setObservers();
    }

    private void setObservers() {
        UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
        model.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (userList == null) {
                    userList = new ArrayList<>();
                }
                userList = users;
            }
        });
    }

    @OnClick(R.id.tv_next_activity)
    public void onClick() {
        Intent intent = new Intent(this, ScoreCardActivity.class);
        startActivity(intent);
    }
}
