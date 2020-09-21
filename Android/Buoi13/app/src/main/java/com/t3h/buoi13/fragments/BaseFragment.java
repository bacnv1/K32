package com.t3h.buoi13.fragments;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getClass().getName(),  "onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(getClass().getName(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(), "onDestroy");
    }
}
