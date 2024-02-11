package com.scrat.everchanging;

import android.content.Context;

final class ValentinesScene extends Scene {

    private final Valentine valentine;

    ValentinesScene(final Context context) {
        super(ShortTypes.V);
        valentine = new Valentine(context);
    }

    @Override
    public int getFps() {
        return 40;
    }

    @Override
    public boolean hasObjectsInUse() {
        return valentine.objects.objectsInUseCount() != 0;
    }

    public void update(final boolean createObject) {
        valentine.update(createObject);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        valentine.setupPosition(width, height, ratio);
    }

    @Override
    public void render() {
        super.render(valentine);
    }
}
