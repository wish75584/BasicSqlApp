package com.stubborn.basicsqlapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    Context context;
    ArrayList<Modal> list;

    public TestAdapter(Context context, ArrayList<Modal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TestAdapter.TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_test_layout, parent, false);
        context = view.getContext();

        return new TestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestHolder holder, int position) {

        holder.title.setText(list.get(position).getNoteId());
        holder.body.setText(list.get(position).getNoteBody());
        holder.time.setText((int) list.get(position).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TestHolder extends RecyclerView.ViewHolder {
        TextView title, body, time;

        public TestHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            time = itemView.findViewById(R.id.time);


        }
    }
}
