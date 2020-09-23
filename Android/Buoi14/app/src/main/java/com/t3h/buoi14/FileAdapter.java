package com.t3h.buoi14;

import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileHolder> {

    private File[] data;
    private LayoutInflater inflater;
    private FileItemListener listener;

    public FileAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(File[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setListener(FileItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_file, parent, false);
        return new FileHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FileHolder holder, final int position) {
        holder.bindView(data[position]);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data[position].isDirectory()) {
                        listener.onDirectoryClicked(data[position]);
                    } else {
                        listener.onFileClicked(data[position]);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.length;
    }

    public class FileHolder extends RecyclerView.ViewHolder {

        private ImageView imFile;
        private TextView tvName;
        private TextView tvDate;
        private TextView tvSize;
        private SimpleDateFormat format =
                new SimpleDateFormat("dd/MM/yyyy HH:mm");

        public FileHolder(@NonNull View itemView) {
            super(itemView);
            imFile = itemView.findViewById(R.id.im_file);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvSize = itemView.findViewById(R.id.tv_size);
        }

        public void bindView(File f) {
            if (f.isDirectory()) {
                imFile.setImageResource(R.drawable.ic_folder);
                tvSize.setText("--");
            } else {
                imFile.setImageResource(R.drawable.ic_file);
                tvSize.setText(Formatter.formatFileSize(tvSize.getContext(), f.length()));
            }
            tvName.setText(f.getName());
            tvDate.setText(format.format(f.lastModified()));
        }

    }

    public interface FileItemListener {
        void onDirectoryClicked(File f);

        void onFileClicked(File f);
    }
}
