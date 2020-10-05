package com.hanabi.thithu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hanabi.thithu.adapter.MessageAdapter;
import com.hanabi.thithu.api.Api;
import com.hanabi.thithu.api.ApiBuilder;
import com.hanabi.thithu.models.Message;
import com.hanabi.thithu.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMessenga extends AppCompatActivity implements Callback<List<Message>>, View.OnClickListener {

    private MessageAdapter adapter;
    private RecyclerView recyclerView;
    private EditText edtMessage;
    private ImageView imSend;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_messenga);
        user = (User) getIntent().getSerializableExtra(User.class.getName());

        recyclerView = findViewById(R.id.rv_mess);

        adapter = new MessageAdapter(getLayoutInflater(), user);
        recyclerView.setAdapter(adapter);
        loadData();

        edtMessage = findViewById(R.id.edt_mess);
        imSend = findViewById(R.id.iv_send);
        imSend.setOnClickListener(this);
    }

    private void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ApiBuilder.getInstance().getChat()
                            .enqueue(ListMessenga.this);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
        adapter.setData(new ArrayList<>(response.body()));
    }

    @Override
    public void onFailure(Call<List<Message>> call, Throwable t) {

    }

    @Override
    public void onClick(View view) {
        String message = edtMessage.getText().toString();
        if (message.isEmpty()) return;
        ApiBuilder.getInstance().chat(user.getUserName(), message)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        edtMessage.setText("");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(ListMessenga.this,
                                t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}