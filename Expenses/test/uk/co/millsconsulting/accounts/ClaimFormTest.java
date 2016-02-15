/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bdmills
 */
public class ClaimFormTest {
    
    public ClaimFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLine method, of class ClaimForm.
     */
    @Test
    public void testAddLine001() throws DateOutOfRangeException{
        System.out.println("addLine001");
        ClaimLine line = new ClaimLine();
        line.setVat(new BigDecimal("10.20"));
        line.setVatEx(new BigDecimal("30.40"));
        ClaimForm instance = new ClaimForm(0, new GregorianCalendar(2016,1,1), new GregorianCalendar(2016,1,31), "Brian");
        instance.addLine(line);
        
        assertEquals(1, instance.getClaimLines().size());
    }

    @Test
    public void testAddLine002() throws DateOutOfRangeException {
        System.out.println("addLine002");
        ClaimLine line1 = new ClaimLine();
        line1.setVat(new BigDecimal("10.20"));
        line1.setVatEx(new BigDecimal("30.40"));
        ClaimForm instance = new ClaimForm(0, new GregorianCalendar(2016,1,1), new GregorianCalendar(2016,1,31), "Brian");
        instance.addLine(line1);
        
        assertEquals(new BigDecimal("40.60"), instance.getTotalPayable());
    }

    @Test
    public void testAddLine003() throws DateOutOfRangeException{
        System.out.println("addLine003");
        ClaimLine line1 = new ClaimLine();
        line1.setVat(new BigDecimal("10.20"));
        line1.setVatEx(new BigDecimal("30.40"));

        ClaimLine line2 = new ClaimLine();
        line2.setVat(new BigDecimal("5.20"));
        line2.setVatEx(new BigDecimal("10.01"));
 
        ClaimForm instance = new ClaimForm(0, new GregorianCalendar(2016,1,1), new GregorianCalendar(2016,1,31), "Brian");
        instance.addLine(line1);
        instance.addLine(line2);
        
        assertEquals(new BigDecimal("55.81"), instance.getTotalPayable());
    }

    @Test (expected = DateOutOfRangeException.class)
    public void testAddLine004() throws DateOutOfRangeException {
        System.out.println("addLine004");
        ClaimLine line1 = new ClaimLine();
        line1.setVat(new BigDecimal("10.20"));
        line1.setVatEx(new BigDecimal("30.40"));
        line1.setLineDate(new GregorianCalendar(2016,Calendar.FEBRUARY,1));

        ClaimForm instance = new ClaimForm(0, new GregorianCalendar(2016,Calendar.JANUARY,1), new GregorianCalendar(2016,Calendar.JANUARY,31), "Brian");
        instance.addLine(line1);
    }

    @Test 
    public void testAddLine005() throws DateOutOfRangeException {
        System.out.println("addLine005");
        ClaimLine line1 = new ClaimLine();
        line1.setVat(new BigDecimal("10.20"));
        line1.setVatEx(new BigDecimal("30.40"));
        line1.setLineDate(new GregorianCalendar(2016,Calendar.JANUARY,1));

        ClaimForm instance = new ClaimForm(0, new GregorianCalendar(2016,Calendar.JANUARY,1), new GregorianCalendar(2016,Calendar.JANUARY,31), "Brian");
        instance.addLine(line1);
        assertEquals(new GregorianCalendar(2016,Calendar.JANUARY,1), instance.getClaimLines().get(0).getLineDate());
    }

//    /**
//     * Test of getClaimNumber method, of class ClaimForm.
//     */
//    @Test
//    public void testGetClaimNumber() {
//        System.out.println("getClaimNumber");
//        ClaimForm instance = null;
//        int expResult = 0;
//        int result = instance.getClaimNumber();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setClaimNumber method, of class ClaimForm.
//     */
//    @Test
//    public void testSetClaimNumber() {
//        System.out.println("setClaimNumber");
//        int claimNumber = 0;
//        ClaimForm instance = null;
//        instance.setClaimNumber(claimNumber);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getStartDate method, of class ClaimForm.
//     */
//    @Test
//    public void testGetStartDate() {
//        System.out.println("getStartDate");
//        ClaimForm instance = null;
//        GregorianCalendar expResult = null;
//        GregorianCalendar result = instance.getStartDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStartDate method, of class ClaimForm.
//     */
//    @Test
//    public void testSetStartDate() {
//        System.out.println("setStartDate");
//        GregorianCalendar startDate = null;
//        ClaimForm instance = null;
//        instance.setStartDate(startDate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEndDate method, of class ClaimForm.
//     */
//    @Test
//    public void testGetEndDate() {
//        System.out.println("getEndDate");
//        ClaimForm instance = null;
//        GregorianCalendar expResult = null;
//        GregorianCalendar result = instance.getEndDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEndDate method, of class ClaimForm.
//     */
//    @Test
//    public void testSetEndDate() {
//        System.out.println("setEndDate");
//        GregorianCalendar endDate = null;
//        ClaimForm instance = null;
//        instance.setEndDate(endDate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getConsultant method, of class ClaimForm.
//     */
//    @Test
//    public void testGetConsultant() {
//        System.out.println("getConsultant");
//        ClaimForm instance = null;
//        String expResult = "";
//        String result = instance.getConsultant();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setConsultant method, of class ClaimForm.
//     */
//    @Test
//    public void testSetConsultant() {
//        System.out.println("setConsultant");
//        String consultant = "";
//        ClaimForm instance = null;
//        instance.setConsultant(consultant);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTotalVatEx method, of class ClaimForm.
//     */
//    @Test
//    public void testGetTotalVatEx() {
//        System.out.println("getTotalVatEx");
//        ClaimForm instance = null;
//        BigDecimal expResult = null;
//        BigDecimal result = instance.getTotalVatEx();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTotalVat method, of class ClaimForm.
//     */
//    @Test
//    public void testGetTotalVat() {
//        System.out.println("getTotalVat");
//        ClaimForm instance = null;
//        BigDecimal expResult = null;
//        BigDecimal result = instance.getTotalVat();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTotalPayable method, of class ClaimForm.
//     */
//    @Test
//    public void testGetTotalPayable() {
//        System.out.println("getTotalPayable");
//        ClaimForm instance = null;
//        BigDecimal expResult = null;
//        BigDecimal result = instance.getTotalPayable();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getClaimLines method, of class ClaimForm.
//     */
//    @Test
//    public void testGetClaimLines() {
//        System.out.println("getClaimLines");
//        ClaimForm instance = null;
//        ArrayList<ClaimLine> expResult = null;
//        ArrayList<ClaimLine> result = instance.getClaimLines();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setClaimLines method, of class ClaimForm.
//     */
//    @Test
//    public void testSetClaimLines() {
//        System.out.println("setClaimLines");
//        ArrayList<ClaimLine> claimLines = null;
//        ClaimForm instance = null;
//        instance.setClaimLines(claimLines);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
