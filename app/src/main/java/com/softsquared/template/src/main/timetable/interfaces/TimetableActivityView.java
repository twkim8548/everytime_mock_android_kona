package com.softsquared.template.src.main.timetable.interfaces;

import com.softsquared.template.src.main.timetable.models.TimetableResponse;

public interface TimetableActivityView {

    void onSuccessGetTimetable(TimetableResponse timetableResponse);

    void onFailureGetTimetable();
}
