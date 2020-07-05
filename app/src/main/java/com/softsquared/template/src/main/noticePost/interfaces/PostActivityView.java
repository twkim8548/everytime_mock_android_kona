package com.softsquared.template.src.main.noticePost.interfaces;

import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.models.NoticePostInfo;
import com.softsquared.template.src.main.noticePost.models.NoticePostResponse;

public interface PostActivityView {

    void onSuccessGetPost(NoticePostInfo noticePostInfo);

    void onFailureGetPost();



}
