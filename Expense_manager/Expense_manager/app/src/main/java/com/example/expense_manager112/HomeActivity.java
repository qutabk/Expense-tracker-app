package com.example.expense_manager112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    Button btnExpense;
    Button btnIncome;
    Button btnReport;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout=findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent inToMain=new Intent(HomeActivity.this, MainActivity.class);
                startActivity(inToMain);
            }
        });
        btnExpense=findViewById(R.id.button4);
        btnExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intExpense=new Intent(HomeActivity.this, Expense.class);
                startActivity(intExpense);
            }
        });
        btnIncome=findViewById(R.id.button3);
        btnIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intIncome=new Intent(HomeActivity.this, Income.class);
                startActivity(intIncome);
            }
        });
        btnReport=findViewById(R.id.button2);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intReport=new Intent(HomeActivity.this, Report.class);
                startActivity(intReport);
            }
        });

    }
}