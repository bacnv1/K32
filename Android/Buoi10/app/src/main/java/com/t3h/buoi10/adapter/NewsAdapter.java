package com.t3h.buoi10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.buoi10.R;
import com.t3h.buoi10.models.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(
                R.layout.item_view,
                parent,
                false
        );
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView imNews;
        private TextView tvName;
        private TextView tvDesc;
        private TextView tvDate;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imNews = itemView.findViewById(R.id.im_news);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvDate = itemView.findViewById(R.id.tv_date);
        }

        public void bindData(News news) {
            tvName.setText(news.getTitle());
            tvDesc.setText(news.getDesc());
            tvDate.setText(news.getPubDate());
            Glide.with(imNews)
                    .load(news.getImage())
                    .into(imNews);
        }
    }
}
