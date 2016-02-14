/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author bdmills
 */
public class ClaimForm {
    
    private int claimNumber;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private String consultant;
    private double totalVatEx;
    private double totalVat;
    private double totalPayable;
    
    private ClaimStatus claimStatus;
    
    private ArrayList<ClaimLine> claimLines;
    
    //
    // CONSTRUCTORS
    //

    public ClaimForm(int claimNumber, GregorianCalendar startDate, GregorianCalendar endDate, String consultant) {
        this.claimNumber = claimNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.consultant = consultant;
        this.claimStatus = ClaimStatus.DRAFT;
        
        this.claimLines = new ArrayList<>();
        
        setTotalAmounts();
    }
    
    
    
    //
    // PUBLIC METHODS
    //
    
    public void addLine(ClaimLine line) {
        claimLines.add(line);
    }
    
    
    
    //
    //PRIVATE METHODS
    //

    private void setTotalAmounts() {
        //interate thru the claim lines adding up as we go
        if (claimLines.isEmpty()) {
            totalVatEx = 0;
            totalVat = 0;
            totalPayable = 0;
        } else {
            
            for (ClaimLine line: claimLines) {
                totalVatEx += line.getVatEx();
                totalVat += line.getVat();
                totalPayable += line.getTotalPayable();
            }
        }
    }
    
    //
    // GETTERS and SETTERS - note setTotal... are PRIVATE not public.
    //

    public int getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public String getConsultant() {
        return consultant;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public double getTotalVatEx() {
        return totalVatEx;
    }

    public double getTotalVat() {
        return totalVat;
    }

    public double getTotalPayable() {
        return totalPayable;
    }

    public ArrayList<ClaimLine> getClaimLines() {
        return claimLines;
    }

    public void setClaimLines(ArrayList<ClaimLine> claimLines) {
        this.claimLines = claimLines;
    }
    

}
