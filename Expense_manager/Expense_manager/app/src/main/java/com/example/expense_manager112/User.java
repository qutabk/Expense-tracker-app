package com.example.expense_manager112;

public class User {
    String exp_type;
    String exp_amount;
    String exp_date;

    public User() {
    }

    public User(String exp_type, String exp_amount, String exp_date) {
        this.exp_type = exp_type;
        this.exp_amount = exp_amount;
        this.exp_date = exp_date;
    }

    public String getExp_type() {
        return exp_type;
    }

    public void setExp_type(String exp_type) {
        this.exp_type = exp_type;
    }

    public String getExp_amount() {
        return exp_amount;
    }

    public void setExp_amount(String exp_amount) {
        this.exp_amount = exp_amount;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }
}
