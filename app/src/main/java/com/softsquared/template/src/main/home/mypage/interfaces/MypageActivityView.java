package com.softsquared.template.src.main.home.mypage.interfaces;

import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.mypage.models.MypageInfo;
import com.softsquared.template.src.main.home.mypage.models.MypageResponse;
import com.softsquared.template.src.main.home.mypage.models.NickChangeInfo;

public interface MypageActivityView {

    void onSuccessGetMypage(MypageInfo mypageInfo);

    void onFailureGetMypage();

    void onSuccessPatchUser(NickChangeInfo nickChangeInfo);

    void onFailuerPatchUser();


}
