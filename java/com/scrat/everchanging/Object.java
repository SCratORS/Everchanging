package com.scrat.everchanging;

import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;


public class Object {

    private final float[] modelMatrix = new float[16];      //Общая матрица модели
    private final float[] viewMatrix = new float[16];       //Общая матрица вида
    private final float[] matrix = new float[16];           //Общая матрица

    private final float[] translateMatrix = new float[16];  //Матрица перемещения
    private final float[] scaleMatrix = new float[16];      //Матрица увеличения
    private final float[] rotateMatrix = new float[16];     //Матрица поворота
    private final float[] rotateSkewMatrix = new float[16];     //Матрица поворота

    private final float[] rotateSkewViewMatrix = new float[16];     //Матрица трансформации
    private final float[] translateViewMatrix = new float[16];      //Матрица увеличения вида
    private final float[] scaleViewMatrix = new float[16];      //Матрица увеличения вида
    private final float[] rotateViewMatrix = new float[16];     //Матрица поворота вида

    private final float[] tmpTransformMatrix = new float[16];

    public boolean remove = false;
    public boolean used;

    public float scale = 1.0f;

    public FloatBuffer vertexBuffer; //Буффер описания размеров прямоугольника
    public TextureManager.Texture texture;
    public float[][] ColorTransformValue = {{256, 256, 256, 256}, {0, 0, 0, 0}};
    public float[][] ViewColorTransformValue = {{256, 256, 256, 256}, {0, 0, 0, 0}};
    public float alpha = 1f;

    public int frameCounter = 0;
    public int animCounter = 0;
    public int index = 0;

    public float xscale = 0;
    public float yscale = 0;

    public float x_scalefactor;
    public float y_scalefactor;

    public float rotation = 0;
    public float[] ViewTranslate = {0.0f, 0.0f};
    public float[] viewTransformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public float[] transformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    Object() {
        final ByteBuffer objectVerticesBuffer = ByteBuffer.allocateDirect(12 * 4);
        objectVerticesBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = objectVerticesBuffer.asFloatBuffer();
        resetMatrix();

        if (texture != null) setTexture(texture, scale);
    }

    Object(TextureManager.Texture texture, float scale) {
        this();
        if (texture != null) setTexture(texture, scale);
    }

    void copyFrom(final Object source) {
        System.arraycopy(source.modelMatrix, 0, modelMatrix, 0, modelMatrix.length);
        System.arraycopy(source.viewMatrix, 0, viewMatrix, 0, viewMatrix.length);
        System.arraycopy(source.matrix, 0, matrix, 0, matrix.length);

        System.arraycopy(source.translateMatrix, 0, translateMatrix, 0, translateMatrix.length);
        System.arraycopy(source.scaleMatrix, 0, scaleMatrix, 0, scaleMatrix.length);
        System.arraycopy(source.rotateMatrix, 0, rotateMatrix, 0, rotateMatrix.length);
        System.arraycopy(source.rotateSkewMatrix, 0, rotateSkewMatrix, 0, rotateSkewMatrix.length);

        System.arraycopy(source.rotateSkewViewMatrix, 0, rotateSkewViewMatrix, 0, rotateSkewViewMatrix.length);
        System.arraycopy(source.translateViewMatrix, 0, translateViewMatrix, 0, translateViewMatrix.length);
        System.arraycopy(source.scaleViewMatrix, 0, scaleViewMatrix, 0, scaleViewMatrix.length);
        System.arraycopy(source.rotateViewMatrix, 0, rotateViewMatrix, 0, rotateViewMatrix.length);
        System.arraycopy(source.tmpTransformMatrix, 0, tmpTransformMatrix, 0, tmpTransformMatrix.length);

        System.arraycopy(source.ColorTransformValue, 0, ColorTransformValue, 0, ColorTransformValue.length);
        System.arraycopy(source.ViewColorTransformValue, 0, ViewColorTransformValue, 0, ViewColorTransformValue.length);

        System.arraycopy(source.ViewTranslate, 0, ViewTranslate, 0, ViewTranslate.length);
        System.arraycopy(source.viewTransformMatrix, 0, viewTransformMatrix, 0, viewTransformMatrix.length);
        System.arraycopy(source.transformMatrix, 0, transformMatrix, 0, transformMatrix.length);

        texture = source.texture;
        alpha = source.alpha;

        frameCounter = source.frameCounter;
        animCounter = source.animCounter;
        index = source.index;

        xscale = source.xscale;
        yscale = source.yscale;

        x_scalefactor = source.x_scalefactor;
        y_scalefactor = source.y_scalefactor;

        rotation = source.rotation;
    }

    void setTexture(TextureManager.Texture texture, float scale) {
        if (this.texture != texture) {
            this.texture = texture;
            final float x_width = texture.width * scale;
            final float y_height = texture.height * scale;
            final float x_begin = (0 - texture.pivot[0]) * scale;
            final float y_begin = (0 - texture.pivot[1]) * scale;
            final float x_end = x_begin + x_width;
            final float y_end = y_begin + y_height;

            vertexBuffer.position(0);

            vertexBuffer.put(x_begin);
            vertexBuffer.put(y_begin);
            vertexBuffer.put(0f);
            vertexBuffer.put(x_begin);
            vertexBuffer.put(y_end);
            vertexBuffer.put(0f);
            vertexBuffer.put(x_end);
            vertexBuffer.put(y_end);
            vertexBuffer.put(0f);
            vertexBuffer.put(x_end);
            vertexBuffer.put(y_begin);
            vertexBuffer.put(0f);
            
            vertexBuffer.position(0);
        }
    }

    void setObjectScale(float scale) {
        this.scale = scale;
        Matrix.scaleM(scaleMatrix, 0, scale, scale, 0);
    }
    float getRotation(){
        return rotation;
    }

