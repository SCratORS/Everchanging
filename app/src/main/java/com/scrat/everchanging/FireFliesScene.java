package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class FireFliesScene extends Scene {

    private final FireFlie fireflie;

    FireFliesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.FF);
        fireflie = new FireFlie(context, calendar);
    }

    @Override
    public boolean hasObjectsInUse() {
        return fireflie.objects.objectsInUseCount() != 0;
    }

    @Override
    public int getFps() {
        return 40;
    }

    public void update(final boolean createObject) {
        fireflie.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        fireflie.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(fireflie);
    }
}
