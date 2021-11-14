package com.example.saathi.Models;

public class ContentDetails {
    String title, text;
    int details;

    public ContentDetails(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public ContentDetails(String title, String text, int details) {
        this.title = title;
        this.text = text;
        this.details = details;
    }

    public int getDetails() {
        return details;
    }

    public void setDetails(int details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
