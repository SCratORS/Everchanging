package com.scrat.everchanging;


import android.content.Context;

public class PetalsScene extends Scene {
    private final Petal petal;

    public PetalsScene(Context context) {
        super(ShortTypes.P);
        petal = new Petal(context);
    }

    public void update(boolean createObject) {
        petal.update(createObject);
    }

    public void setupPosition(int width, int height, float ratio,  int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        petal.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(petal);
    }
}
