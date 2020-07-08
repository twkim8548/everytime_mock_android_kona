package com.softsquared.template.src.main.timetable;

import android.util.Log;

import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.interfaces.TimetableRetrofitInterface;
import com.softsquared.template.src.main.timetable.models.AddTimetableBody;
import com.softsquared.template.src.main.timetable.models.AddTimetableResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableListResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableResponse;
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
    public void getMyTimetable(int timeTableIdx)
    {
        final TimetableRetrofitInterface timetableRetrofitInterface = getRetrofit().create(TimetableRetrofitInterface.class);
        timetableRetrofitInterface.getMyTimetable(1).enqueue(new Callback<MyTimetableResponse>() {
            @Override
            public void onResponse(Call<MyTimetableResponse> call, Response<MyTimetableResponse> response) {
                MyTimetableResponse myTimetableResponse = response.body();
                if(myTimetableResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    timetableActivityView.onFailureGetMyTimetable();
                }
                else if(!myTimetableResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + myTimetableResponse.getCode());
                    Log.e(TAG, "" + myTimetableResponse.getMessage());
                    timetableActivityView.onFailureGetMyTimetable();
                }
                Log.e("클래스 GET 성공", "Class Get Success!!!!!");
                Log.e("코드", "" + myTimetableResponse.getCode());
                Log.e("메시지", "" + myTimetableResponse.getMessage());
                timetableActivityView.onSuccessGetMyTimetable(myTimetableResponse);

            }

            @Override
            public void onFailure(Call<MyTimetableResponse> call, Throwable t) {
                Log.e(TAG, "TimetableService::getClass: " + t);
                timetableActivityView.onFailureGetTimetable();

            }

        });
    }

    public void postAddTimetable(int timeTableIdx, int classIdx)
    {
        final TimetableRetrofitInterface timetableRetrofitInterface = getRetrofit().create(TimetableRetrofitInterface.class);
        timetableRetrofitInterface.postAddTimetable(timeTableIdx, new AddTimetableBody(classIdx)).enqueue(new Callback<AddTimetableResponse>() {
            @Override
            public void onResponse(Call<AddTimetableResponse> call, Response<AddTimetableResponse> response) {
                AddTimetableResponse addTimetableResponse = response.body();
                if(addTimetableResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    timetableActivityView.onFailurePostAddMyTimetable();
                }
                else if(!addTimetableResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + addTimetableResponse.getCode());
                    Log.e(TAG, "" + addTimetableResponse.getMessage());
                    timetableActivityView.onFailurePostAddMyTimetable();
                }
                Log.e("클래스 GET 성공", "Class Get Success!!!!!");
                Log.e("코드", "" + addTimetableResponse.getCode());
                Log.e("메시지", "" + addTimetableResponse.getMessage());
                timetableActivityView.onSuccessPostAddMyTimetable(addTimetableResponse);
            }

            @Override
            public void onFailure(Call<AddTimetableResponse> call, Throwable t) {
                Log.e(TAG, "TimetableService::getClass: " + t);
                timetableActivityView.onFailurePostAddMyTimetable();

            }

        });
    }
    public void getMyTimetableList()
    {
        final TimetableRetrofitInterface timetableRetrofitInterface = getRetrofit().create(TimetableRetrofitInterface.class);
        timetableRetrofitInterface.getMyTimetableList().enqueue(new Callback<MyTimetableListResponse>() {
            @Override
            public void onResponse(Call<MyTimetableListResponse> call, Response<MyTimetableListResponse> response) {
                MyTimetableListResponse myTimetableListResponse = response.body();
                if(myTimetableListResponse == null)
                {
                    Log.e(TAG, "PinResponse is null");
                    timetableActivityView.onFailureGetMyTimetableList();
                }
                else if(!myTimetableListResponse.getIsSuccess())
                {
                    Log.e(TAG, "" + myTimetableListResponse.getCode());
                    Log.e(TAG, "" + myTimetableListResponse.getMessage());
                    timetableActivityView.onFailureGetMyTimetableList();
                }
                Log.e("클래스 GET 성공", "Class Get Success!!!!!");
                Log.e("코드", "" + myTimetableListResponse.getCode());
                Log.e("메시지", "" + myTimetableListResponse.getMessage());
                timetableActivityView.onSuccessGetMyTimetableList(myTimetableListResponse);
            }

            @Override
            public void onFailure(Call<MyTimetableListResponse> call, Throwable t) {
                Log.e(TAG, "TimetableService::getClass: " + t);
                timetableActivityView.onFailureGetMyTimetableList();

            }

        });
    }


}
