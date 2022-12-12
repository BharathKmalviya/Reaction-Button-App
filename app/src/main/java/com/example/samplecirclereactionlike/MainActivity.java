package com.example.samplecirclereactionlike;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplecirclereactionlike.ui.FeedAdapter;
import com.example.samplecirclereactionlike.util.Constants;
import com.example.samplecirclereactionlike.widget.ReactionView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.rvNewFeed)
    RecyclerView rvNewFeed;

    @BindView(R.id.btReaction)
    LinearLayout btReaction;

    @BindView(R.id.root)
    FrameLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpRecyclerView();
    }

    private boolean scaledDown;

    @OnClick(R.id.btReaction)
    public void showPopup(View v) {
        ReactionView rvl = new ReactionView(this);
        root.addView(rvl);
    }


    private void setUpRecyclerView() {
        FeedAdapter adapter = new FeedAdapter(Constants.feeds);
        rvNewFeed.setLayoutManager(new LinearLayoutManager(this));
        rvNewFeed.setAdapter(adapter);
    }
}
