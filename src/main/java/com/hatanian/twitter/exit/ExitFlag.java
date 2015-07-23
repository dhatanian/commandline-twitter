package com.hatanian.twitter.exit;

public class ExitFlag {
    private static boolean RAISED = false;

    public boolean isRaised() {
        return RAISED;
    }

    public void raise() {
        RAISED = true;
    }
}
