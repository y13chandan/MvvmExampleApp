package com.example.root.mvvmexampleapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.mvvmexampleapp.R;
import com.example.root.mvvmexampleapp.viewmodel.ScoreViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetScoreFragment extends Fragment {
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.btn_increment)
    Button btnIncrement;

    private int count;
    private ScoreViewModel viewModel;

    public static SetScoreFragment newInstance() {
        SetScoreFragment fragment = new SetScoreFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_score, container, false);
        ButterKnife.bind(this, view);
        viewModel = ViewModelProviders.of(getActivity()).get(ScoreViewModel.class);
        if (viewModel.getCount().getValue() != null) {
            count = viewModel.getCount().getValue();
        } else {
            count = 0;
        }
        return view;
    }

    @OnClick(R.id.btn_increment)
    public void onClick() {
        viewModel.setCount(++count);
    }

}
