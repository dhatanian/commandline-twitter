package com.hatanian.twitter.exit;

public class SystemExitProgramTerminatorImpl implements ProgramTerminator {
    @Override
    public void terminateProgram() {
        System.exit(0);
    }
}
