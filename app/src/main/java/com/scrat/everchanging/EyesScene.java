package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class EyesScene extends Scene {

    private final Eye eye;

    EyesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.E);
        eye = new Eye(context, calendar);
    }

    @Override
    public boolean hasObjectsInUse() {
        return eye.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject, final int actualFps) {
        eye.update(createObject, getFps() * 2 == actualFps);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        eye.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(eye);
    }
}
