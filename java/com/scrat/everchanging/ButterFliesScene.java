package com.scrat.everchanging;

import android.content.Context;

public class ButterFliesScene extends Scene {
    private final ButterFlie butterflie;
    public ButterFliesScene(Context context) {
        super(ShortTypes.B);
        butterflie = new ButterFlie(context);
    }

    public void update(boolean createObject) {
        butterflie.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio,  int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        butterflie.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(butterflie);
    }
}
