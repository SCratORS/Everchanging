package com.scrat.everchanging;

import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;


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

    public boolean remove = false;

    private float scale = 1.0f;

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

    public float rotation = 0;
    public float[] ViewTranslate = {0.0f, 0.0f};
    public float[] viewTransformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public float[] transformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    Object(TextureManager.Texture texture, float scale) {
        if (texture != null) setTexture(texture, scale);
        resetMatrix();
    }

    void setTexture(TextureManager.Texture texture, float scale) {
        this.texture = texture;
        float x_width = texture.width * scale;
        float y_height = texture.height * scale;
        float x_begin = (0 - texture.pivot[0]) * scale;
        float y_begin = (0 - texture.pivot[1]) * scale;
        float x_end = x_begin + x_width;
        float y_end = y_begin + y_height;
        float[] objectVertices = new float[]{x_begin, y_begin, 0f, x_begin, y_end, 0f, x_end, y_end, 0f, x_end, y_begin, 0f};
        ByteBuffer bb = ByteBuffer.allocateDirect(objectVertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(objectVertices);
        vertexBuffer.position(0);
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

/*
    void setRotateSkew(float angleX, float angleY) {
        Matrix.setRotateM(rotateSkewMatrix, 0, 45, 0f, 0f, 1f);
    }
*/
    void setTransform(float[] transform) {
        transformMatrix = transform;
        float[] matrix = new float[16];
        Matrix.setIdentityM(matrix, 0);
        matrix[0] = transform[0];matrix[1] = transform[2];
        matrix[4] = transform[3];matrix[5] = transform[1];
        matrix[12] = transform[4];matrix[13] = transform[5];
        Matrix.multiplyMM(rotateSkewMatrix, 0, matrix, 0, rotateSkewMatrix, 0);
    }

    void setRotate(float angle) {
        Matrix.setRotateM(rotateMatrix, 0, angle, 0, 0, 1f);
    }


    void setTranslate(float translateX, float translateY) {
        Matrix.translateM(translateMatrix, 0, translateX, translateY, 0);
    }

    void setScale(float scaleX, float scaleY) {
        x_scalefactor = scaleX;
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

