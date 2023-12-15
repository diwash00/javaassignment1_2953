package com.example.nasa.Model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Mission {
    // Properties for Mission details
    private final IntegerProperty sno;
    private final StringProperty missionName;
    private final ObjectProperty<LocalDate> missionStartDate;
    private final ObjectProperty<LocalDate> missionEndDate;
    private final StringProperty missionStatus;

    // Constructor to initialize Mission object
    public Mission(int sno, String missionName, LocalDate missionStartDate, LocalDate missionEndDate, String missionStatus) {
        // Initialize properties using JavaFX properties
        this.sno = new SimpleIntegerProperty(sno);
        this.missionName = new SimpleStringProperty(missionName);
        this.missionStartDate = new SimpleObjectProperty<>(missionStartDate);
        this.missionEndDate = new SimpleObjectProperty<>(missionEndDate);
        this.missionStatus = new SimpleStringProperty(missionStatus);
    }

    // Getter and setter methods for 'sno'
    public int getSno() {
        return sno.get();
    }

    public IntegerProperty snoProperty() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno.set(sno);
    }

    // Getter and setter methods for 'missionName'
    public String getMissionName() {
        return missionName.get();
    }

    public StringProperty missionNameProperty() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName.set(missionName);
    }

    // Getter and setter methods for 'missionStartDate'
    public LocalDate getMissionStartDate() {
        return missionStartDate.get();
    }

    public ObjectProperty<LocalDate> missionStartDateProperty() {
        return missionStartDate;
    }

    public void setMissionStartDate(LocalDate missionStartDate) {
        this.missionStartDate.set(missionStartDate);
    }

    // Getter and setter methods for 'missionEndDate'
    public LocalDate getMissionEndDate() {
        return missionEndDate.get();
    }

    public ObjectProperty<LocalDate> missionEndDateProperty() {
        return missionEndDate;
    }

    public void setMissionEndDate(LocalDate missionEndDate) {
        this.missionEndDate.set(missionEndDate);
    }

    // Getter and setter methods for 'missionStatus'
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
