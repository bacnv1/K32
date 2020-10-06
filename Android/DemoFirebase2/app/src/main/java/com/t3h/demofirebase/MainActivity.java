package com.t3h.demofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t3h.demofirebase.adapter.ChatAdapter;
import com.t3h.demofirebase.model.Chat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnFailureListener, OnSuccessListener<Void>, ValueEventListener {

    private RecyclerView rcChat;
    private ImageView imSend;
    private EditText edtContent;
    private ChatAdapter adapter;

    private DatabaseReference reference = FirebaseDatabase.getInstance()
            .getReference("chat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        reference.addValueEventListener(this);
    }

    private void initViews() {
        rcChat = findViewById(R.id.rc_chat);
        imSend = findViewById(R.id.im_send);
        edtContent = findViewById(R.id.edt_content);
        adapter = new ChatAdapter(getLayoutInflater());
        rcChat.setAdapter(adapter);

        imSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String content = edtContent.getText().toString();
        if (content.isEmpty()) return;
        Chat chat = new Chat();
        chat.setContent(content);
        chat.setUser("BacNV");
        reference.child(chat.getId() + "").setValue(chat)
                .addOnFailureListener(this)
                .addOnSuccessListener(this);
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(this, e.getMessage()
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Void aVoid) {
        edtContent.setText("");
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        ArrayList<Chat> data = new ArrayList<>();
        for (DataSnapshot s : snapshot.getChildren()) {
            Chat c = s.getValue(Chat.class);
            data.add(c);
        }
        adapter.setData(data);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}