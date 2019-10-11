package com.example.android.accenturenewjoiners.Activities.Wellness;

public class ListViewSelector {

        private String wellnessActivity;
        private String area;
        int imageResource;

        public ListViewSelector(String wellnessActivityList, String cityArea, int image) {

            wellnessActivity = wellnessActivityList;
            area = cityArea;
            imageResource = image;
        }

        public String getWellnessActivity() {
            return wellnessActivity;
        }

        public String getArea() {
            return area;
        }

        public int getImage() {
            return imageResource;
        }

    }

