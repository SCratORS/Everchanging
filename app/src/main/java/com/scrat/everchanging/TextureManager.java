package com.scrat.everchanging;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

final class TextureManager {

    static class Texture {
        public float[] pivot = {0.0f, 0.0f};
        public float width;
        public float height;
        public int textureID;
        public int textureResId;
    }

    private final Texture[] textures;
    private final Context context;

    private final int[] texturesIDs;

    float dipToPixels(final float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    TextureManager(
            final Context context,
            final int[][] textureResIdsList,
            final float[][] PivotList
    ) {
        this.context = context;
        int texturesCount = 0;

        final int textureResIdsListLength = textureResIdsList.length;
        // Optimization to avoid creating Iterator
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < textureResIdsListLength; i++) {
            final int[] textures = textureResIdsList[i];
            texturesCount += textures.length;
        }

        final int[] bothTextureResIdsList = new int[texturesCount];
        int c = 0;

        // Optimization to avoid creating Iterator
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < textureResIdsListLength; i++) {
            final int[] sublist = textureResIdsList[i];
            final int sublistLength = sublist.length;
            // Optimization to avoid creating Iterator
            //noinspection ForLoopReplaceableByForEach
            for (int s = 0; s < sublistLength; s++) {
                bothTextureResIdsList[c++] = sublist[s];
            }
        }

        texturesIDs = new int[texturesCount];
        textures = new Texture[texturesCount];
        GLES20.glGenTextures(texturesCount, texturesIDs, 0);
        int counter = 0;

        final int texturesIDsLength = texturesIDs.length;
        // Optimization to avoid creating Iterator
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < texturesIDsLength; i++) {
            final int textureID = texturesIDs[i];
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureID);
            textures[counter] = new Texture();
            textures[counter].textureID = textureID;
            textures[counter].textureResId = bothTextureResIdsList[counter];

            final Bitmap picture;
            final Drawable drawable = context.getDrawable(textures[counter].textureResId);
            if (drawable instanceof BitmapDrawable) {
                picture = ((BitmapDrawable) drawable).getBitmap();
                textures[counter].width = picture.getWidth();
                textures[counter].height = picture.getHeight();
            } else if (drawable instanceof VectorDrawable) {
                picture = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                final Canvas canvas = new Canvas(picture);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                textures[counter].width = canvas.getWidth();
                textures[counter].height = canvas.getHeight();
            } else {
                throw new RuntimeException("Unexpected Drawable type: " + drawable);
            }
            if (PivotList != null) {
                textures[counter].pivot[0] = dipToPixels(PivotList[counter][0]);
                textures[counter].pivot[1] = dipToPixels(PivotList[counter][1]);
            } else {
                textures[counter].pivot[0] = textures[counter].width * 0.5f;
                textures[counter].pivot[1] = textures[counter].height * 0.5f;
            }

            GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, picture, 0);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
            counter++;
        }
    }

    Texture getTexture(final int index) {
        return textures[index];
    }

    int getTextureIndex(final int resId) {
        final int texturesLength = textures.length;
        for (int i = 0; i < texturesLength; i++) {
            if (textures[i].textureResId == resId) return i;
        }
        return -1;
    }

    int getTexturesCount() {
        return textures.length;
    }

    int[] getTexturesIndexes() {
        return texturesIDs;
    }
}
