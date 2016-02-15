/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class ClaimLineTest {
    
    public ClaimLineTest() {
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
     * Test of getVatEx method, of class ClaimLine.
     */
    @Test
    public void testGetVatEx001() {
        System.out.println("getVatEx001");
        ClaimLine instance = new ClaimLine();
        instance.setVatEx(new BigDecimal("2123.45"));
        BigDecimal expResult = new BigDecimal(2123.457).setScale(2, RoundingMode.FLOOR);
        BigDecimal result = instance.getVatEx();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetVatEx002() {
        System.out.println("getVatEx002");
        ClaimLine instance = new ClaimLine();
        instance.setVatEx(new BigDecimal("123.4567"));
        BigDecimal expResult = new BigDecimal("123.45");
        BigDecimal result = instance.getVatEx();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVatEx method, of class ClaimLine.
     */
    @Test
    public void testSetVatEx001() {
        System.out.println("setVatEx001");
        BigDecimal vatEx = new BigDecimal("123.45");
        ClaimLine instance = new ClaimLine();
        instance.setVatEx(vatEx);
        
        assertEquals(vatEx, instance.getVatEx());    
        assertEquals(vatEx, instance.getTotalPayable());    
    }

    @Test
    public void testGetVat001() {
        System.out.println("getVat001");
        ClaimLine instance = new ClaimLine();
        instance.setVat(new BigDecimal("6123.45"));
        BigDecimal expResult = new BigDecimal("6123.45");
        BigDecimal result = instance.getVat();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetVat002() {
        System.out.println("getVat002");
        ClaimLine instance = new ClaimLine();
        instance.setVat(new BigDecimal("6123.4567"));
        BigDecimal expResult = new BigDecimal("6123.45");
        BigDecimal result = instance.getVat();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVatEx method, of class ClaimLine.
     */
    @Test
    public void testSetVat001() {
        System.out.println("setVat001");
        BigDecimal vat = new BigDecimal("6123.45");
        ClaimLine instance = new ClaimLine();
        instance.setVat(vat);
        
        assertEquals(vat, instance.getVat());    
        assertEquals(vat, instance.getTotalPayable());    
    }

    /**
     * Test of getTotalPayable method, of class ClaimLine.
     */
    @Test
    public void testGetTotalPayable001() {
        System.out.println("getTotalPayable001");
        ClaimLine instance = new ClaimLine();
        instance.setVat(new BigDecimal("125.68"));
        
        BigDecimal expResult = new BigDecimal("125.68");
        BigDecimal result = instance.getTotalPayable();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalPayable002() {
        System.out.println("getTotalPayable002");
        ClaimLine instance = new ClaimLine();
        instance.setVatEx(new BigDecimal("125.68"));
        
        BigDecimal expResult = new BigDecimal("125.68");
        BigDecimal result = instance.getTotalPayable();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalPayable003() {
        System.out.println("getTotalPayable003");
        ClaimLine instance = new ClaimLine();
        instance.setVat(new BigDecimal("125.68"));
        instance.setVatEx(new BigDecimal("10.01"));
        
        BigDecimal expResult = new BigDecimal("135.69");
        BigDecimal result = instance.getTotalPayable();
        assertEquals(expResult, result);
    }

    
}
