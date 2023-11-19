package com.scrat.everchanging;

import android.content.Context;

public class ValentinesScene extends Scene {
    private final Valentine valentine;
    public ValentinesScene(Context context) {
        super(ShortTypes.V);
        valentine = new Valentine(context);
    }

    public void update(boolean createObject) {
        valentine.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        valentine.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(valentine);
    }
}
