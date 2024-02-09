package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class FireWorksScene extends Scene {

    private final FireWork firework;

    FireWorksScene(final Context context, final Calendar calendar) {
        super(ShortTypes.FW);
        firework = new FireWork(context, calendar);
    }

    @Override
    public boolean hasObjectsInUse() {
        return firework.objects.objectsInUseCount() != 0;
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        firework.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        firework.update(createObject);
    }

    @Override
    public void render() {
        super.render(firework);
    }
}
