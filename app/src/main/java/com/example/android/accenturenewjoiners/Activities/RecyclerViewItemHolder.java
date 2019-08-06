package com.example.android.accenturenewjoiners.Activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;

public class RecyclerViewItemHolder extends RecyclerView.ViewHolder{
    private TextView TitleText = null;

    private ImageView ImageView = null;

    public RecyclerViewItemHolder(View itemView) {
        super(itemView);

        if(itemView != null)
        {
            TitleText = (TextView)itemView.findViewById(R.id.card_view_image_title);

            ImageView = (ImageView)itemView.findViewById(R.id.card_view_image);
        }
    }

    public TextView getTitleText() {
        return TitleText;
    }

    public ImageView getImageView() {
        return ImageView;
    }
}
