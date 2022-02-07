package org.example;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Record {
    private final StringProperty name;
    private final StringProperty RollNo;
    private final StringProperty std;
    private final StringProperty address;
    private final StringProperty mobile;

    public Record() {
        name = new SimpleStringProperty(this, "name");
        RollNo = new SimpleStringProperty(this, "RollNo");
        std = new SimpleStringProperty(this, "std");
        address = new SimpleStringProperty(this, "address");
        mobile = new SimpleStringProperty(this, "mobile");
    }


    public void setName(String name) {
        this.name.set(name);
    }

    public void setRollNo(String rollNo) {
        this.RollNo.set(rollNo);
    }

    public void setStd(String std) {
        this.std.set(std);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getRollNo() {
        return RollNo.get();
    }

    public StringProperty rollNoProperty() {
        return RollNo;
    }

    public String getStd() {
        return std.get();
    }

    public StringProperty stdProperty() {
        return std;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getMobile() {
        return mobile.get();
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    @Override
    public String toString() {
        return String.format("%s[name=%s,RollNo=%s]", getName(), getRollNo(), getStd(), getAddress(), getMobile());
    }
}
