package com.klinker.android.emoji_keyboard.sqlite;

public class RecentEntry {

    private long id;
    private String text;
    private String icon;
    private long count;

    public void incrementUsageCountByOne() {
        this.count = this.count+1;
    }

    public RecentEntry(String text, String icon, long count, long id) {
        this.count = count;
        this.icon = icon;
        this.id = id;
        this.text = text;
    }

    public RecentEntry(String text, String icon, long count) {
        this.count = count;
        this.icon = icon;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getCount() {
        return count;
    }

    public String getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
