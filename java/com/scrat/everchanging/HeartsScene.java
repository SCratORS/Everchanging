package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class HeartsScene extends Scene implements Rain.FinishCallback {

    private final Rain rain;
    private final Ripple ripple;

    HeartsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.H);
        rain = new Rain(context, calendar, 1);
        ripple = new Ripple(context, 1);
        rain.registerCallBack(this);
    }

    public void update(final boolean createObject) {
        rain.update(createObject);
        ripple.update();
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        rain.setupPosition(width, height, ratio);
        ripple.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(rain);
        super.render(ripple);
    }

    @Override
    public void callingFinishCallback(Object object) {
        ripple.createObjectCopy(object);
    }
}
