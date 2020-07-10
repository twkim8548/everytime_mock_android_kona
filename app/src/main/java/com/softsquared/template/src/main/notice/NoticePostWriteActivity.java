package com.softsquared.template.src.main.notice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.notice.interfaces.NoticeActivityView;
import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.interfaces.PostActivityView;
import com.softsquared.template.src.main.noticePost.models.NoticePostInfo;
import com.softsquared.template.src.main.notice.models.NoticePostWriteInfo;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class NoticePostWriteActivity extends BaseActivity implements NoticeActivityView {

    private EditText postWriteTitleEt, postWriteContentEt;
    private NoticePostWriteService noticePostWriteService;
    private ConstraintLayout noticePostWriteCompleteBtn;
    private int noticeIdx = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_post_write_layout);
        noticePostWriteService = new NoticePostWriteService(this);
        Intent intent = getIntent();
        if(intent == null)
            Log.e("intent없음", "NoticeActivity::onCreate() intent is null");
        else
        {
            noticeIdx = intent.getIntExtra("noticeIdx", 0);
            Log.e("intent값", "noticeIdx : " + noticeIdx);
        }

        setView();

    }

    public void setView()
    {
        postWriteTitleEt = findViewById(R.id.notice_post_write_title_tv);
        postWriteContentEt = findViewById(R.id.notice_post_writing_tv);
        noticePostWriteCompleteBtn = findViewById(R.id.notice_post_write_complete);

        noticePostWriteCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryPostNoticeWrite();
                Log.e("컨텐츠 작성 성공", "");
                Intent intent = new Intent(NoticePostWriteActivity.this, NoticeActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void tryPostNoticeWrite()
    {
        noticePostWriteService.postNoticeWrite(noticeIdx, postWriteTitleEt.getText().toString(),
                postWriteContentEt.getText().toString(), 0);
    }

    @Override
    public void onSuccessGetNotice(NoticeResponse noticeResponse) {

    }

    @Override
    public void onSuccessGetNoticename(NoticeInfo noticeInfo) {

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
