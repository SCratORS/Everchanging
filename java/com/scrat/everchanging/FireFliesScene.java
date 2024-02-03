package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class FireFliesScene extends Scene {

    private final FireFlie fireflie;

    public FireFliesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.FF);
        fireflie = new FireFlie(context, calendar);
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
