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
public class DateOutOfRangeException extends Exception {

    /**
     * Creates a new instance of <code>DateOutOfRangeException</code> without
     * detail message.
     */
    public DateOutOfRangeException() {
    }

    /**
     * Constructs an instance of <code>DateOutOfRangeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DateOutOfRangeException(String msg) {
        super(msg);
    }
}
