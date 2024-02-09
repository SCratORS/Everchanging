package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

final class LeavesScene extends Scene {

    private final Leave leave;

    LeavesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.L);
        leave = new Leave(context, calendar);
    }

    @Override
    public boolean hasObjectsInUse() {
        return leave.objects.objectsInUseCount() != 0;
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        leave.setupPosition(width, height, ratio);
    }

    public void update(final boolean createObject) {
        leave.update(createObject);
    }

    @Override
    public void render() {
        super.render(leave);
    }
}
