package com.scrat.everchanging;

import android.content.Context;

public class TouchBlickScene extends Scene {

    private final TouchBlick touchBlick;
    public TouchBlickScene(Context context) {
        super(ShortTypes.TB);
        touchBlick = new TouchBlick(context);
    }

    public void update(boolean createObject, float posX, float posY) {
        touchBlick.update(createObject, posX, posY);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        touchBlick.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(touchBlick);
    }
}
