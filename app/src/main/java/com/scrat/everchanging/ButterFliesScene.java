package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class ButterFliesScene extends Scene {

    private final ButterFlie butterflie;

    ButterFliesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.B);
        butterflie = new ButterFlie(context, calendar);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return butterflie.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        butterflie.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        butterflie.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(butterflie);
    }
}
