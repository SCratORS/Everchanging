package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class SnowsScene extends Scene{

    private final Snow show;

    SnowsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.S);
        show = new Snow(context, calendar);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        show.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        show.update(createObject);
    }

    public void render() {
        super.render(show);
    }
}
