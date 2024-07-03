package com.scrat.everchanging;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.scrat.everchanging.util.ReusableIterator;

public abstract class Scene {

    public static final int MINIMUM_FPS = 20;

    //    public enum Types       {DEFAULT, BACKGROUND, CRYSTALBLICK, FIREFLIES, DANDELIONS, RAIN, BUTTERFLIES, BATS, EYES, FAIRIES, FIREWORKS, HEARTS, LEAVES, PETALS, SNOW, VALENTINES};
    public enum ShortTypes {DF, BG, CB, FF, D, R, B, BA, E, F, FW, H, L, P, S, V, TB}

    final ShortTypes sceneType;

    private static final float[] projectionMatrix = new float[16]; //Матрица проекции
    private static final float[] matrix = new float[16]; //финальная матрица

    Scene(final ShortTypes type) {
        sceneType = type;
    }

    public int getFps() {
        return MINIMUM_FPS;
    }

    public abstract boolean hasObjectsInUse();

    public abstract void setupPosition(int width, int height, float ratio, int displayRotation);

    public abstract void render();

    protected final void createProjectMatrix(final int width, final int height, final int displayRotation) {
        /*
        Герерируем нулевую матрицу проекции на основе orthom - это без проекции дальности и прочего, у нас не 3D.
        orthom:             frustum:
               near  far           near  far
                 |    |              /    |
        глаз --> |    |     глаз--> |     |
                 |    |              \    |
         */
        Matrix.setIdentityM(projectionMatrix, 0);
        Matrix.orthoM(projectionMatrix, 0, 0, width, height, 0, 0, 1);
    }

    protected final void render(final TextureObject object) {
        if (object.objects.objectsInUseCount() == 0) return;
        //Выбираем номер текстуру (почему-то только с 0 работает)
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        GLES20.glEnableVertexAttribArray(object.mTexCordHandle);
        GLES20.glVertexAttribPointer(object.mTexCordHandle, 2, GLES20.GL_FLOAT, false, 0, object.uvBuffer);
        GLES20.glEnableVertexAttribArray(object.mPositionHandle);

        // Disabled because of SIGSEGV, https://github.com/SCratORS/Everchanging/issues/2
       // GLES20.glUniform1i (object.mTexture, GLES20.GL_TEXTURE0);
        float[] sceneMatrix = object.calculateMatrix();

        final ReusableIterator<Object> iterator = object.objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object subObject = iterator.next();
            //Биндим картинку
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, subObject.texture.textureID);
            //Активируем позиционирование, что бы это нибыло

            //Запихуеваем в шейдер на это позионирование координаты прямоугольника
            GLES20.glVertexAttribPointer(object.mPositionHandle, 3, GLES20.GL_FLOAT, false, 0, subObject.vertexBuffer);

            //Расчитываем феинальную матрицу. Для этого матрицу объекта умножам на
            //матрицу вида. Нам же надо получить объект относительно камеры, а не наоборот
            Matrix.multiplyMM(matrix, 0, sceneMatrix, 0, subObject.calculateMatrix(), 0);
            //И в конце проэцируем на матрицу проекции.
            Matrix.multiplyMM(matrix, 0, projectionMatrix, 0, matrix, 0);

            //И передаем её в шейдер
            GLES20.glUniformMatrix4fv(object.mMVPMatrixHandle, 1, false, matrix, 0);
            //Говорим шейдеру, что:
            // 1. рисовать надо текстурой номер 0

            // 2. Трансформация цвета такая вот
            GLES20.glUniform4fv(object.mViewMultiTermHandle, 1, subObject.ViewColorTransformValue[0], 0);
            GLES20.glUniform4fv(object.mViewAddTermHandle, 1, subObject.ViewColorTransformValue[1], 0);
            GLES20.glUniform4fv(object.mMultiTermHandle, 1, subObject.ColorTransformValue[0], 0);
            GLES20.glUniform4fv(object.mAddTermHandle, 1, subObject.ColorTransformValue[1], 0);

            // 3. Дополнительно общая прозрачность такая вот
            GLES20.glUniform1f(object.mAlpha, subObject.alpha);
            // 4. Skew (это типа раятяжение) такой-то.
            // Как эту фигню расчитать на матрицах - я хз. Но в спеках api adobe написано как это будет
            // выглядеть изнутри. По этому сделаем расчет в шейдере.

            //Все посчитали, передали. Теперь рендерим треугольники согласно буфферу описания вершин треугольников

            GLES20.glDrawElements(GLES20.GL_TRIANGLES, object.indices.length, GLES20.GL_UNSIGNED_SHORT, object.drawListBuffer);
            //Выключаем позиционирование, что бы это нибыло

        }

        iterator.release();

        GLES20.glDisableVertexAttribArray(object.mPositionHandle);
        GLES20.glDisableVertexAttribArray(object.mTexCordHandle);
    }
}
