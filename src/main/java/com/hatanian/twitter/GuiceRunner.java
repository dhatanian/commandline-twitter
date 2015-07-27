package com.hatanian.twitter;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

public class GuiceRunner {
    private static Injector injector;

    public static void setInjector(Injector injector) {
        GuiceRunner.injector = injector;
    }

    public static void main(String[] args) throws IOException {
        if (injector == null) {
            injector = Guice.createInjector(new GuiceModule());
        }
        App app = null;
        try {
            app = injector.getInstance(App.class);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        app.run();
    }
}