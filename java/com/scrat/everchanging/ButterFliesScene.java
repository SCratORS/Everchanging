package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class ButterFliesScene extends Scene {
    private final ButterFlie butterflie;
    public ButterFliesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.B);
        butterflie = new ButterFlie(context, calendar);
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
