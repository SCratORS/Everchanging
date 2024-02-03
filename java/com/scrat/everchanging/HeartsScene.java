package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class HeartsScene extends Scene implements Rain.FinishCallback {
    private final Rain rain;
    private final Ripple ripple;

    public HeartsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.H);
        rain = new Rain(context, calendar, 1);
        ripple = new Ripple(context, 1);
        rain.registerCallBack(this);
    }

    public void update(boolean createObject) {
        rain.update(createObject);
        ripple.update();
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        rain.setupPosition(width, height, ratio);
        ripple.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(rain);
        super.render(ripple);
    }

    @Override
    public void callingFinishCallback(Object object) {
        ripple.createObject(object);
    }
}
