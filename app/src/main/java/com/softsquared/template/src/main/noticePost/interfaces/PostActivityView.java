package com.softsquared.template.src.main.noticePost.interfaces;

import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.noticePost.models.NoticeDeleteInfo;
import com.softsquared.template.src.main.noticePost.models.NoticePostInfo;

public interface PostActivityView {

    void onSuccessGetPost(NoticePostInfo noticePostInfo);

    void onFailureGetPost();

    void onSuccessDeletePost(NoticeDeleteInfo noticeDeleteInfo);

    void onFailureDeletePost();







}
