package com.scrat.everchanging;

import android.content.Context;

public class FairiesScene extends Scene implements Fairy.CreatorCallback, Fly.CrystalCreatorCallback {
    private final Fairy fairy;
    private final Fly fly;
    private final Crystal crystal;
    public FairiesScene(Context context) {
        super(ShortTypes.F);
        fairy = new Fairy(context);
        fly = new Fly(context);
        crystal = new Crystal(context);
        fairy.registerCallBack(this);
        fly.registerCallBack(this);
    }

    public void update(boolean createObject) {
        fairy.update(createObject);
        fly.update();
        crystal.update(false);
    }

    public void setupPosition(int width, int height, float ratio, int displayRotation) {
        super.createProjectMatrix(width, height, displayRotation);
        fairy.setupPosition(width, height, ratio);
        fly.setupPosition(width, height, ratio);
        crystal.setupPosition(width, height, ratio);
    }

    public void render() {
        super.render(fairy);
        super.render(crystal);
        super.render(fly);
    }
    @Override
    public void callingCreatorCallback(float[] transform, float[] translate, int xscale, int index) {
        fly.createObject(transform, translate, xscale, index);
    }

    @Override
    public void callingCrystallCreatorCallback(float[] transform, float[] translate) {
        crystal.createObject(transform, translate);
    }

    @Override
    public void callingCrystallEndCallback(float[] transform, float[] translate) {
        crystal.createEndsObject(transform, translate);
    }
}
