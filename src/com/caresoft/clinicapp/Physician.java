
package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{

    public Physician(Integer id) {
        super(id);
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin >=1000 && pin <=9999){
            this.pin=pin;
            return true;
        }else {

        return false;
    }}

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return this.id.equals(confirmedAuthID);
    }

    private ArrayList<String> patientNotes;

    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // TO DO: Setters & Getters


    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}
