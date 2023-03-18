package com.rohit.assignment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("success")
    @Expose
    private String status;

    @SerializedName("feeds")
    @Expose
    private List<FeedItem> feedItems;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }
}
