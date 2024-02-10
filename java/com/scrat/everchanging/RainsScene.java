package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class RainsScene extends Scene implements Rain.FinishCallback {

    private final Rain rain;
    private final Ripple ripple;

    RainsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.R);
        rain = new Rain(context, calendar, 0);
        ripple = new Ripple(context, 0);
        rain.registerCallBack(this);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return rain.objects.objectsInUseCount() != 0 || ripple.objects.objectsInUseCount() != 0;
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
    public void callingFinishCallback(final Object object) {
        ripple.createObjectCopy(object);
    }
}
