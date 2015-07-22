package com.hatanian.twitter.exit;

public class ExitFlagImpl implements ExitFlag {
    private static boolean RAISED = false;

    @Override
    public boolean isRaised() {
        return RAISED;
    }

    @Override
    public void raise() {
        RAISED = true;
    }
}
