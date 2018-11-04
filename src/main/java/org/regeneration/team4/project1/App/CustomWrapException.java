package org.regeneration.team4.project1.App;

public class CustomWrapException extends Exception {

    public CustomWrapException() {
            System.out.println("\nOops! There's a glitch in the Matrix! Agent Smith dispatched! Run for your lives!");
            System.exit(-1);
    }
}