package com.cgit.dvmart.Model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionLabel;
    private List<SectionItem> itemArrayList;

    public String getSectionLabel() {
        return sectionLabel;
    }

    public void setSectionLabel(String sectionLabel) {
        this.sectionLabel = sectionLabel;
    }

    public List<SectionItem> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<SectionItem> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public Section(String sectionLabel, List<SectionItem> itemArrayList) {
        this.sectionLabel = sectionLabel;
        this.itemArrayList = itemArrayList;
    }
}
