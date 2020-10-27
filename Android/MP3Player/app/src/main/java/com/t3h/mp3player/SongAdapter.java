package com.t3h.mp3player;

import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {
    private ArrayList<Song> data;
    private LayoutInflater inflater;
    private SongItemListener listener;

    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(SongItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_song, parent, false);
        return new SongHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, final int position) {
        holder.bindData(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvAlbum;
        private TextView tvArtist;
        private TextView tvSize;
        private TextView tvDuration;

        public SongHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAlbum = itemView.findViewById(R.id.tv_album);
            tvArtist = itemView.findViewById(R.id.tv_artist);
            tvSize = itemView.findViewById(R.id.tv_size);
            tvDuration = itemView.findViewById(R.id.tv_duration);
        }

        public void bindData(Song song) {
            tvTitle.setText(song.getTitle());
            tvAlbum.setText(song.getAlbum());
            tvArtist.setText(song.getArtist());
            tvSize.setText(Formatter.formatFileSize(itemView.getContext(),
                    song.getSize()));
            SimpleDateFormat format = new SimpleDateFormat("mm:ss");
            tvDuration.setText(format.format(song.getDuration()));
        }
    }

    public interface SongItemListener {
        void onItemClicked(int position);
    }
}
