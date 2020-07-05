package com.softsquared.template.src.main.noticePost;

import android.util.Log;

import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.interfaces.PostActivityView;
import com.softsquared.template.src.main.noticePost.interfaces.PostRetrofitInterface;
import com.softsquared.template.src.main.noticePost.models.NoticePostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;


public class NoticePostService {

    public NoticePostService(PostActivityView postActivityView) {
        this.postActivityView = postActivityView;
    }

    private PostActivityView postActivityView;

    public void getNoticePost(int contentIdx)
    {
        PostRetrofitInterface postRetrofitInterface = getRetrofit().create(PostRetrofitInterface.class);
        postRetrofitInterface.getNotice(contentIdx).enqueue(new Callback<NoticePostResponse>() {
            @Override
            public void onResponse(Call<NoticePostResponse> call, Response<NoticePostResponse> response) {
                NoticePostResponse noticePostResponse = response.body();
                if(noticePostResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    postActivityView.onFailureGetPost();
                }
                else if(!noticePostResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + noticePostResponse.getCode());
                    Log.e(TAG, "" + noticePostResponse.getMessage());
                    postActivityView.onFailureGetPost();
                }
                Log.e("게시판 항목 GET", "Notice Get Success!!!!!");
                Log.e("코드", "" + noticePostResponse.getCode());
                Log.e("메시지", "" + noticePostResponse.getMessage());
                postActivityView.onSuccessGetPost(noticePostResponse.getResult());
            }

            @Override
            public void onFailure(Call<NoticePostResponse> call, Throwable t) {
                Log.e("Failure get notice", "NoticeResponse::getNotice: " + t);
                postActivityView.onFailureGetPost();

            }
        });

    }

}
