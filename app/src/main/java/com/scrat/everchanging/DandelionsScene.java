package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class DandelionsScene extends Scene {

    private final Dandelion dandelion;

    DandelionsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.D);
        dandelion = new Dandelion(context, calendar);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return dandelion.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        dandelion.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        dandelion.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(dandelion);
    }
}
