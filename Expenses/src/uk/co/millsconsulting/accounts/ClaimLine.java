/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;

/**
 *
 * @author bdmills
 */
public class ClaimLine {
    
    private int lineNumber;
    private GregorianCalendar lineDate;
    private String description;
    private BigDecimal vatEx;
    private BigDecimal vat;
    private BigDecimal totalPayable;
    private int receiptNumber;

    //
    // CONSTRUCTORS
    //
    public ClaimLine() {
        vatEx = new BigDecimal(BigInteger.ZERO);
        vat = new BigDecimal(BigInteger.ZERO);
        totalPayable = new BigDecimal(BigInteger.ZERO);
    }
    
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

    public BigDecimal getVatEx() {
        return vatEx;
    }

    public void setVatEx(BigDecimal vatEx) {
        this.vatEx = vatEx.setScale(2, BigDecimal.ROUND_FLOOR);
        setTotalPayable();
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat.setScale(2, BigDecimal.ROUND_FLOOR);
        setTotalPayable();
    }

    public BigDecimal getTotalPayable() {
        return totalPayable;
    }

    //NOTE - This one is PRIVATE - users can never set the total specifically
    private void setTotalPayable() {
        this.totalPayable = vatEx.add(vat);
        this.totalPayable = totalPayable.setScale(2, BigDecimal.ROUND_FLOOR);
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    
    
    
}
