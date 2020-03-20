package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelperRecyclerAdapter extends RecyclerView.Adapter<HelperRecyclerAdapter.ViewHolder> {

    private Context context;

    HelperRecyclerAdapter(Context applicationContext) {
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.helper_row_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        Button startTimeButton, endTimeButton, genderButton, serviceButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleText);
            startTimeButton = itemView.findViewById(R.id.startTime);
            endTimeButton = itemView.findViewById(R.id.endTime);
            genderButton = itemView.findViewById(R.id.gender);
            serviceButton = itemView.findViewById(R.id.getService);
        }
    }
}
