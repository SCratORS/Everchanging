package com.scrat.everchanging;

import android.content.Context;

public class EyesScene extends Scene {

    private final Eye eye;
    public EyesScene(Context context) {
        super(ShortTypes.E);
        eye = new Eye(context);
    }

    public void update(boolean createObject) {
        eye.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        eye.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(eye);
    }
}
