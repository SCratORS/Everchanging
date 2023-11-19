package com.scrat.everchanging;

import android.content.Context;

public class CrystalBlickScene extends Scene {

    private final Crystal crystal;
    private final Blick blick;

    public CrystalBlickScene(Context context) {
        super(ShortTypes.CB);
        crystal = new Crystal(context);
        blick = new Blick(context);
    }

    public void update(boolean createObject) {
        blick.update(createObject);
        crystal.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio,  int displayRotation) {
        super.createProjectMatrix(width, height,  displayRotation);
        crystal.setupPosition(width, height, ratio);
        blick.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(crystal);
        super.render(blick);
    }
}
