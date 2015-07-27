package com.hatanian.twitter;

import com.google.inject.Singleton;

@Singleton
public class ExitFlag {
    private boolean raised = false;

    public boolean isRaised() {
        return raised;
    }

    public void raise() {
        raised = true;
    }
}
