package com.hatanian.twitter.domain;

import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.prettytime.impl.ResourcesTimeFormat;
import org.ocpsoft.prettytime.impl.ResourcesTimeUnit;
import org.ocpsoft.prettytime.units.*;

import java.util.Date;

public class Message {
    private String author;
    private Date creationDate;
    private String text;

    private static final PrettyTime PRETTY_TIME = new PrettyTime();

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

    public Message(String author, String text, Date creationDate) {
        this.author = author;
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (author != null ? !author.equals(message.author) : message.author != null) return false;
        if (creationDate != null ? !creationDate.equals(message.creationDate) : message.creationDate != null)
            return false;
        return !(text != null ? !text.equals(message.text) : message.text != null);

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    public String asString() {

        return getText() + " (" + PRETTY_TIME.format(getCreationDate()) + ")";
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
