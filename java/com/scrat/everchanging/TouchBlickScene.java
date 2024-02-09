package com.scrat.everchanging;

import android.content.Context;

final class TouchBlickScene extends Scene {

    private final TouchBlick touchBlick;

    TouchBlickScene(final Context context) {
        super(ShortTypes.TB);
        touchBlick = new TouchBlick(context);
    }

    @Override
    public boolean hasObjectsInUse() {
        // Always return false so that TouchBlick visibility does not affect other scenes FPS
        return false;
    }

    public void update(final boolean createObject, final float posX, final float posY) {
        touchBlick.update(createObject, posX, posY);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        touchBlick.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(touchBlick);
    }
}
