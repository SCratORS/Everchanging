package com.scrat.everchanging;

import android.content.Context;

public class SnowsScene extends Scene{

    private final Snow show;

    SnowsScene(Context context) {
        super(ShortTypes.S);
        show = new Snow(context);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        show.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        show.update(createObject);
    }

    public void render() {
        super.render(show);
    }
}
