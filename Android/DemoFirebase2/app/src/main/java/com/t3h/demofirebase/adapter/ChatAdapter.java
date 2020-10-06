package com.t3h.demofirebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.demofirebase.R;
import com.t3h.demofirebase.model.Chat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private ArrayList<Chat> data;
    private LayoutInflater inflater;

    public ChatAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Chat> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(
                R.layout.item_view,
                parent,
                false
        );
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvContent;
        private TextView tvDate;
        private SimpleDateFormat dateFormat
                = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
        }

        public void bindView(Chat chat) {
            tvContent.setText(chat.getContent());
            tvName.setText(chat.getUser());
            tvDate.setText(dateFormat.format(chat.getId()));
        }
    }


}
