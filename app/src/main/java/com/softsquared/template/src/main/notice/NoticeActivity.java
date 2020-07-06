package com.softsquared.template.src.main.notice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupMenu;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.notice.interfaces.NoticeActivityView;
import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.notice.models.NoticePostWriteInfo;
import com.softsquared.template.src.main.notice.models.NoticeResponse;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeActivity extends BaseActivity implements NoticeActivityView {

    public NoticeAdapter noticeAdapter;
    private NoticeService noticeService;
    private ViewGroup viewGroup;
    private GridLayoutManager gridLayoutManager;
    private FrameLayout noticeOptionBtn;
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

        setView();
        setNotice();
    }

    private void setView()
    {
        noticeOptionBtn = findViewById(R.id.content_option);
        noticeOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.notice_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.notice_option_write:
                                Intent intent = new Intent (NoticeActivity.this, NoticePostWriteActivity.class);
                                intent.putExtra("noticeIdx", noticeIdx);
                                startActivity(intent);
                                finish();
                                break;
                            case R.id.notice_option_delete:
//                                deleteNotice();
                                break;

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notice_menu, menu);
        return true;
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

    @Override
    public void onSuccessPostWrite(NoticePostWriteInfo noticePostWriteInfo) {

    }

    @Override
    public void onFailurePostWrite() {

    }


}
