package com.t3h.buoi8;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder>{

    private ArrayList<Face> data;
    private LayoutInflater inflater;
    private FaceItemListener listener;

    public FaceAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Face> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<Face> getData() {
        return data;
    }

    public void setListener(FaceItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(
                R.layout.item_face,
                parent,
                false
        );
        return new FaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceAdapter.FaceHolder holder, int position) {
        final Face face = data.get(position);
        holder.bindData(face);
        Log.e(getClass().getName(), position + "");
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFaceItemClicked(face);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onFaceItemLongClicked(face);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {
        private ImageView imFace;
        private TextView tvName;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            imFace = itemView.findViewById(R.id.im_face);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindData(Face face) {
            imFace.setImageResource(face.getResId());
            tvName.setText(face.getName());
            if (face.isSelected()) {
                itemView.setBackgroundColor(Color.GRAY);
            } else {
                itemView.setBackgroundColor(Color.WHITE);
            }
        }
    }

    public interface FaceItemListener {
        void onFaceItemClicked(Face face);
        void onFaceItemLongClicked(Face face);
    }
}
