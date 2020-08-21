package com.t3h.buoi6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.t3h.baitap.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_IMAGE = 1;

    private EditText edtValue;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnGallery;
    private ImageView imGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        edtValue = findViewById(R.id.edt_value);
        btnBrowser = findViewById(R.id.btn_browser);
        btnCall = findViewById(R.id.btn_call);
        btnGallery = findViewById(R.id.btn_gallery);
        imGallery = findViewById(R.id.im_gallery);
        btnGallery.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String value = edtValue.getText().toString();
        switch (v.getId()) {
            case R.id.btn_browser:
                Intent browser = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(value);
                browser.setData(uri);
                startActivity(browser);
                break;
            case R.id.btn_call:
                Intent call = new Intent(Intent.ACTION_CALL);
                Uri uriCall = Uri.parse("tel:" + value);
                call.setData(uriCall);
                startActivity(call);
                break;
            case R.id.btn_gallery:
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(gallery, "Get Image"),
                        REQUEST_IMAGE
                );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                Glide.with(this)
                        .load(data.getData())
                        .into(imGallery);
            }
        }
    }
}
