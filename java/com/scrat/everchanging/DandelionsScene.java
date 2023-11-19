package com.scrat.everchanging;

import android.content.Context;

public class DandelionsScene extends Scene {

    private final Dandelion dandelion;

    public DandelionsScene(Context context) {
        super(ShortTypes.D);
        dandelion = new Dandelion(context);
    }

    public void update(boolean createObject) {
        dandelion.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio,  int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        dandelion.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(dandelion);
    }

}
