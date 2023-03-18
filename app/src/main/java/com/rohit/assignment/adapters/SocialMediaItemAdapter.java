package com.rohit.assignment.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohit.assignment.R;
import com.rohit.assignment.WebViewActivity;
import com.rohit.assignment.models.SocialMediaItem;

import java.util.List;

public class SocialMediaItemAdapter extends RecyclerView.Adapter<SocialMediaItemAdapter.SocialMediaItemHolder> {

    private Context context;
    private List<SocialMediaItem> results;

    public SocialMediaItemAdapter(Context context, List<SocialMediaItem> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public SocialMediaItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.social_media_item_layout, parent, false);

        return new SocialMediaItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialMediaItemHolder holder, int position) {

        SocialMediaItem socialMediaItem = results.get(position);

        holder.socialMediaIcon.setImageResource(socialMediaItem.getIcon());

        holder.socialMediaName.setText(socialMediaItem.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "";
                if (socialMediaItem.getName().equals("facebook"))
                    url = "https://www.facebook.com/";
                else if (socialMediaItem.getName().equals("twitter"))
                    url = "https://twitter.com/";
                else if (socialMediaItem.getName().equals("instagram"))
                    url = "https://www.instagram.com/";
                else
                    url = "https://youtube.com/";

                Intent i = new Intent(context, WebViewActivity.class);
                i.putExtra("url",url);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class SocialMediaItemHolder extends RecyclerView.ViewHolder {

        private ImageView socialMediaIcon;
        private TextView socialMediaName;

        public SocialMediaItemHolder(@NonNull View itemView) {
            super(itemView);

            socialMediaIcon = itemView.findViewById(R.id.socialMediaIcon);
            socialMediaName = itemView.findViewById(R.id.socialMediaName);
        }
    }
}
