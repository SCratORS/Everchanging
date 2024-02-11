package com.scrat.everchanging;

import android.content.Context;

final class BatsScene extends Scene {

    private final Bat bat;

    BatsScene(final Context context) {
        super(ShortTypes.BA);
        bat = new Bat(context);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return bat.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        bat.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        bat.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(bat);
    }
}
