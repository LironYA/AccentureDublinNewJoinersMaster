package com.example.android.accenturenewjoiners.Activities.Transportation;

public class ArrayListFragments {


    String descriptionSites;
    String information;
    int imageResource;

    public ArrayListFragments(String description, int image, String info) {

        descriptionSites = description;
        imageResource = image;
        information = info;
    }

    public String getDescriptionSites() {
        return descriptionSites;
    }

    public int getImage() {
        return imageResource;
    }

    public String getInfo() {
        return information;
    }

}