package com.example.expense_manager112;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterIncome extends RecyclerView.Adapter<MyAdapterIncome.MyViewHolder> {

    Context contextIncome;
    ArrayList<UserIncome> userinc;

    public MyAdapterIncome(Context contextIncome, ArrayList<UserIncome> userinc) {
        this.contextIncome = contextIncome;
        this.userinc = userinc;
    }

    public MyAdapterIncome(ArrayList<UserIncome> userinc) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View n= LayoutInflater.from(contextIncome).inflate(R.layout.item_income,parent, false);
        return new MyViewHolder(n);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        UserIncome userIncome=userinc.get(position);
        myViewHolder.inc_type.setText(userIncome.getInc_type());
        myViewHolder.inc_amount.setText(userIncome.getInc_amount());
        myViewHolder.inc_date.setText(userIncome.getInc_date());

    }

    @Override
    public int getItemCount() {
        return userinc.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView inc_type,inc_amount,inc_date;

        public MyViewHolder(@NonNull View item_incomeView) {
            super(item_incomeView);

            inc_type=itemView.findViewById(R.id.tvincometype);
            inc_amount=itemView.findViewById(R.id.tvincomeamount);
            inc_date=itemView.findViewById(R.id.tvincomedate);
        }
    }
}
