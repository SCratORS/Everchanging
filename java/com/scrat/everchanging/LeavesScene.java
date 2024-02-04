package com.scrat.everchanging;

import android.content.Context;
public class LeavesScene extends Scene {
    private final Leave leave;
    LeavesScene(Context context) {
        super(ShortTypes.L);
        leave = new Leave(context);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        leave.setupPosition(width, height, ratio);
    }

    public void update(boolean createObject) {
        leave.update(createObject);

    }

    public void render() {
        super.render(leave);
    }
}
