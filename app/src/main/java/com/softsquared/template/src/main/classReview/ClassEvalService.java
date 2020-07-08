package com.softsquared.template.src.main.classReview;

import android.util.Log;

import com.softsquared.template.src.main.classReview.interfaces.ClassEvalActivityView;
import com.softsquared.template.src.main.classReview.interfaces.ClassEvalRetorfitInterface;
import com.softsquared.template.src.main.classReview.models.AboutClassResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewResponse;
import com.softsquared.template.src.main.community.models.PinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class ClassEvalService {

    public ClassEvalActivityView classEvalActivityView;

    public ClassEvalService(ClassEvalActivityView classEvalActivityView) {
        this.classEvalActivityView = classEvalActivityView;
    }

    public void getAboutClass(int classIdx) {
        ClassEvalRetorfitInterface classEvalRetorfitInterface = getRetrofit().create(ClassEvalRetorfitInterface.class);
        classEvalRetorfitInterface.getAboutClass(classIdx).enqueue(new Callback<AboutClassResponse>() {
            @Override
            public void onResponse(Call<AboutClassResponse> call, Response<AboutClassResponse> response) {
                AboutClassResponse aboutClassResponse = response.body();
                if (aboutClassResponse == null) {
                    Log.e(TAG, "PinResponse is null");
                    classEvalActivityView.onFailureGetAboutClass();
                } else if (!aboutClassResponse.getIsSuccess()) {
                    Log.e(TAG, "" + aboutClassResponse.getCode());
                    Log.e(TAG, "" + aboutClassResponse.getMessage());
                    classEvalActivityView.onFailureGetAboutClass();
                }
                Log.e("강의 정보 GET", "AboutClass Get Success!!!!!");
                Log.e("코드", "" + aboutClassResponse.getCode());
                Log.e("메시지", "" + aboutClassResponse.getMessage());
                classEvalActivityView.onSuccessGetAboutClass(aboutClassResponse.getResult().get(0));
            }

            @Override
            public void onFailure(Call<AboutClassResponse> call, Throwable t) {
                Log.e("강의 얻기 실패", "Aboutclass " + t);
                classEvalActivityView.onFailureGetAboutClass();

            }
        });
    }

    public void getClassReview(int classIdx) {
        ClassEvalRetorfitInterface classEvalRetorfitInterface = getRetrofit().create(ClassEvalRetorfitInterface.class);
        classEvalRetorfitInterface.getClassReviewResponse(classIdx).enqueue(new Callback<ClassReviewResponse>() {
            @Override
            public void onResponse(Call<ClassReviewResponse> call, Response<ClassReviewResponse> response) {
                ClassReviewResponse classReviewResponse = response.body();
                if (classReviewResponse == null) {
                    Log.e(TAG, "PinResponse is null");
                    classEvalActivityView.onFailureGetClassReview();
                } else if (!classReviewResponse.getIsSuccess()) {
                    Log.e(TAG, "" + classReviewResponse.getCode());
                    Log.e(TAG, "" + classReviewResponse.getMessage());
                    classEvalActivityView.onFailureGetClassReview();
                }
                Log.e("강의 정보 GET", "AboutClass Get Success!!!!!");
                Log.e("코드", "" + classReviewResponse.getCode());
                Log.e("메시지", "" + classReviewResponse.getMessage());
                classEvalActivityView.onSuccessGetClassReview(classReviewResponse.getResult().get(0));
            }

            @Override
            public void onFailure(Call<ClassReviewResponse> call, Throwable t) {

            }
        });
    }

    public void getClassReviewComment(int classIdx) {
        ClassEvalRetorfitInterface classEvalRetorfitInterface = getRetrofit().create(ClassEvalRetorfitInterface.class);
        classEvalRetorfitInterface.getClassReviewCommentResponse(classIdx).enqueue(new Callback<ClassReviewCommentResponse>() {
            @Override
            public void onResponse(Call<ClassReviewCommentResponse> call, Response<ClassReviewCommentResponse> response) {
                ClassReviewCommentResponse classReviewCommentResponse = response.body();
                if (classReviewCommentResponse == null) {
                    Log.e(TAG, "PinResponse is null");
                    classEvalActivityView.onFailureGetClassComment();
                } else if (!classReviewCommentResponse.getIsSuccess()) {
                    Log.e(TAG, "" + classReviewCommentResponse.getCode());
                    Log.e(TAG, "" + classReviewCommentResponse.getMessage());
                    classEvalActivityView.onFailureGetClassComment();
                }
                Log.e("강의 정보 GET", "AboutClass Get Success!!!!!");
                Log.e("코드", "" + classReviewCommentResponse.getCode());
                Log.e("메시지", "" + classReviewCommentResponse.getMessage());
                classEvalActivityView.onSuccessGetClassComment(classReviewCommentResponse);
            }

            @Override
            public void onFailure(Call<ClassReviewCommentResponse> call, Throwable t) {

            }
        });
    }
}
