package com.softsquared.template.src.main.timetable.interfaces;

import com.softsquared.template.src.main.timetable.models.AddTimetableResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableListResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableResponse;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

public interface TimetableActivityView {

    void onSuccessGetTimetable(TimetableResponse timetableResponse);

    void onFailureGetTimetable();

    void onSuccessGetMyTimetable(MyTimetableResponse myTimetableResponse);

    void onFailureGetMyTimetable();

    void onSuccessPostAddMyTimetable(AddTimetableResponse addTimetableResponse);

    void onFailurePostAddMyTimetable();

    void onSuccessGetMyTimetableList(MyTimetableListResponse myTimetableListResponse);

    void onFailureGetMyTimetableList();


}
