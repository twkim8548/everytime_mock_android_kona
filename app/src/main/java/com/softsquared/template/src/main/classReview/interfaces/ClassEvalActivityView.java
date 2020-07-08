package com.softsquared.template.src.main.classReview.interfaces;

import com.softsquared.template.src.main.classReview.models.AboutClassInfo;
import com.softsquared.template.src.main.classReview.models.AboutClassResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewInfo;
import com.softsquared.template.src.main.classReview.models.ClassReviewResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.models.HotContentResponse;
import com.softsquared.template.src.main.home.models.RealtimeResponse;
import com.softsquared.template.src.main.home.models.ReviewResponse;

public interface ClassEvalActivityView {

    void onSuccessGetAboutClass(AboutClassInfo aboutClassInfo);

    void onFailureGetAboutClass();

    void onSuccessGetClassReview(ClassReviewInfo classReviewInfo);

    void onFailureGetClassReview();

    void onSuccessGetClassComment(ClassReviewCommentResponse classReviewCommentResponse);

    void onFailureGetClassComment();




}
