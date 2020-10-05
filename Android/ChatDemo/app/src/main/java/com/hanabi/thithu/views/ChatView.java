package com.hanabi.thithu.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hanabi.thithu.R;

public class ChatView extends LinearLayout {

    private TextView tvContent;

    public ChatView(Context context) {
        super(context);
        initViews(context);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    public ChatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.message_view, this);

        final int width = context.getResources().getDisplayMetrics().widthPixels;

        tvContent = findViewById(R.id.tv_content);
        tvContent.setMaxWidth(width / 3 * 2);
    }

    public void setText(String text) {
        tvContent.setText(text);
    }

    public void setBackground(int id) {
        tvContent.setBackgroundResource(id);
    }

}
