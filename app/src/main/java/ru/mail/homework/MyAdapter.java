package ru.mail.homework;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Integer> mData;
    private LayoutInflater mInflater;
    private Context context;

    MyAdapter(Context context, ArrayList<Integer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.numbers_layout, parent, false);
        return new ViewHolder(view);
    }

    public void toActivity(String number, int color) {
        if (context instanceof NumberViewer) {
            ((NumberViewer) context).fromFragmentData(number, color);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.myTextView.setText(String.valueOf(mData.get(position)));
        if (mData.get(position) % 2 == 0) {
            holder.myTextView.setTextColor(ContextCompat.getColor(context, R.color.red));

        } else {
            holder.myTextView.setTextColor(ContextCompat.getColor(context, R.color.blue));
        }
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(String.valueOf(holder.myTextView.getText()), holder.myTextView.getCurrentTextColor());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
        }
    }
}