package com.example.samplecirclereactionlike.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.samplecirclereactionlike.R;
import com.example.samplecirclereactionlike.model.Feed;

import java.util.List;

/**
 * Created by KenZira on 2/2/17.
 */

public class FeedAdapter extends RecyclerView.Adapter {
    private List<Feed> feeds;

    public FeedAdapter(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed, parent, false);
        return new FeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }
}
