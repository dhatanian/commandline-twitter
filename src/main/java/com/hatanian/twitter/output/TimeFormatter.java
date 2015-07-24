package com.hatanian.twitter.output;

import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.prettytime.impl.ResourcesTimeFormat;
import org.ocpsoft.prettytime.impl.ResourcesTimeUnit;
import org.ocpsoft.prettytime.units.*;

import java.util.Date;

public class TimeFormatter {
    static final PrettyTime PRETTY_TIME = new PrettyTime();

    public String formatDateAsTimePastSince(Date date) {
        return PRETTY_TIME.format(date);
    }

    static {
        //We keep the same units as the default, except that we only display "moments ago" for messages younger than 1 second
        PRETTY_TIME.clearUnits();
        addUnit(new LessThanOneSecond());
        addUnit(new Millisecond());
        addUnit(new Second());
        addUnit(new Minute());
        addUnit(new Hour());
        addUnit(new Day());
        addUnit(new Week());
        addUnit(new Month());
        addUnit(new Year());
        addUnit(new Decade());
        addUnit(new Century());
        addUnit(new Millennium());
    }

    private static void addUnit(ResourcesTimeUnit unit) {
        PRETTY_TIME.registerUnit(unit, new ResourcesTimeFormat(unit));
    }

    private static class LessThanOneSecond extends ResourcesTimeUnit {
        public LessThanOneSecond() {
            setMaxQuantity(1000L);
        }

        @Override
        protected String getResourceKeyPrefix() {
            return "JustNow";
        }
    }
}
