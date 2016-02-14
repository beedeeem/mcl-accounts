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
public class Expenses {
    
    public static void main (String[] args) {
        System.out.println("it's begun!!!");
        
        ClaimLine line1 = new ClaimLine();
        line1.setVat(100.12);
        System.out.println(line1.getTotalPayable());

        line1.setVatEx(250);
        System.out.println(line1.getTotalPayable());
        
        ClaimForm form1 = new ClaimForm(0, new GregorianCalendar(2016,02,01), new GregorianCalendar(2016,02,29), "Brian Mills");
        
        System.out.println(form1.getConsultant());
        System.out.println(form1.getStartDate());
        System.out.println(form1.getTotalPayable());
    }
    
    
    
}
