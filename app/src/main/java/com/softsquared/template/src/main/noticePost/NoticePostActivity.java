package com.softsquared.template.src.main.noticePost;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.noticePost.interfaces.PostActivityView;
import com.softsquared.template.src.main.noticePost.models.NoticePostInfo;
import com.softsquared.template.src.main.noticePost.models.NoticePostResponse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

public class NoticePostActivity extends BaseActivity implements PostActivityView {

    private NoticePostService noticePostService;
    private GridLayoutManager gridLayoutManager;
    private int contentIdx = 0;

    private ImageView noticePostProfile;
    private TextView noticePostWriter, noticePostDate, noticePostTitle, noticePostArticle,
                     noticePostGood, noticePostComment, noticePostStar;
    private FrameLayout noticePostOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_post_layout);
        noticePostService = new NoticePostService(this);
        Intent intent = getIntent();
        if(intent == null)
            Log.e("intent없음", "NoticeActivity::onCreate() intent is null");
        else
        {
            contentIdx = intent.getIntExtra("contentIdx", 0);
            Log.e("intent값", "contentIdx : " + contentIdx);
        }

        setView();
        noticePostService.getNoticePost(contentIdx);
    }

    private void setView()
    {
        noticePostProfile = findViewById(R.id.notice_post_profile_img);
        noticePostWriter = findViewById(R.id.notice_post_writer_tv);
        noticePostDate = findViewById(R.id.notice_post_wrote_date_tv);
        noticePostTitle = findViewById(R.id.notice_post_title_tv);
        noticePostArticle = findViewById(R.id.notice_post_article_tv);
        noticePostGood = findViewById(R.id.notice_post_good_tv);
        noticePostComment = findViewById(R.id.notice_post_comment_tv);
        noticePostStar = findViewById(R.id.notice_post_star_tv);
        noticePostOption = findViewById(R.id.notice_post_option);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notice_post_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//    }

    @Override
    public void onSuccessGetPost(NoticePostInfo noticePostInfo) {
        noticePostWriter.setText(noticePostInfo.getContentWriter());
        noticePostDate.setText(noticePostInfo.getWriteDay());
        noticePostTitle.setText(noticePostInfo.getContentTitle());
        noticePostArticle.setText(noticePostInfo.getContentInf());
        noticePostGood.setText(String.valueOf(noticePostInfo.getCountLike()));
        noticePostComment.setText(String.valueOf(noticePostInfo.getCountComment()));
        noticePostStar.setText(String.valueOf(noticePostInfo.getCountScrab()));

    }

    @Override
    public void onFailureGetPost() {

    }
}
