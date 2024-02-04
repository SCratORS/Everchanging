package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class RainsScene extends Scene implements Rain.FinishCallback {

    private final Rain rain;
    private final Ripple ripple;

    public RainsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.R);
        rain = new Rain(context, calendar, 0);
        ripple = new Ripple(context, 0);
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
        ripple.createObjectCopy(object);
    }
}