    float getViewScaleY() {return yscale;}

    void setColorTransform(float[][] colorTransform) {
        ColorTransformValue = colorTransform;
    }

    void setViewColorTransform(float[][] colorTransform) {
        ViewColorTransformValue = colorTransform;
    }

    void resetViewMatrix() {
        Matrix.setIdentityM(viewMatrix, 0);
        Matrix.setIdentityM(translateViewMatrix, 0);
        Matrix.setIdentityM(scaleViewMatrix, 0);
        Matrix.setIdentityM(rotateViewMatrix, 0);
        Matrix.setIdentityM(rotateSkewViewMatrix, 0);
    }

    void setViewRotate(float angle) {
        rotation = angle;
        Matrix.setRotateM(rotateViewMatrix, 0, angle, 0f, 0f, 1f);
    }

    void setViewPosition(float x, float y) {
        Matrix.translateM(translateViewMatrix, 0, x, y, 0);
    }

    void setViewTransform(float[] transform) {
        viewTransformMatrix = transform;
        rotateSkewViewMatrix[0] = transform[0];rotateSkewViewMatrix[1] = transform[2];
        rotateSkewViewMatrix[4] = transform[3];rotateSkewViewMatrix[5] = transform[1];
        rotateSkewViewMatrix[12] = transform[4];rotateSkewViewMatrix[13] = transform[5];
    }

    void setViewTranslate(float translateX, float translateY) {
        ViewTranslate[0] = translateX;
        ViewTranslate[1] = translateY;
        Matrix.translateM(translateViewMatrix, 0, translateX, translateY, 0);
    }

    void setViewScale(float scaleX, float scaleY) {
        //Передавать будем в %, по этому делим на 100.
        xscale = scaleX;
        yscale = scaleY;
        Matrix.scaleM(scaleViewMatrix, 0, scaleX / 100f, scaleY / 100f, 0);
    }


    void resetMatrix() {
        Matrix.setIdentityM(scaleMatrix, 0);
        Matrix.scaleM(scaleMatrix, 0, scale, scale, 0);
        Matrix.setIdentityM(translateMatrix, 0);
        Matrix.setIdentityM(rotateMatrix, 0);
        Matrix.setIdentityM(modelMatrix, 0);
        Matrix.setIdentityM(rotateSkewMatrix, 0);

    }

    void setTransform(float[] transform) {
        transformMatrix = transform;
        Arrays.fill(tmpTransformMatrix,0);
        Matrix.setIdentityM(tmpTransformMatrix, 0);
        tmpTransformMatrix[0] = transform[0];tmpTransformMatrix[1] = transform[2];
        tmpTransformMatrix[4] = transform[3];tmpTransformMatrix[5] = transform[1];
        tmpTransformMatrix[12] = transform[4];tmpTransformMatrix[13] = transform[5];
        Matrix.multiplyMM(rotateSkewMatrix, 0, tmpTransformMatrix, 0, rotateSkewMatrix, 0);
    }

    void setRotate(float angle) {
        Matrix.setRotateM(rotateMatrix, 0, angle, 0, 0, 1f);
    }

    void setTranslate(float translateX, float translateY) {
        Matrix.translateM(translateMatrix, 0, translateX, translateY, 0);
    }

    void setScale(float scaleX, float scaleY) {
        x_scalefactor = scaleX;
        y_scalefactor = scaleY;
        Matrix.scaleM(scaleMatrix, 0, scaleX, scaleY, 0);
    }

    void setAplpha(int alpha) {
        this.alpha = alpha / 100.0f; // 0-100%
    }

    public void setupPosition() {
    }
    public float[] calculateMatrix() {
        //!!!Важна последовательность умножения!!!!
        //т.е. для примера 0 * 1 = 0, но 1 * 0 = 1
        //Сначала берем видовую матрицу поворота  и умножаем её на видовую матрицу увеличения
        //Затем получившийся результат умножаем на видовую матрицу перемещения.
        //                Результат         На что умножаем         Что умножаем
        Matrix.multiplyMM(viewMatrix, 0, scaleViewMatrix, 0, rotateViewMatrix, 0);
        Matrix.multiplyMM(viewMatrix, 0, rotateSkewViewMatrix, 0, viewMatrix, 0);
        Matrix.multiplyMM(viewMatrix, 0, translateViewMatrix, 0, viewMatrix, 0);
        //Сначала берется матрица поворота, что бы указать угол поворота сцены
        //Затем умножаем на матрицу увеличения, тут в принципе не важно какая первая какая вторая.
        //И только после этого, умножаем на матрицу положения. Тогда объект всегда будет появляться
        //в тех координатах, которые ему зададим, не зависимо от поворота и увеличения.
        //Теперь расчитавается матрица объекта.

        Matrix.multiplyMM(modelMatrix, 0, rotateMatrix, 0, scaleMatrix, 0);
        Matrix.multiplyMM(modelMatrix, 0, rotateSkewMatrix, 0, modelMatrix, 0);
        Matrix.multiplyMM(modelMatrix, 0, translateMatrix, 0, modelMatrix, 0);

        //Сначала берется матрица увеличения*поворота и они умножается на матрицу положения.
        //Это дает то, что независимо от увеличения и поворота координата смещения не изменится.
        //Если умножать наоборот, то расстояние перемещения будет изменяться от матрицы увеличения.
        //Расчитываем финальную матрицу. Для этого матрицу объект умножаем на
        //матрицу вида. Нам же надо получить объект относительно камеры, а не наоборот
        Matrix.multiplyMM(matrix, 0, viewMatrix, 0, modelMatrix, 0);
        return matrix;
    }
}

