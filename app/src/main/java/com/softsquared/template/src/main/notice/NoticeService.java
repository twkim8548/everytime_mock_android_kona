package com.softsquared.template.src.main.notice;

import android.util.Log;

import com.softsquared.template.src.main.community.models.PinBody;
import com.softsquared.template.src.main.notice.interfaces.NoticeActivityView;
import com.softsquared.template.src.main.notice.interfaces.NoticeRetrofitInterface;
import com.softsquared.template.src.main.notice.models.NoticeResponse;
import com.softsquared.template.src.main.noticePost.interfaces.PostRetrofitInterface;
import com.softsquared.template.src.main.noticePost.models.NoticeDeleteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class NoticeService {

    private NoticeActivityView noticeActivityView;
    private PinBody pinBody;

    public NoticeService(NoticeActivityView noticeActivityView) {
        this.noticeActivityView = noticeActivityView;
    }

    public void getNotice(int noticeIdx)
    {
        NoticeRetrofitInterface noticeRetrofitInterface = getRetrofit().create(NoticeRetrofitInterface.class);
        Log.e("noticeIdx", " "+ noticeIdx);
        noticeRetrofitInterface.getNotice(noticeIdx).enqueue(new Callback<NoticeResponse>() {
            @Override
            public void onResponse(Call<NoticeResponse> call, Response<NoticeResponse> response) {
                NoticeResponse noticeResponse = response.body();
                if(noticeResponse == null)
                {
                    Log.e(TAG, "LoginResponse is null");
                    noticeActivityView.onFailureGetNotice();
                }
                else if(!noticeResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + noticeResponse.getCode());
                    Log.e(TAG, "" + noticeResponse.getMessage());
                    noticeActivityView.onFailureGetNotice();
                }
                Log.e("게시판 항목 GET", "Notice Get Success!!!!!");
                Log.e("코드", "" + noticeResponse.getCode());
                Log.e("메시지", "" + noticeResponse.getMessage());
                noticeActivityView.onSuccessGetNotice(noticeResponse);

            }

            @Override
            public void onFailure(Call<NoticeResponse> call, Throwable t) {
                Log.e("Failure get notice", "NoticeResponse::getNotice: " + t);
                noticeActivityView.onFailureGetNotice();
            }
        });

    }
//
}
