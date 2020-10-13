package com.cgit.dvmart.Model;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionLabel;
    private List<Products> itemArrayList;

    public String getSectionLabel() {
        return sectionLabel;
    }

    public void setSectionLabel(String sectionLabel) {
        this.sectionLabel = sectionLabel;
    }

    public List<Products> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Products> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public Section(String sectionLabel, List<Products> itemArrayList) {
        this.sectionLabel = sectionLabel;
        this.itemArrayList = itemArrayList;
    }
}
