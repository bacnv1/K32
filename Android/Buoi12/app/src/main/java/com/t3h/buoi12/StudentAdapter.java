package com.t3h.buoi12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi12.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder>{

    private LayoutInflater inflater;
    private List<Student> data;
    private StudentItemLister lister;

    public StudentAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setLister(StudentItemLister lister) {
        this.lister = lister;
    }

    public void setData(List<Student> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_student, parent, false);
        return new StudentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {
        holder.bindView(data.get(position));
        if (lister != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lister.onItemClicked(data.get(position));
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    lister.onItemLongClicked(data.get(position));
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvSubject;
        private TextView tvScore;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvScore = itemView.findViewById(R.id.tv_score);
            tvSubject = itemView.findViewById(R.id.tv_subject);
        }

        public void bindView(Student student) {
            tvSubject.setText(student.getSubject());
            tvName.setText(student.getName());
            tvScore.setText(student.getScore() + "");
        }
    }

    public interface StudentItemLister {
        void onItemClicked(Student student);
        void onItemLongClicked(Student student);
    }
}
