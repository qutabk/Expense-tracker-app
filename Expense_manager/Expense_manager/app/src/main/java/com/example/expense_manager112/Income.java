package com.example.expense_manager112;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Income extends AppCompatActivity {

    EditText IncomeType,IncomeAmount;
    TextView tvDateIncome;
    DatePickerDialog.OnDateSetListener setListener;
    Button btnSubmitIncome,btnBack;
    int max_id_income=0;
    DatabaseReference ref;
    Income_Data income_data;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        tvDateIncome=findViewById(R.id.tv_date_income);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        tvDateIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        Income.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                tvDateIncome.setText(date);
            }
        };
        btnBack=findViewById(R.id.button5);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intIncomeBack=new Intent(Income.this, HomeActivity.class);
                startActivity(intIncomeBack);
            }
        });

        IncomeType=(EditText)findViewById(R.id.income_type);
        IncomeAmount=(EditText)findViewById(R.id.income_amount);
        tvDateIncome=(TextView)findViewById(R.id.tv_date_income);
        btnSubmitIncome=(Button)findViewById(R.id.submit_income);
        income_data=new Income_Data();
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        ref=FirebaseDatabase.getInstance().getReference().child("Income_Data");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    max_id_income=(int) (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSubmitIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income_data.setInc_type(IncomeType.getText().toString().trim());
                income_data.setInc_date(tvDateIncome.getText().toString().trim());
                income_data.setInc_amount(IncomeAmount.getText().toString().trim());
                ref.child(String.valueOf(max_id_income+1)).setValue(income_data);

                IncomeAmount.setText("");
                IncomeType.setText("");
                tvDateIncome.setText("");
                Toast.makeText(Income.this, "Submit Data Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}