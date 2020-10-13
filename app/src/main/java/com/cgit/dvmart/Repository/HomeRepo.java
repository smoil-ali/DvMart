package com.cgit.dvmart.Repository;

import android.net.Uri;

import com.cgit.dvmart.Model.Section;
import com.cgit.dvmart.Model.SectionItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class HomeRepo {
    List<Section> sectionList = new ArrayList<>();
    List<SectionItem> sectionItemList = new ArrayList<>();

    public HomeRepo() {
    }

    /*private Single<List<Section>> loadSectionItemList(){
        Uri Pic1uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic1");
        Uri Pic2uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic2");
        Uri Pic3uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic3");
        Uri Pic4uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic4");
        Uri Pic5uri = Uri.parse("android.resource://com.cgit.dvmart/drawable/pic5");
        sectionItemList.add(new SectionItem(Pic1uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic2uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic3uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic4uri,"shirt1","1000"));
        sectionItemList.add(new SectionItem(Pic5uri,"shirt1","1000"));
        sectionList.add(new Section("Shirts",sectionItemList));
        return (Single<List<Section>>) sectionList;
    }*/
}
