/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.util.GregorianCalendar;

/**
 *
 * @author bdmills
 */
public class ClaimLine {
    
    private int lineNumber;
    private GregorianCalendar lineDate;
    private String description;
    private double vatEx;
    private double vat;
    private double totalPayable;
    private int receiptNumber;

    //
    // CONSTRUCTORS
    //
    
    //
    // PUBLIC METHODS
    //
    
    
    //
    //PRIVATE METHODS
    //
    
    //
    // GETTERS and SETTERS - note setTotalPayable is PRIVATE not public.
    //
    
    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public GregorianCalendar getLineDate() {
        return lineDate;
    }

    public void setLineDate(GregorianCalendar lineDate) {
        this.lineDate = lineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getVatEx() {
        return vatEx;
    }

    public void setVatEx(double vatEx) {
        this.vatEx = vatEx;
        this.totalPayable = vat + vatEx;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
        this.totalPayable = vat + vatEx;
    }

    public double getTotalPayable() {
        return totalPayable;
    }

    //NOTE - This one is PRIVATE - users can never set the total specifically
    private void setTotalPayable(double totalPayable) {
        this.totalPayable = vatEx + vat;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    
    
    
}
