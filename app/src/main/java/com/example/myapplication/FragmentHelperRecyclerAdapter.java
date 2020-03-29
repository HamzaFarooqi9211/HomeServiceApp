package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

class FragmentHelperRecyclerAdapter extends RecyclerView.Adapter<FragmentHelperRecyclerAdapter.ViewHolder> {
    private Context context;

    public FragmentHelperRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.helper_notification_row_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView notify;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            notify = itemView.findViewById(R.id.notify);
            layout = itemView.findViewById(R.id.card);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog();
                }
            });
        }

        private void openDialog() {
            FragmentHelperDialog dialog = new FragmentHelperDialog();
            dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "User Details");

        }
    }
}
