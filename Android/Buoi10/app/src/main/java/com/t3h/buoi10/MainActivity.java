package com.t3h.buoi10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.t3h.buoi10.adapter.NewsAdapter;
import com.t3h.buoi10.api.ApiBuilder;
import com.t3h.buoi10.models.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsResponse> {
    private NewsAdapter adapter;
    private RecyclerView rcNews;
    private EditText edtSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        adapter = new NewsAdapter(getLayoutInflater());
        rcNews = findViewById(R.id.rc_news);
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);

        rcNews.setAdapter(adapter);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String key = edtSearch.getText().toString();
        if (key.isEmpty()) {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiBuilder.getInstance().getNews(
                key,
                "f70e06a71e524dfa86dbfcf7ca38e62f",
                "vi"
        ).enqueue(this);
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        adapter.setData(response.body().getNews());
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Toast.makeText(this,
                t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}