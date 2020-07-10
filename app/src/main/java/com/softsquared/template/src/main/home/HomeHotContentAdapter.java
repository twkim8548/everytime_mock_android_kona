package com.softsquared.template.src.main.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.classReview.ClassEvalActivity;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.HotContentInfo;
import com.softsquared.template.src.main.noticePost.NoticePostActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeHotContentAdapter extends RecyclerView.Adapter<HomeHotContentAdapter.HotViewHolder> {

    private ArrayList<HotContentInfo> hotContentInfoArrayList = new ArrayList<>();

    public HomeHotContentAdapter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    private HomeFragment homeFragment;

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_hot, parent, false);

        return new HomeHotContentAdapter.HotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {
        holder.setting(hotContentInfoArrayList.get(position));

    }

    @Override
    public int getItemCount() { return hotContentInfoArrayList.size(); }


    public void add(HotContentInfo hotContentInfo) {hotContentInfoArrayList.add(hotContentInfo);}

    public void clear() {hotContentInfoArrayList.clear();}

    public class HotViewHolder extends RecyclerView.ViewHolder {
        private TextView hotContentTitle;
        private TextView hotContentDate;
        private TextView hotContentGood;
        private TextView hotContentComment;

        public HotViewHolder(@NonNull View itemView) {
            super(itemView);
            hotContentTitle = itemView.findViewById(R.id.home_hot_content_title_tv);
            hotContentDate = itemView.findViewById(R.id.home_hot_content_date_tv);
            hotContentGood = itemView.findViewById(R.id.home_hot_good_tv);
            hotContentComment = itemView.findViewById(R.id.home_hot_comment_tv);
        }

        void setting(final HotContentInfo hotContentInfo)
        {
            hotContentTitle.setText(hotContentInfo.getContentTitle());
            hotContentDate.setText(hotContentInfo.getWriteDay());
            hotContentGood.setText(String.valueOf(hotContentInfo.getCountLike()));
            hotContentComment.setText(String.valueOf(hotContentInfo.getCountComment()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), NoticePostActivity.class);
                    intent.putExtra("contentIdx", hotContentInfo.getContentIdx());
                    Log.e("contentIdx", "" +hotContentInfo.getContentIdx());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
