package org.nanotate.model;

public class Tag extends TagKey {
    private String tag_label;

    private Boolean automatic_tag;

    public String getTag_label() {
        return tag_label;
    }

    public void setTag_label(String tag_label) {
        this.tag_label = tag_label;
    }

    public Boolean getAutomatic_tag() {
        return automatic_tag;
    }

    public void setAutomatic_tag(Boolean automatic_tag) {
        this.automatic_tag = automatic_tag;
    }
}