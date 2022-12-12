package com.example.samplecirclereactionlike.ui;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplecirclereactionlike.R;
import com.example.samplecirclereactionlike.databinding.ViewReactionBinding;
import com.example.samplecirclereactionlike.widget.ReactionView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by KenZira on 2/2/17.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.btLike)
    View btLike;

    @BindView(R.id.btComment)
    View btComment;

    @BindView(R.id.btShare)
    View btShare;

    @BindView(R.id.llFeedInfo)
    View llFeedInfo;

    @BindView(R.id.ivBadgeLike)
    ImageView ivBadgeLike;

    private PopupWindow popupWindow;

    public FeedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    @OnClick(R.id.btLike)
    public void handleLikeClick() {
        ViewReactionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(itemView.getContext()), R.layout.view_reaction, null, false);
        popupWindow = new PopupWindow(binding.getRoot(), ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(binding.getRoot(), Gravity.TOP | Gravity.CENTER_HORIZONTAL, 20, llFeedInfo.getTop() - 250);
        popupWindow.setClippingEnabled(false);
        popupWindow.setElevation(20);
        binding.react.setOnSelectReaction(new ReactionView.OnSelectReaction() {
            @Override
            public void onSelect(int position) {
                popupWindow.dismiss();
            }
        });
        //popupWindow.showAtLocation(llFeedInfo, Gravity.TOP | Gravity.START, ivBadgeLike.getRight(), llFeedInfo.getTop());
    }

    @OnClick(R.id.btComment)
    public void handleCommentClick() {

    }

    @OnClick(R.id.btShare)
    public void handleShareClick() {
    }
}
