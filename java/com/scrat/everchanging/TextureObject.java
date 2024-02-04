package com.scrat.everchanging;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Random;

public class TextureObject {
    String vs_Image =
            "uniform mat4 uMVPMatrix;" +
                    "attribute vec4 vPosition;" +
                    "attribute vec2 a_texCord;" +
                    "varying vec2 v_texCord;" +
                    "void main() {" +
                    "  v_texCord = a_texCord;" +
                    "  gl_Position = uMVPMatrix * vPosition;" +
                    "}";

    String fs_Image =
            "precision mediump float;" +
                    "varying vec2 v_texCord;" +
                    "uniform sampler2D s_texture;" +
                    "uniform vec4 MultiTerm;" +
                    "uniform vec4 AddTerm;" +
                    "uniform vec4 ViewMultiTerm;" +
                    "uniform vec4 ViewAddTerm;" +
                    "uniform float alpha;" +
                    "void main() {" +
                    "  vec4 textureColor = texture2D(s_texture, v_texCord);" +
                    "  textureColor = clamp(((((textureColor * MultiTerm + AddTerm) / 256.0) * ViewMultiTerm + ViewAddTerm) / 256.0) , 0.0, 1.0);" +
                    "  textureColor.a = textureColor.a * alpha;"+
                    "  gl_FragColor = textureColor;" +
                    "}";

    public final ObjectPool objects = new ObjectPool();

    public int width;
    public int height;
    public float ratio;
    public int maxObjects = 30;
    public int minObjects = 5;
    private final float[] sceneMatrix = new float[16];       //Общая матрица Сцены
    private final float[] rotateMatrix = new float[16];     //Матрица поворота
    private final float[] translateMatrix = new float[16];  //Матрица перемещения
    private final float[] scaleMatrix = new float[16];      //Матрица увеличения

    public final int mProgramHandle;
    public final int mAlpha;
    public final int mMultiTermHandle;
    public final int mAddTermHandle;
    public final int mViewMultiTermHandle;
    public final int mViewAddTermHandle;
    public final int mTexture;
    public final int mMVPMatrixHandle;
    public final int mPositionHandle;
    public final int mTexCordHandle;
    public final short[] indices = new short[]{0, 1, 2, 0, 2, 3}; //Описание вершин 2-х треугольников для построения прямоугольника
    public final ShortBuffer drawListBuffer; // Буффер описания вершин для рендера прямоугольника
    public final  FloatBuffer uvBuffer;
    public final TextureManager textureManager;
    Random random = new Random();
    TextureObject(Context context, String[][] textureList, float[][] pivotList) {
        textureManager = new TextureManager(context, textureList, pivotList);
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vs_Image);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fs_Image);
        mProgramHandle = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgramHandle, vertexShader);
        GLES20.glAttachShader(mProgramHandle, fragmentShader);
        GLES20.glLinkProgram(mProgramHandle);
        GLES20.glUseProgram(mProgramHandle);

        mMultiTermHandle = GLES20.glGetUniformLocation (mProgramHandle, "MultiTerm" );
        mAddTermHandle = GLES20.glGetUniformLocation (mProgramHandle, "AddTerm" );
        mViewMultiTermHandle = GLES20.glGetUniformLocation (mProgramHandle, "ViewMultiTerm" );
        mViewAddTermHandle = GLES20.glGetUniformLocation (mProgramHandle, "ViewAddTerm" );
        mAlpha = GLES20.glGetUniformLocation (mProgramHandle, "alpha" );
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "uMVPMatrix");
        mTexture = GLES20.glGetUniformLocation (mProgramHandle, "s_texture" );
        mPositionHandle = GLES20.glGetAttribLocation(mProgramHandle, "vPosition");
        mTexCordHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_texCord" );

        ByteBuffer dlb = ByteBuffer.allocateDirect(indices.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(indices);
        drawListBuffer.position(0);

        ByteBuffer bbb = ByteBuffer.allocateDirect(32);
        bbb.order(ByteOrder.nativeOrder());

        uvBuffer = bbb.asFloatBuffer();
        float[] uvs_0   = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        uvBuffer.put(uvs_0);
        uvBuffer.position(0);

        Matrix.setLookAtM(sceneMatrix, 0, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f, 0f);
        resetMatrix();
    }

    void resetMatrix(){
        Matrix.setIdentityM(rotateMatrix, 0);
        Matrix.setIdentityM(scaleMatrix, 0);
        Matrix.setIdentityM(translateMatrix, 0);
        Matrix.setIdentityM(sceneMatrix, 0);
    }

    public float[] calculateMatrix() {
        //!!!Важна последовательность умножения!!!!
        //т.е. для примера 0 * 1 = 0, но 1 * 0 = 1
        //Сначала берем видовую матрицу поворота  и умножаем её на видовую матрицу увеличения
        //Затем получившийся результат умножаем на видовую матрицу перемещения.
        //                Результат         На что умножаем         Что умножаем
        Matrix.multiplyMM(sceneMatrix, 0, scaleMatrix, 0,rotateMatrix, 0);
        Matrix.multiplyMM(sceneMatrix, 0, translateMatrix, 0,sceneMatrix, 0);
        //Сначала берется матрица поворота, что бы указать угол поворота сцены
        //Затем умножаем на матрицу увеличения, тут в принципе не важно какая первая какая вторая.
        //И только после этого, умножаем на матрицу положения. Тогда объект всегда будет появляться
        //в тех координатах, которые ему зададим, не зависимо от поворота и увеличения.
        return sceneMatrix;
    }


    private int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    protected void setupPosition(int width, int height, float ratio) {
        this.width = width;
        this.height = height;
        this.ratio = ratio;
    }
}
