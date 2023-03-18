package com.rohit.assignment.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rohit.assignment.R;
import com.rohit.assignment.models.OfferItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfferItemAdapter extends RecyclerView.Adapter<OfferItemAdapter.OfferItemHolder> {

    private Context context;
    List<OfferItem> offerItemList;

    public OfferItemAdapter(Context context) {
        this.context = context;
        offerItemList = new ArrayList<>();
    }

    public OfferItemAdapter(Context context, List<OfferItem> offerItemList) {
        this.context = context;
        this.offerItemList = offerItemList;
    }

    @NonNull
    @Override
    public OfferItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer_item_layout, parent, false);

        return new OfferItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferItemHolder holder, int position) {

        OfferItem item = offerItemList.get(position);

        if (item.getImage()!=null && !Objects.equals(item.getImage(), "")) {
            Glide.with(holder.itemView).load(item.getImage()).into(holder.offerImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(context)
                        .setTitle("Offer")
                        .setMessage("Best Deal On " + item.getName() + " at your Doorstep")
                        .setNegativeButton("CLOSE",null)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            }
        });
    }

    public void setResults(List<OfferItem> offerItemList) {
        this.offerItemList = offerItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return offerItemList.size();
    }

    class OfferItemHolder extends RecyclerView.ViewHolder {

        private ImageView offerImage;

        public OfferItemHolder(@NonNull View itemView) {
            super(itemView);
            offerImage = itemView.findViewById(R.id.offerImage);
        }
    }
}
