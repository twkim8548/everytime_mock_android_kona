package com.softsquared.template.src.main.notice.interfaces;

import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.models.HotContentResponse;
import com.softsquared.template.src.main.home.models.RealtimeResponse;
import com.softsquared.template.src.main.notice.models.NoticeResponse;

public interface NoticeActivityView {

    void onSuccessGetNotice(NoticeResponse noticeResponse);

    void onFailureGetNotice();



}
