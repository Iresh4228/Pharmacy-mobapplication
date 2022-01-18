package com.example.pharmacurepharmacyapplication;

public class PCustomerLogin {


    private int custloginid;

    private String custloginemail;

    private String custpassword;

    private int custstatus;

    public PCustomerLogin() {
    }

    public PCustomerLogin(String custloginemail, String custpassword) {
        this.custloginemail = custloginemail;
        this.custpassword = custpassword;
        this.custstatus = 1;
    }


    public int getCustloginid() {
        return custloginid;
    }

    public void setCustloginid(int custloginid) {
        this.custloginid = custloginid;
    }

    public String getCustloginemail() {
        return custloginemail;
    }

    public void setCustloginemail(String custloginemail) {
        this.custloginemail = custloginemail;
    }

    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    public int getCuststatus() {
        return custstatus;
    }

    public void setCuststatus(int custstatus) {
        this.custstatus = custstatus;
    }
}
