package com.scrat.everchanging;

import android.content.Context;

class PetalsScene extends Scene {

    private final Petal petal;

    PetalsScene(final Context context) {
        super(ShortTypes.P);
        petal = new Petal(context);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return petal.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        petal.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        petal.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(petal);
    }
}
