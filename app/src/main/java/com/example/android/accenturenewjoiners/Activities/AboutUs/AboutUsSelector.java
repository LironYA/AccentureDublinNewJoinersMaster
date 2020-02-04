package com.example.android.accenturenewjoiners.Activities.AboutUs;

public class AboutUsSelector {
    private String contactWay;
    private String description;
    int imageResource;

    public AboutUsSelector(String contactWayList, String descriptionList, int image) {

        contactWay = contactWayList;
        description = descriptionList;
        imageResource = image;
    }

    public String getContacts() {
        return contactWay;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return imageResource;
    }

}
