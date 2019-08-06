package com.example.android.accenturenewjoiners.Activities;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;

import java.util.List;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewItemHolder> {
    private List<RecyclerViewItem> ItemList;

    public RecyclerViewDataAdapter(List<RecyclerViewItem> ItemList) {
        this.ItemList = ItemList;
    }

    @Override
    public RecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View ItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);

        // Get title text view object.
        final TextView TitleView = (TextView) ItemView.findViewById(R.id.card_view_image_title);
        // Get image view object.
        final ImageView ImageView = (ImageView) ItemView.findViewById(R.id.card_view_image);
        // When click the image.
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get title text.
                String Title = TitleView.getText().toString();
                // Create a snackbar and show it.
                Snackbar snackbar = Snackbar.make(ImageView, "You click " + Title + " image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        // Create and return custom Recycler View Item Holder object.
        RecyclerViewItemHolder ret = new RecyclerViewItemHolder(ItemView);
        return ret;
    }
    @Override
    public void onBindViewHolder(RecyclerViewItemHolder holder, int position) {
        if(ItemList!=null) {
            // Get item to in list.
            RecyclerViewItem Item = ItemList.get(position);

            if(Item != null) {
                // Set item title.
                holder.getTitleText().setText(Item.getName());
                // Set image resource id.
                holder.getImageView().setImageResource(Item.getImageId());
            }
        }
    }
    @Override
    public int getItemCount() {
        int ret = 0;
        if(ItemList!=null)
        {
            ret = ItemList.size();
        }
        return ret;
    }
    }

