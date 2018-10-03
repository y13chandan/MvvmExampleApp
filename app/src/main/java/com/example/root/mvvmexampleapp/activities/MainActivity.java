package com.example.root.mvvmexampleapp.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.root.mvvmexampleapp.R;
import com.example.root.mvvmexampleapp.adapter.UserListAdapter;
import com.example.root.mvvmexampleapp.model.User;
import com.example.root.mvvmexampleapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView rvUserList;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        setObservers(model);
    }

    private void setObservers(UserViewModel model) {
        model.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                if (userList == null) {
                    userList = new ArrayList<>();
                }
                userList = users;
                setAdapter(userList);
            }
        });
    }

    private void setAdapter(List<User> userList) {
        if (userList != null && userList.size() > 0) {
            UserListAdapter adapter = new UserListAdapter(this, userList);
            rvUserList.setAdapter(adapter);
        }
    }

}
