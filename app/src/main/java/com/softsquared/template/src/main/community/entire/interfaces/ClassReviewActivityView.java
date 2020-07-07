package com.softsquared.template.src.main.community.entire.interfaces;

import com.softsquared.template.src.main.community.entire.models.ClassCommentResponse;
import com.softsquared.template.src.main.community.entire.models.MyClassResponse;
import com.softsquared.template.src.main.community.models.PinPostResult;
import com.softsquared.template.src.main.community.models.PinResponse;

public interface ClassReviewActivityView {

    void onSuccessGetMyClass(MyClassResponse myClassResponse);

    void onFailureGetMyClass();

    void onSuccessGetComment(ClassCommentResponse classCommentResponse);

    void onFailureGetComment();
}
