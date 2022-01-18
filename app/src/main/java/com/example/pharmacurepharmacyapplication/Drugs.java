package com.example.pharmacurepharmacyapplication;

public class Drugs {

    private Integer pdrugid;
    private String pdrugname;
    private Integer dbrandid;
    private String dbrandname;
    private Integer dcatid;
    private String dcatname;
    private Integer dquantity;
    private Float drugprice;

    public Integer getPdrugid() {
        return pdrugid;
    }

    public void setPdrugid(Integer pdrugid) {
        this.pdrugid = pdrugid;
    }

    public String getPdrugname() {
        return pdrugname;
    }

    public void setPdrugname(String pdrugname) {
        this.pdrugname = pdrugname;
    }

    public Integer getDbrandid() {
        return dbrandid;
    }

    public void setDbrandid(Integer dbrandid) {
        this.dbrandid = dbrandid;
    }

    public String getDbrandname() {
        return dbrandname;
    }

    public void setDbrandname(String dbrandname) {
        this.dbrandname = dbrandname;
    }

    public Integer getDcatid() {
        return dcatid;
    }

    public void setDcatid(Integer dcatid) {
        this.dcatid = dcatid;
    }

    public String getDcatname() {
        return dcatname;
    }

    public void setDcatname(String dcatname) {
        this.dcatname = dcatname;
    }

    public Integer getDquantity() {
        return dquantity;
    }

    public void setDquantity(Integer dquantity) {
        this.dquantity = dquantity;
    }

    public Float getDrugprice() {
        return drugprice;
    }

    public void setDrugprice(Float drugprice) {
        this.drugprice = drugprice;
    }
}
