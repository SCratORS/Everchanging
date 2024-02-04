package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class DandelionsScene extends Scene {

    private final Dandelion dandelion;

    public DandelionsScene(final Context context, final Calendar calendar) {
        super(ShortTypes.D);
        dandelion = new Dandelion(context, calendar);
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
