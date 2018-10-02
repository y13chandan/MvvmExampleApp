package com.example.root.mvvmexampleapp.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.mvvmexampleapp.R;
import com.example.root.mvvmexampleapp.viewmodel.ScoreViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowCountFragment extends Fragment {
    @BindView(R.id.tv_count)
    TextView tvCount;
    private ScoreViewModel viewModel;

    public static ShowCountFragment newInstance() {
        ShowCountFragment fragment = new ShowCountFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_count, container, false);
        ButterKnife.bind(this, view);
        viewModel = ViewModelProviders.of(getActivity()).get(ScoreViewModel.class);
        viewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                tvCount.setText(""+integer);
            }
        });
        return view;
    }

}
