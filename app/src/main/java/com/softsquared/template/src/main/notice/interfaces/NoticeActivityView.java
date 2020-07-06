package com.softsquared.template.src.main.notice.interfaces;

import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.models.NoticeDeleteInfo;
import com.softsquared.template.src.main.notice.models.NoticePostWriteInfo;

public interface NoticeActivityView {

    void onSuccessGetNotice(NoticeResponse noticeResponse);

    void onFailureGetNotice();

    void onSuccessPostWrite(NoticePostWriteInfo noticePostWriteInfo);

    void onFailurePostWrite();





}
