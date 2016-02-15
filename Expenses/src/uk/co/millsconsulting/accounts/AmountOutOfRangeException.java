/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.millsconsulting.accounts;

/**
 *
 * @author bdmills
 */
public class AmountOutOfRangeException extends Exception {

    /**
     * Creates a new instance of <code>AmountOutOfRangeException</code> without
     * detail message.
     */
    public AmountOutOfRangeException() {
    }

    /**
     * Constructs an instance of <code>AmountOutOfRangeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AmountOutOfRangeException(String msg) {
        super(msg);
    }
}
