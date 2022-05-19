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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Expense extends AppCompatActivity {

    EditText ExpenseType,ExpenseAmount;
    TextView ExpenseDate;
    DatePickerDialog.OnDateSetListener setListener;
    Button btnSubmit,btnBackExp;
    int max_id= 0;
    DatabaseReference reference;
    Expense_Data expense_data;
    FirebaseAuth mFirebaseAuth;
     FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        ExpenseDate=findViewById(R.id.expense_date);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        ExpenseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        Expense.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                ExpenseDate.setText(date);
            }
        };
        btnBackExp=findViewById(R.id.button6);
        btnBackExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intExpBack=new Intent(Expense.this, HomeActivity.class);
                startActivity(intExpBack);
            }
        });

        ExpenseType=(EditText)findViewById(R.id.expense_type);
        ExpenseAmount=(EditText)findViewById(R.id.expense_amount);
        ExpenseDate=(TextView)findViewById(R.id.expense_date);
        btnSubmit=(Button)findViewById(R.id.submit_expense);
        expense_data=new Expense_Data();
        reference=FirebaseDatabase.getInstance().getReference().child("Expense_Data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    max_id=(int) (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense_data.setExp_type(ExpenseType.getText().toString().trim());
                expense_data.setExp_date(ExpenseDate.getText().toString().trim());
                expense_data.setExp_amount(ExpenseAmount.getText().toString().trim());
                reference.child(String.valueOf(max_id+1)).setValue(expense_data);

                ExpenseAmount.setText("");
                ExpenseType.setText("");
                ExpenseDate.setText("");
                Toast.makeText(Expense.this, "Submit Data Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

}