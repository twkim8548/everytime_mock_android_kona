package com.softsquared.template.src.main.timetable;

import android.util.Log;

import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.interfaces.TimetableRetrofitInterface;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.TAG;
import static com.softsquared.template.src.ApplicationClass.getRetrofit;

public class TimetableService {
    public TimetableActivityView timetableActivityView;

    public TimetableService(TimetableActivityView timetableActivityView)
    {
        this.timetableActivityView = timetableActivityView;
    }

    public void getTimetable()
    {
        final TimetableRetrofitInterface timetableRetrofitInterface = getRetrofit().create(TimetableRetrofitInterface.class);
        timetableRetrofitInterface.getTimetable().enqueue(new Callback<TimetableResponse>() {
            @Override
            public void onResponse(Call<TimetableResponse> call, Response<TimetableResponse> response) {
                TimetableResponse timetableResponse = response.body();
                if(timetableResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    timetableActivityView.onFailureGetTimetable();
                }
                else if(!timetableResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + timetableResponse.getCode());
                    Log.e(TAG, "" + timetableResponse.getMessage());
                    timetableActivityView.onFailureGetTimetable();
                }
                Log.e("클래스 GET 성공", "Class Get Success!!!!!");
                Log.e("코드", "" + timetableResponse.getCode());
                Log.e("메시지", "" + timetableResponse.getMessage());
                timetableActivityView.onSuccessGetTimetable(timetableResponse);
            }

            @Override
            public void onFailure(Call<TimetableResponse> call, Throwable t) {
                Log.e(TAG, "TimetableService::getClass: " + t);
                timetableActivityView.onFailureGetTimetable();

            }

        });
    }
}
