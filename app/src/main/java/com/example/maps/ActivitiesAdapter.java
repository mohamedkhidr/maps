package com.example.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivityNamesViewHolder> {
    private Context context ;
    private List<String> activityNames ;

    public ActivitiesAdapter(Context context, List<String> activityNames) {
        this.context = context;
        this.activityNames = activityNames;
    }

    @NonNull
    @Override
    public ActivityNamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActivityNamesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_activity_desc, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityNamesViewHolder holder, int position) {
        holder.activityName.setText(activityNames.get(position));
    }

    

    @Override
    public int getItemCount() {
        return activityNames.size();
    }


    public class ActivityNamesViewHolder extends RecyclerView.ViewHolder{
        private TextView activityName ;

        public ActivityNamesViewHolder(@NonNull View itemView) {
            super(itemView);
            activityName = (TextView) itemView.findViewById(R.id.TV_activity_name);
        }
    }

}
