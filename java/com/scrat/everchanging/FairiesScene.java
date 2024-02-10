package com.scrat.everchanging;

import android.content.Context;

final class FairiesScene extends Scene implements Fairy.CreatorCallback, Fly.CrystalCreatorCallback {

    private final Fairy fairy;
    private final Fly fly;
    private final Crystal crystal;

    FairiesScene(final Context context) {
        super(ShortTypes.F);
        fairy = new Fairy(context);
        fly = new Fly(context);
        crystal = new Crystal(context);
        fairy.registerCallBack(this);
        fly.registerCallBack(this);
    }

    public void update(final boolean createObject) {
        fairy.update(createObject);
        fly.update();
        crystal.update(false);
    }

    @Override
    public void setupPosition(
            final int width,
            final int height,
            final float ratio,
            final int displayRotation
    ) {
        super.createProjectMatrix(width, height, displayRotation);
        fairy.setupPosition(width, height, ratio);
        fly.setupPosition(width, height, ratio);
        crystal.setupPosition(width, height, ratio);
    }

    @Override
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
