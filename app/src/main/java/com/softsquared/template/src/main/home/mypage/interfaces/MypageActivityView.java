package com.softsquared.template.src.main.home.mypage.interfaces;

import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.mypage.models.MypageInfo;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;

public interface MypageActivityView {

    void onSuccessGetMypage(MypageInfo mypageInfo);

    void onFailureGetMypage();


}
