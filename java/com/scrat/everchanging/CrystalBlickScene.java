package com.scrat.everchanging;

import android.content.Context;

final class CrystalBlickScene extends Scene {

    private final Crystal crystal;
    private final Blick blick;

    CrystalBlickScene(final Context context) {
        super(ShortTypes.CB);
        crystal = new Crystal(context);
        blick = new Blick(context);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return crystal.objects.objectsInUseCount() != 0 || blick.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        blick.update(createObject);
        crystal.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        crystal.setupPosition(width, height, ratio);
        blick.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(crystal);
        super.render(blick);
    }
}
