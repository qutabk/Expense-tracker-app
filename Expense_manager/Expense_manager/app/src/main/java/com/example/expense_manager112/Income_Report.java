package com.example.expense_manager112;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Income_Report extends AppCompatActivity {

    RecyclerView recView;
    DatabaseReference databaseref;
    MyAdapterIncome myAdapterIncome;
    ArrayList<UserIncome> userinc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income__report);

        recView=findViewById(R.id.rec_view_income);
        databaseref= FirebaseDatabase.getInstance().getReference("Income_Data");
        recView.setHasFixedSize(true);
        recView.setLayoutManager(new LinearLayoutManager(this));

        userinc=new ArrayList<>();
        myAdapterIncome=new MyAdapterIncome(this,userinc);
        recView.setAdapter(myAdapterIncome);

        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    UserIncome userIncome=dataSnapshot.getValue(UserIncome.class);
                    userinc.add(userIncome);

                }
                myAdapterIncome.notifyDataSetChanged();
                myAdapterIncome= new MyAdapterIncome(userinc);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}