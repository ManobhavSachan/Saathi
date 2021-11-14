package com.example.saathi.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saathi.MainActivity;
import com.example.saathi.Models.ContentDetails;
import com.example.saathi.R;
import com.example.saathi.ScrollingActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    ArrayList<ContentDetails> list;
    Context context;

    public RecyclerAdapter(ArrayList<ContentDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_scheme_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int i = position;
        ContentDetails model = list.get(position);
        holder.mainTextView.setText(model.getTitle());
        holder.textView.setText(model.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ScrollingActivity.class);
                intent.putExtra("name",model.getTitle());
//                intent.putExtra("position", i);
                intent.putExtra("detail", model.getDetails());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView mainTextView, textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            mainTextView = itemView.findViewById(R.id.mainTextView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
}
