package com.bradbarnhill.android.jaft.models;

/**
 * Data model for holding the time element data
 */

public class TimeElement {
    private int minute;
    private int seconds;
    private String text;

    public TimeElement(final int minute, final int seconds, final String text) {
        this.minute = minute;
        this.seconds = seconds;
        this.text = text;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(final int minute) {
        this.minute = minute;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(final int seconds) {
        this.seconds = seconds;
    }
}
