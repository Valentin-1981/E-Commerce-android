package com.testproject.e_commerce.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.testproject.e_commerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<> {

    Context context;
    List<Course> courses;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
