package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class BackgroundScene extends Scene {

    private final Calendar calendar;

    private final Background background;
    private final Foreground foreground;

    private int currentSeason;
    private int currentForeground;
    private int currentTimesOfDay;

    BackgroundScene(final Context context, final Calendar calendar) {
        super(ShortTypes.BG);
        this.calendar = calendar;
        background = new Background(context);
        foreground = new Foreground(context);
    }

    @Override
    public int getFps() {
        return 1;
    }

    private void GetDateTime() {
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int r_day = currentDay;
        if (r_day > 30) r_day = 30;
        currentSeason = ((r_day - 1) + ((currentMonth - 1) * 30)) / 10 % 4;
        currentForeground = currentSeason;
        if ((currentMonth == 1 && currentDay == 1) ||
                (currentMonth == 12 && currentDay == 31)) {
            currentSeason = 4;
            currentForeground = 4;
        }
        if ((currentMonth == 1 && currentDay == 6) ||
                (currentMonth == 1 && currentDay == 7) ||
                (currentMonth == 2 && currentDay == 14)) {
            currentSeason = 4;
            currentForeground = 6;
        }
        if (currentMonth == 10 && currentDay == 31) {
            currentSeason = 1;
            currentForeground = 7;
        }
        if ((currentMonth == 12 && currentDay == 24) ||
                (currentMonth == 12 && currentDay == 25)) {
            currentSeason = 4;
            currentForeground = 5;
        }
        if (currentHour == 0) currentTimesOfDay = 6;
        if (currentHour > 0) currentTimesOfDay = 0;
        if (currentHour > 6) currentTimesOfDay = 1;
        if (currentHour > 7) currentTimesOfDay = 2;
        if (currentHour > 8) currentTimesOfDay = 3;
        if (currentHour > 18) currentTimesOfDay = 4;
        if (currentHour > 19) currentTimesOfDay = 5;
        if (currentHour > 20) currentTimesOfDay = 6;
    }

    public void update() {
        GetDateTime();
        background.update(currentSeason, currentTimesOfDay);
        foreground.update(currentForeground, currentTimesOfDay);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        background.setupPosition(width, height, ratio);
        foreground.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(background);
        super.render(foreground);
    }
}
