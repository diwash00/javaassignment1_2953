package com.example.nasa;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mission {
    private final IntegerProperty sno;
    private final StringProperty missionName;
    private final StringProperty missionStartDate;
    private final StringProperty missionEndDate;
    private final StringProperty missionStatus;

    public Mission(int sno, String missionName, String missionStartDate, String missionEndDate, String missionStatus) {
        this.sno = new SimpleIntegerProperty(sno);
        this.missionName = new SimpleStringProperty(missionName);
        this.missionStartDate = new SimpleStringProperty(missionStartDate);
        this.missionEndDate = new SimpleStringProperty(missionEndDate);
        this.missionStatus = new SimpleStringProperty(missionStatus);
    }

    public int getSno() {
        return sno.get();
    }

    public IntegerProperty snoProperty() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno.set(sno);
    }

    public String getMissionName() {
        return missionName.get();
    }

    public StringProperty missionNameProperty() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName.set(missionName);
    }

    public String getMissionStartDate() {
        return missionStartDate.get();
    }

    public StringProperty missionStartDateProperty() {
        return missionStartDate;
    }

    public void setMissionStartDate(String missionStartDate) {
        this.missionStartDate.set(missionStartDate);
    }

    public String getMissionEndDate() {
        return missionEndDate.get();
    }

    public StringProperty missionEndDateProperty() {
        return missionEndDate;
    }

    public void setMissionEndDate(String missionEndDate) {
        this.missionEndDate.set(missionEndDate);
    }

    public String getMissionStatus() {
        return missionStatus.get();
    }

    public StringProperty missionStatusProperty() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus.set(missionStatus);
    }
}
