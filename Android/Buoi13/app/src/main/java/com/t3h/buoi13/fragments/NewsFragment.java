package com.t3h.buoi13.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.t3h.buoi13.MainActivity;
import com.t3h.buoi13.R;

public class NewsFragment extends BaseFragment implements View.OnClickListener {

    private EditText edtContent;
    private Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edtContent = getActivity().findViewById(R.id.edt_content);
        btnSave = getActivity().findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String content = edtContent.getText().toString();
        MainActivity act = (MainActivity) getActivity();
        act.getFmSaved().setData(content);
        act.getViewPager().setCurrentItem(1);
    }
}
