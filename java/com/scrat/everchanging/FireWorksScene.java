package com.scrat.everchanging;

import android.content.Context;

import java.util.Calendar;

public class FireWorksScene extends Scene{
    private final FireWork firework;
    FireWorksScene(final Context context, final Calendar calendar) {
        super(ShortTypes.FW);
        firework = new FireWork(context, calendar);
    }
    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        firework.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        firework.update(createObject);
    }

    public void render() {
        super.render(firework);
    }
}
