package com.t3h.contentprovider.adapter;

import android.net.Uri;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.t3h.contentprovider.R;
import com.t3h.contentprovider.model.Song;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private ArrayList<Song> songs;
    private LayoutInflater inflater;

    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Song> songs) {
        this.songs.addAll(songs);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        View songView = inflater.inflate(
                R.layout.item_song, parent);
        return new ViewHolder(songView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull SongAdapter.ViewHolder holder,
            int position) {
        holder.setDataItem(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return songs!=null ? songs.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgSong;
        private TextView tvTitle,tvSize,tvAlbum,tvArtist;

        public ViewHolder(View songView) {
            super(songView);
            imgSong = songView.findViewById(R.id.img_song);
            tvTitle = songView.findViewById(R.id.tv_title);
            tvSize = songView.findViewById(R.id.tv_size);
            tvAlbum = songView.findViewById(R.id.tv_album);
            tvArtist = songView.findViewById(R.id.tv_artist);
        }

        public void setDataItem(Song song) {
            if(song!=null){
                //load image song
                Uri uri = Uri.parse(
                        "content://media/external/audio/albumart"
                                + song.getId()
                );
                Glide.with(imgSong).load(uri).into(imgSong);

                String strSize = Formatter.
                        formatFileSize(
                                tvSize.getContext(),
                                song.getSize());

                tvSize.setText(strSize);
                tvTitle.setText(song.getTitle());
                tvArtist.setText(song.getArtist());
                tvAlbum.setText(song.getAlbum());
            }
        }
    }
}
