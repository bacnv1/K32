package com.t3h.buoi7.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.t3h.buoi7.R;

public class GameButton extends AppCompatTextView implements View.OnClickListener {
    private GameButton questionButton;

    public GameButton(@NonNull Context context) {
        super(context);
        init();
    }

    public GameButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.ic_tile_hover);
        setOnClickListener(this);
        setGravity(Gravity.CENTER);
        setPadding(-40, 0, 0, 0);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextColor(Color.WHITE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float w = getContext().getResources().getDisplayMetrics().widthPixels;
        float size = w / 9;
        setMeasuredDimension((int)size, (int)size);
    }

    public void setText(GameButton questionButton) {
        super.setText(questionButton.getText());
        questionButton.setVisibility(INVISIBLE);
        this.questionButton = questionButton;
    }

    @Override
    public void onClick(View v) {
        if (getText().toString().isEmpty()) return;
        if (questionButton == null) {
            setVisibility(INVISIBLE);
        } else {
            questionButton.setText(getText());
            setText("");
            questionButton.setVisibility(VISIBLE);
        }
    }

    public void showResult(boolean isCorrect) {
        if (isCorrect) {
            setBackgroundResource(R.drawable.ic_tile_true);
        } else {
            setBackgroundResource(R.drawable.ic_tile_false);
        }
    }

    public void clear() {
        setText("");
        setBackgroundResource(R.drawable.ic_tile_hover);
    }
}
