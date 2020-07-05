package com.softsquared.template.src.main.community.interfaces;

import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.community.models.PinPostResult;
import com.softsquared.template.src.main.community.models.PinResponse;

public interface CommunityActivityView {

    void onSuccessGetPin(PinResponse pinResponse);

    void onFailureGetPin();

    void onSuccessPostPin(PinPostResult pinPostResult);

    void onFailurePostPin();
}
