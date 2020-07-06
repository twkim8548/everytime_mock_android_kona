package com.softsquared.template.src.main.noticePost;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.notice.NoticeActivity;
import com.softsquared.template.src.main.notice.NoticePostWriteActivity;
import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.interfaces.PostActivityView;
import com.softsquared.template.src.main.noticePost.models.NoticeDeleteInfo;
import com.softsquared.template.src.main.noticePost.models.NoticePostInfo;
import com.softsquared.template.src.main.notice.models.NoticePostWriteInfo;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

public class NoticePostActivity extends BaseActivity implements PostActivityView {

    private NoticePostService noticePostService;
    private GridLayoutManager gridLayoutManager;
    private NoticeActivity noticeActivity;
    private NoticeResponse noticeResponse;
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
        noticePostOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.notice_post_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.notice_post_option_revise:
                                break;
                            case R.id.notice_post_option_delete:
                                deleteNotice();
                                Intent intent = new Intent(NoticePostActivity.this, NoticeActivity.class);
                                startActivity(intent);
                                finish();
                                break;

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

        public void deleteNotice()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("삭제하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                noticePostService.deleteNoticePost(contentIdx);
                Toast.makeText(NoticePostActivity.this, "삭제완료", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




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

    @Override
    public void onSuccessDeletePost(NoticeDeleteInfo noticeDeleteInfo) {
        noticeActivity.noticeAdapter.clear();
        for(NoticeInfo noticeInfo : noticeResponse.getResult())
        {
            noticeActivity.noticeAdapter.add(noticeInfo);
        }
        noticeActivity.noticeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureDeletePost() {

    }


}
