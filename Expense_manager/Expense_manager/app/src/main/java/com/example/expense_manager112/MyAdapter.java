package com.example.expense_manager112;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter(ArrayList<User> list) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {

        User user=list.get(position);
        holder.exp_type.setText(user.getExp_type());
        holder.exp_amount.setText(user.getExp_amount());
        holder.exp_date.setText(user.getExp_date());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView exp_type,exp_amount,exp_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            exp_type=itemView.findViewById(R.id.tvexpensetype);
            exp_amount=itemView.findViewById(R.id.tvexpenseamount);
            exp_date=itemView.findViewById(R.id.tvexpensedate);

        }
    }
}
