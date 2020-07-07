package com.softsquared.template.src.main.community.entire;

import android.util.Log;

import com.softsquared.template.src.main.community.entire.interfaces.ClassReviewActivityView;
import com.softsquared.template.src.main.community.entire.interfaces.ClassReviewRetrofitInterface;
import com.softsquared.template.src.main.community.entire.models.ClassCommentResponse;
import com.softsquared.template.src.main.community.entire.models.MyClassResponse;
import com.softsquared.template.src.main.community.interfaces.CommunityRetrofitInterface;
import com.softsquared.template.src.main.community.models.PinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class ClassReviewService {

    public ClassReviewActivityView classReviewActivityView;

    public ClassReviewService(ClassReviewActivityView classReviewActivityView) {
        this.classReviewActivityView = classReviewActivityView;
    }

    public void getMyClass()
    {
        final ClassReviewRetrofitInterface classReviewRetrofitInterface = getRetrofit().create(ClassReviewRetrofitInterface.class);
        classReviewRetrofitInterface.getMyClass().enqueue(new Callback<MyClassResponse>() {
            @Override
            public void onResponse(Call<MyClassResponse> call, Response<MyClassResponse> response) {
                MyClassResponse myClassResponse = response.body();
                if(myClassResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    classReviewActivityView.onFailureGetMyClass();
                }
                else if(!myClassResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + myClassResponse.getCode());
                    Log.e(TAG, "" + myClassResponse.getMessage());
                    classReviewActivityView.onFailureGetMyClass();
                }
                Log.e("내 강의평 GET", "Pin Community Get Success!!!!!");
                Log.e("코드", "" + myClassResponse.getCode());
                Log.e("메시지", "" + myClassResponse.getMessage());
                classReviewActivityView.onSuccessGetMyClass(myClassResponse);
            }

            @Override
            public void onFailure(Call<MyClassResponse> call, Throwable t) {
                Log.e(TAG, "CommunityService::getPinList: " + t);
                classReviewActivityView.onFailureGetMyClass();

            }

        });
    }

    public void getClassComment()
    {
        final ClassReviewRetrofitInterface classReviewRetrofitInterface = getRetrofit().create(ClassReviewRetrofitInterface.class);
        classReviewRetrofitInterface.getClassComment().enqueue(new Callback<ClassCommentResponse>() {
            @Override
            public void onResponse(Call<ClassCommentResponse> call, Response<ClassCommentResponse> response) {
                ClassCommentResponse classCommentResponse = response.body();
                if(classCommentResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    classReviewActivityView.onFailureGetComment();
                }
                else if(!classCommentResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + classCommentResponse.getCode());
                    Log.e(TAG, "" + classCommentResponse.getMessage());
                    classReviewActivityView.onFailureGetComment();
                }
                Log.e("최근 강의평 GET", "Pin Community Get Success!!!!!");
                Log.e("코드", "" + classCommentResponse.getCode());
                Log.e("메시지", "" + classCommentResponse.getMessage());
                classReviewActivityView.onSuccessGetComment(classCommentResponse);
            }

            @Override
            public void onFailure(Call<ClassCommentResponse> call, Throwable t) {
                Log.e(TAG, "CommunityService::getPinList: " + t);
                classReviewActivityView.onFailureGetComment();

            }

        });
    }
}
