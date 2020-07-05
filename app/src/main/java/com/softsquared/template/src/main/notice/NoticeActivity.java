package com.softsquared.template.src.main.notice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.home.HomeFavoriteCommunityAdapter;
import com.softsquared.template.src.main.home.models.HotContentInfo;
import com.softsquared.template.src.main.notice.interfaces.NoticeActivityView;
import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.notice.models.NoticeResponse;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeActivity extends BaseActivity implements NoticeActivityView {

    private NoticeAdapter noticeAdapter;
    private NoticeService noticeService;
    private ViewGroup viewGroup;
    private GridLayoutManager gridLayoutManager;
    private int noticeIdx = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        noticeService = new NoticeService(this);
        Intent intent = getIntent();
        if(intent == null)
            Log.e("intent없음", "NoticeActivity::onCreate() intent is null");
        else
        {
            noticeIdx = intent.getIntExtra("noticeIdx", 0);
            Log.e("intent값", "noticeIdx : " + noticeIdx);
        }

        setNotice();
    }

    private void setNotice()
    {
        int column = 1;
        noticeAdapter = new NoticeAdapter(this);
        RecyclerView noticeRecyclerView = findViewById(R.id.content_recyclerview);
        gridLayoutManager = new GridLayoutManager(this, column);
        noticeRecyclerView.setLayoutManager(gridLayoutManager);
        noticeRecyclerView.setAdapter(noticeAdapter);
        noticeService.getNotice(noticeIdx);
    }

    @Override
    public void onSuccessGetNotice(NoticeResponse noticeResponse) {
        noticeAdapter.clear();
        for(NoticeInfo noticeInfo : noticeResponse.getResult())
        {
            noticeAdapter.add(noticeInfo);
        }
        noticeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetNotice() {

    }
}
