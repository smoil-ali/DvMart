package com.cgit.dvmart.Model;

public class CashPoint {
    String id;
    String event;
    String date;
    String cashPints;

    public CashPoint(String id, String event, String date, String cashPints) {
        this.id = id;
        this.event = event;
        this.date = date;
        this.cashPints = cashPints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashPints() {
        return cashPints;
    }

    public void setCashPints(String cashPints) {
        this.cashPints = cashPints;
    }
}
