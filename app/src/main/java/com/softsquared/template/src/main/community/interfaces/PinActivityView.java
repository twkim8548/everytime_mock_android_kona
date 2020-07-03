package com.softsquared.template.src.main.community.interfaces;

import com.softsquared.template.src.main.community.models.PinInfo;

public interface PinActivityView {

    void onSuccessGetPin(PinInfo pinInfo);

    void onFailureGetPin();
}
