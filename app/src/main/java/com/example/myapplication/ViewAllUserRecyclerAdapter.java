package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAllUserRecyclerAdapter extends RecyclerView.Adapter<ViewAllUserRecyclerAdapter.ViewHolder> {

    private Context context;

    ViewAllUserRecyclerAdapter(Context applicationContext) {
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.alluser_row_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, phone;
        ImageView closeButton;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            closeButton = itemView.findViewById(R.id.close);
            layout = itemView.findViewById(R.id.card);

            layout.setOnClickListener(this);
            closeButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.close:
                    break;

                case R.id.card:
                    openDialog();
                    break;
            }
        }

        private void openDialog() {
            ViewAllUserDialog dialog = new ViewAllUserDialog();
            dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "User Details");

        }
    }
}
