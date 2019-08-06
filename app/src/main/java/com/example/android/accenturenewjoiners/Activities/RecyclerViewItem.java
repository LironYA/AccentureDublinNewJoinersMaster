package com.example.android.accenturenewjoiners.Activities;

public class RecyclerViewItem {
    // Save name.
    private String Name;

    // Save image resource id.
    private int ImageId;

    public RecyclerViewItem(String Name, int ImageId) {
        this.Name = Name;
        this.ImageId = ImageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int ImageId) {
        this.ImageId = ImageId;
    }
}
