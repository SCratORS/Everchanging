package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class EyesScene extends Scene {

    private final Eye eye;
    public EyesScene(final Context context, final Calendar calendar) {
        super(ShortTypes.E);
        eye = new Eye(context, calendar);
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
