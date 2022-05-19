package com.example.expense_manager112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {

    Button btnExpenseReport;
    Button btnIncomeReport;
    Button btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        btnExpenseReport=findViewById(R.id.report_expense);
        btnExpenseReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intExpenseReport=new Intent(Report.this, Expense_Report.class);
                startActivity(intExpenseReport);
            }
        });
        btnIncomeReport=findViewById(R.id.report_income);
        btnIncomeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intIncomeReport=new Intent(Report.this, Income_Report.class);
                startActivity(intIncomeReport);
            }
        });
        btnBackHome=findViewById(R.id.back_home);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intBack=new Intent(Report.this,HomeActivity.class);
                startActivity(intBack);
            }
        });
    }
}