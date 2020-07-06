package com.softsquared.template.src.main.notice;

import android.util.Log;

import com.softsquared.template.src.main.notice.interfaces.NoticeActivityView;
import com.softsquared.template.src.main.notice.interfaces.NoticeRetrofitInterface;
import com.softsquared.template.src.main.noticePost.interfaces.PostActivityView;
import com.softsquared.template.src.main.noticePost.interfaces.PostRetrofitInterface;
import com.softsquared.template.src.main.notice.models.NoticePostWriteBody;
import com.softsquared.template.src.main.notice.models.NoticePostWriteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;


public class NoticePostWriteService {


    public NoticePostWriteService(NoticeActivityView noticeActivityView) {
        this.noticeActivityView = noticeActivityView;
    }

    private NoticeActivityView noticeActivityView;

    public void postNoticeWrite(int noticeIdx, String contentTitle, String contentInf, int userStatus)
    {
        NoticeRetrofitInterface noticeRetrofitInterface = getRetrofit().create(NoticeRetrofitInterface.class);
        noticeRetrofitInterface.postNoticeWrite(new NoticePostWriteBody(contentTitle, contentInf, userStatus), noticeIdx).enqueue(new Callback<NoticePostWriteResponse>() {
            @Override
            public void onResponse(Call<NoticePostWriteResponse> call, Response<NoticePostWriteResponse> response) {
                NoticePostWriteResponse noticePostWriteResponse = response.body();
                if(noticePostWriteResponse == null)
                {
                    Log.e(TAG, "Notice Post Response is null");
                    noticeActivityView.onFailurePostWrite();
                }
                else if(!noticePostWriteResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + noticePostWriteResponse.getCode());
                    Log.e(TAG, "" + noticePostWriteResponse.getMessage());
                    noticeActivityView.onFailurePostWrite();
                }
                Log.e("게시판 항목 GET", "Notice post Success!!!!!");
                Log.e("코드", "" + noticePostWriteResponse.getCode());
                Log.e("메시지", "" + noticePostWriteResponse.getMessage());
                noticeActivityView.onSuccessPostWrite(noticePostWriteResponse.getResult());
            }

            @Override
            public void onFailure(Call<NoticePostWriteResponse> call, Throwable t) {
                Log.e("Failure post notice", "NoticeResponse::getNotice: " + t);
                noticeActivityView.onFailurePostWrite();

            }
        });

    }

}
