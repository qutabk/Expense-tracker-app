package com.example.expense_manager112;

public class Income_Data {
     String inc_type;
    String inc_amount;
     String inc_date;

    public Income_Data() {
    }

    public Income_Data(String inc_type, String inc_amount, String inc_date) {
        this.inc_type = inc_type;
        this.inc_amount = inc_amount;
        this.inc_date = inc_date;
    }

    public String getInc_type() {
        return inc_type;
    }

    public void setInc_type(String inc_type) {
        this.inc_type = inc_type;
    }

    public String getInc_amount() {
        return inc_amount;
    }

    public void setInc_amount(String inc_amount) {
        this.inc_amount = inc_amount;
    }

    public String getInc_date() {
        return inc_date;
    }

    public void setInc_date(String inc_date) {
        this.inc_date = inc_date;
    }
}
