package com.example.android.accenturenewjoiners.Activities.Transportation;

public class ArrayListFragments {

    String urlLink;
    String descriptionSites;
    String information;
    String imageResource;

    public ArrayListFragments(String url, String description, String image, String info) {

        urlLink = url;
        descriptionSites = description;
        imageResource = image;
        information = info;
    }

    public String getURL() {
        return urlLink;
    }

    public String getDescriptionSites() {
        return descriptionSites;
    }

    public String getImage() {
        return imageResource;
    }

    public String getInfo() {
        return information;
    }


}