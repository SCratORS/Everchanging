package com.scrat.everchanging;

import android.content.Context;

public class FireFliesScene extends Scene {

    private final FireFlie fireflie;

    public FireFliesScene(Context context) {
        super(ShortTypes.FF);
        fireflie = new FireFlie(context);
    }

    public void update(boolean createObject) {
        fireflie.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        fireflie.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(fireflie);
    }
}
