package com.scrat.everchanging;

import android.content.Context;

public class BatsScene extends Scene {
    private final Bat bat;
    BatsScene(Context context) {
        super(ShortTypes.BA);
        bat = new Bat(context);
    }

    public void update(boolean createObject) {
        bat.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        bat.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(bat);
    }
}
