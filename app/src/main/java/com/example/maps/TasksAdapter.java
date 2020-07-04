package com.example.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {
    private Context context ;
    private List<List<String>> tasks ;

    public TasksAdapter(Context context, List<List<String>> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TasksViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task_desc, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        setupActivitiesList(holder, tasks.get(position));
    }

    private void setupActivitiesList(TasksViewHolder holder, List<String> names) {
        holder.activitiesList.setLayoutManager(new LinearLayoutManager(context));
        holder.activitiesList.setAdapter(new ActivitiesAdapter(context, names));
        holder.activitiesList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    public class TasksViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView activitiesList ;

        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            activitiesList = (RecyclerView) itemView.findViewById(R.id.RV_task);
        }
    }

}
