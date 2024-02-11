package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class SnowsScene extends Scene {

    private final Snow show;

    SnowsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.S);
        show = new Snow(context, calendar);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return show.objects.objectsInUseCount() != 0;
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        show.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        show.update(createObject);
    }

    @Override
    public void render() {
        super.render(show);
    }
}
