package com.example.pharmacurepharmacyapplication;

public class PCustomer {

    private int custid;

     String custname;

     String custaddress;

     String custnic;

     String custemail;

    private PCustomerLogin pCustomerLogin;

    public PCustomer() {
    }

    public PCustomer(String cusName, String cusAddress, String custNic, String custloginemail, PCustomerLogin pcustomerlogin) {
        this.custname = cusName;
        this.custemail = custloginemail;
        this.custnic = custNic;
        this.custaddress = cusAddress;
        this.pCustomerLogin = pcustomerlogin;
    }


    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustaddress() {
        return custaddress;
    }

    public void setCustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public String getCustnic() {
        return custnic;
    }

    public void setCustnic(String custnic) {
        this.custnic = custnic;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public void setpCustomerLogin(PCustomerLogin pCustomerLogin) {
        this.pCustomerLogin = pCustomerLogin;
    }
}
