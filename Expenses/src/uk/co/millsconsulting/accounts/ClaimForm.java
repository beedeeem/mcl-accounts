/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    private BigDecimal totalVatEx;
    private BigDecimal totalVat;
    private BigDecimal totalPayable;
    
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
    
    public void addLine(ClaimLine line) throws DateOutOfRangeException {
        
        if (line.getLineDate() != null) {
            // check that the date of the claim line fits with our overall claim
            if (line.getLineDate().before(startDate) || line.getLineDate().after(endDate)) {
                throw new DateOutOfRangeException("The line date is outside the claim date");
            } 
        } 
        claimLines.add(line);
        setTotalAmounts();
    }
    
    
    
    //
    //PRIVATE METHODS
    //

    private void setTotalAmounts() {
        totalPayable = new BigDecimal(BigInteger.ZERO);
        totalVat = new BigDecimal(BigInteger.ZERO);
        totalVatEx = new BigDecimal(BigInteger.ZERO);
        
        // if the list of claim lines isn't empty, iterate thru it adding up as we go
        if (!claimLines.isEmpty()) {
            for (ClaimLine line : claimLines) {
                totalPayable = totalPayable.add(line.getTotalPayable());
                totalVatEx = totalVatEx.add(line.getVatEx());
                totalVat = totalVat.add(line.getVat());
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

    public BigDecimal getTotalVatEx() {
        return totalVatEx;
    }

    public BigDecimal getTotalVat() {
        return totalVat;
    }

    public BigDecimal getTotalPayable() {
        return totalPayable;
    }

    public ArrayList<ClaimLine> getClaimLines() {
        return claimLines;
    }

    public void setClaimLines(ArrayList<ClaimLine> claimLines) {
        this.claimLines = claimLines;
    }
    

}
