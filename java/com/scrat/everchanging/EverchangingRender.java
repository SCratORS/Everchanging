package com.scrat.everchanging;

import static com.scrat.everchanging.Scene.ShortTypes.B;
import static com.scrat.everchanging.Scene.ShortTypes.BA;
import static com.scrat.everchanging.Scene.ShortTypes.CB;
import static com.scrat.everchanging.Scene.ShortTypes.D;
import static com.scrat.everchanging.Scene.ShortTypes.E;
import static com.scrat.everchanging.Scene.ShortTypes.F;
import static com.scrat.everchanging.Scene.ShortTypes.FF;
import static com.scrat.everchanging.Scene.ShortTypes.FW;
import static com.scrat.everchanging.Scene.ShortTypes.H;
import static com.scrat.everchanging.Scene.ShortTypes.L;
import static com.scrat.everchanging.Scene.ShortTypes.P;
import static com.scrat.everchanging.Scene.ShortTypes.R;
import static com.scrat.everchanging.Scene.ShortTypes.S;
import static com.scrat.everchanging.Scene.ShortTypes.V;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Calendar;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class EverchangingRender implements GLSurfaceView.Renderer {

    // @formatter:off

    /*  TIME ANIMATION  */
    /*
    +----+--------------------------------------------------------------------------------------------------+
    |time|	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23	|
    +----+--------------------------------------------------------------------------------------------------+
    | 1	 |	E	E		E	E		FF	FF		B	B			B	B		B	B			FF	FF	FF		|
    | 2  |	FF	FF	E	E		E	E		FF	FF			R	R		B	B	R	R		FF	FF	R	R	|
    | 3  |		FF	FF			FF	FF	FF			R	R	R			R	R			FF	FF		FF	FF	|
    | 4  |	E	E	E	E			FF	FF		B	B	D	D		D	D	D				FF	FF	FF		|
    | 5  |			E	E	E		FF	FF			P	P		P	P	P					FF	FF	FF		|
    | 6  |		E	E	E	E		FF	FF			B	B	P	P		B	B	P	P	FF	FF		FF	FF	|
    | 7  |		FF	FF			FF	FF	FF			L	L				L	L	L		FF	FF		FF	FF	|
    | 8  |						R	R			R	R		R	R	L	L		L	L		R	R	FF	FF	|
    | 9  |		FF	FF	S	S	FF	FF	FF				S	S		S	S				FF	FF		FF	FF	|
    | 10 |	E	E		E	E	S	S			S	S				S	S			S	S			S	S	|
    | 11 |	E	E	E	E			FF	FF		D	D	D		D	D	D	D	D			FF	FF	FF		|
    | 12 |	E	E	F	F	F		FF	FF		B	B			B	B		B	B			FF	FF	FF		|
    | C  |	S	S	S		S	S			S	S			S	S	S	S		S	S		S	S	S		|Christmas
    | N  |	FW	FW	FW	FW	FW		FF	FF					B	B			B	B			FF	FF			|New Year
    | Ch |			E	E	E		FF	FF			S	S	FW	FW		S	S		FW	FW	FF	FF	FW	FW	|Chinese New Year
    | V  |	H	H	V	V	V	V	V	H	H	B	B	V	V	H	H	B	B	H	H	V	V	H	H	H	|Valentines Day
    | H  |	E	E	E	E	BA	BA	FF	FF		BA	BA	BA	BA	E	E		BA	BA	E	E	FF	FF	E	E	|Helloween
    +----+--------------------------------------------------------------------------------------------------+
    B:butterflies, BA:bats, D:dandelions: E:eyes, F:fairies, FF:fireflies, FW:fireworks, H:hearts, L:leaves
    P:petals, R:rain, S:snow, V:valentines. " ":crystal_blick

    ravens
     */

    final Scene.ShortTypes[][] TimeAnimation = {
/* 01 | 00 */ { E,  E, CB,  E,  E, CB, FF, FF, CB,  B,  B, CB, CB,  B,  B, CB,  B,  B, CB, CB, FF, FF, FF, CB},
/* 02 | 01 */ {FF, FF,  E,  E, CB,  E,  E, CB, FF, FF, CB, CB,  R,  R, CB,  B,  B,  R,  R, CB, FF, FF,  R,  R},
/* 03 | 02 */ {CB, FF, FF, CB, CB, FF, FF, FF, CB, CB,  R,  R,  R, CB, CB,  R,  R, CB, CB, FF, FF, CB, FF, FF},
/* 04 | 03 */ { E,  E,  E,  E, CB, CB, FF, FF, CB,  B,  B,  D,  D, CB,  D,  D,  D, CB, CB, CB, FF, FF, FF, CB},
/* 05 | 04 */ {CB, CB,  E,  E,  E, CB, FF, FF, CB, CB,  P,  P, CB,  P,  P,  P, CB, CB, CB, CB, FF, FF, FF, CB},
/* 06 | 05 */ {CB,  E,  E,  E,  E, CB, FF, FF, CB, CB,  B,  B,  P,  P, CB,  B,  B,  P,  P, FF, FF, CB, FF, FF},
/* 07 | 06 */ {CB, FF, FF, CB, CB, FF, FF, FF, CB, CB,  L,  L, CB, CB, CB,  L,  L,  L, CB, FF, FF, CB, FF, FF},
/* 08 | 07 */ {CB, CB, CB, CB, CB,  R,  R, CB, CB,  R,  R, CB,  R,  R,  L,  L, CB,  L,  L, CB,  R,  R, FF, FF},
/* 09 | 08 */ {CB, FF, FF,  S,  S, FF, FF, FF, CB, CB, CB,  S,  S, CB,  S,  S, CB, CB, CB, FF, FF, CB, FF, FF},
/* 10 | 09 */ { E,  E, CB,  E,  E,  S,  S, CB, CB,  S,  S, CB, CB, CB,  S,  S, CB, CB,  S,  S, CB, CB,  S,  S},
/* 11 | 10 */ { E,  E,  E,  E, CB, CB, FF, FF, CB,  D,  D,  D, CB,  D,  D,  D,  D,  D, CB, CB, FF, FF, FF, CB},
/* 12 | 11 */ //{ E,  E,  F,  F,  F, CB, FF, FF, CB,  B,  B, CB, CB,  B,  B, CB,  B,  B, CB, CB, FF, FF, FF, CB}, //Original
/* 12 | 11 */ { E,  E,  F,  F,  F, CB, FF, FF, CB,  B,  B,  D,  D, CB,  D,  D,  D, CB, CB, CB, FF, FF, FF, CB},   //Mod Fairlies Day
/*  C | 12 */ { S,  S,  S, CB,  S,  S, CB, CB,  S,  S, CB, CB,  S,  S,  S,  S, CB,  S,  S, CB,  S,  S,  S, CB},
/*  N | 13 */ {FW, FW, FW, FW, FW, CB, FF, FF, CB, CB, CB, CB,  S,  S, CB, CB,  S,  S, CB, CB, FF, FF, CB, CB},
/* Ch | 14 */ {CB, CB,  E,  E,  E, CB, FF, FF, CB, CB,  B,  B, FW, FW, CB,  B,  B, CB, FW, FW, FF, FF, FW, FW},
/*  V | 15 */ { H,  H,  V,  V,  V,  V,  V,  H,  H,  B,  B,  V,  V,  H,  H,  B,  B,  H,  H,  V,  V,  H,  H,  H},
/*  H | 16 */ { E,  E,  E,  E, BA, BA, FF, FF, CB, BA, BA, BA, BA,  E,  E, CB, BA, BA,  E,  E, FF, FF,  E,  E}
    };
/*
    tabl.2 - Day Animation
    +---+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
    |Day|	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27	28	29	30	31	0	0	0	0	0	0	0	0	0	|
    +---+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
    |1	|	N	1	5	6	1	5	5	1	1	6	6	1	5	5	5	1	1	1	6	1	1	1	1	2	2	1	1	1	1	1	1	0	0	0	0	0	0	0	0	0	|
    |2	|	1	1	1	5	5	6	1	1	6	6	6	6	2	V	1	1	1	4	4	11	2	2	4	4	2	2	3	3	2	2	4	0	0	0	0	0	0	0	0	0	|
    |3	|	4	7	7	8	8	7	7	8	1	3	3	4	4	11	4	11	2	3	3	1	4	4	11	11	4	1	4	4	4	11	11	0	0	0	0	0	0	0	0	0	|
    |4	|	11	3	10	10	9	10	9	9	10	10	10	9	9	9	10	9	9	8	9	11	4	4	11	4	4	4	4	1	1	1	5	0	0	0	0	0	0	0	0	0	|
    |5	|	1	1	5	6	1	5	5	1	1	6	6	1	5	5	5	1	1	1	6	1	1	1	1	2	2	1	1	1	1	1	1	0	0	0	0	0	0	0	0	0	|
    |6	|	1	1	1	5	5	6	1	1	6	6	6	6	2	2	1	1	1	4	4	11	2	2	4	4	2	2	3	3	2	2	4	0	0	0	0	0	0	0	0	0	|
    |7	|	4	7	7	8	8	7	7	8	1	3	3	4	4	11	4	11	2	3	3	1	4	4	11	11	4	1	4	4	4	11	11	0	0	0	0	0	0	0	0	0	|
    |8	|	11	3	10	10	9	10	9	9	10	10	10	9	9	9	10	9	9	8	9	11	4	4	11	4	4	4	4	1	1	1	5	0	0	0	0	0	0	0	0	0	|
    |9	|	1	1	5	6	1	5	5	1	1	6	6	1	5	5	5	1	1	1	6	1	1	1	1	2	2	1	1	1	1	1	1	0	0	0	0	0	0	0	0	0	|
    |10 |	1	1	1	5	5	6	1	1	6	6	6	6	2	2	1	1	1	4	4	11	2	2	4	4	2	2	3	3	2	2	H	0	0	0	0	0	0	0	0	0	|
    |11 |	4	7	7	8	8	7	7	8	1	3	3	4	4	11	4	11	2	3	3	1	4	4	11	11	4	1	4	4	4	11	11	0	0	0	0	0	0	0	0	0	|
    |12 |	11	3	10	10	9	10	9	9	10	10	10	9	9	9	10	9	9	8	9	11	4	4	11	4	4	4	4	1	1	1	10	0	0	0	0	0	0	0	0	0	|
    +---+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+
 */

    final int[][] DayAnimation = {
        {13, 0, 4, 5, 0, 4, 4, 0, 0, 5, 5, 0, 4,  4, 4,  0, 0, 0, 5,  0, 0, 0,  0,  1,  1, 0, 0, 0, 0,  0,  0},
        { 0, 0, 0, 4, 4, 5, 0, 0, 5, 5, 5, 5, 1, 15, 0,  0, 0, 3, 3, 10, 1, 1,  3,  3,  1, 1, 2, 2, 1,  1,  3},
        { 3, 6, 6, 7, 7, 6, 6, 7, 0, 2, 2, 3, 3, 10, 3, 10, 1, 2, 2,  0, 3, 3, 10, 10,  3, 0, 3, 3, 3, 10, 10},
        {10, 2, 9, 9, 8, 9, 8, 8, 9, 9, 9, 8, 8,  8, 9,  8, 8, 7, 8, 10, 3, 3, 10,  3,  3, 3, 3, 0, 0,  0,  4},
        { 0, 0, 4, 5, 0, 4, 4, 0, 0, 5, 5, 0, 4,  4, 4,  0, 0, 0, 5,  0, 0, 0,  0,  1,  1, 0, 0, 0, 0,  0,  0},
        { 0, 0, 0, 4, 4, 5, 0, 0, 5, 5, 5, 5, 1,  1, 0,  0, 0, 3, 3, 10, 1, 1,  3, 11,  1, 1, 2, 2, 1,  1,  3},
        { 3, 6, 6, 7, 7, 6, 6, 7, 0, 2, 2, 3, 3, 10, 3, 10, 1, 2, 2,  0, 3, 3, 10, 10,  3, 0, 3, 3, 3, 10, 10},
        {10, 2, 9, 9, 8, 9, 8, 8, 9, 9, 9, 8, 8,  8, 9,  8, 8, 7, 8, 10, 3, 3, 10,  3,  3, 3, 3, 0, 0,  0,  4},
        { 0, 0, 4, 5, 0, 4, 4, 0, 0, 5, 5, 0, 4,  4, 4,  0, 0, 0, 5,  0, 0, 0,  0,  1,  1, 0, 0, 0, 0,  0,  0},
        { 0, 0, 0, 4, 4, 5, 0, 0, 5, 5, 5, 5, 1,  1, 0,  0, 0, 3, 3, 10, 1, 1,  3,  3,  1, 1, 2, 2, 1,  1, 16},
        { 3, 6, 6, 7, 7, 6, 6, 7, 0, 2, 2, 3, 3, 10, 3, 10, 1, 2, 2,  0, 3, 3, 10, 10,  3, 0, 3, 3, 3, 10, 10},
        {10, 2, 9, 9, 8, 9, 8, 8, 9, 9, 9, 8, 8,  8, 9,  8, 8, 7, 8, 10, 3, 3, 10,  3,  3, 3, 3, 0, 0,  0,  9}
    };

    // @formatter:on

    private static final int UPDATE_CALENDAR_DELAY_MILLIS = 40000;

    private final Calendar calendar = Calendar.getInstance();

    private final Context context;

    private boolean downTap;

    private final ArrayList<Scene> scenes = new ArrayList<>();

    private float posX, posY;

    /**
     * Optimization not to recompute time in Calendar on every {@link #update}.
     * <br/><br/>
     * A timestamp at which the last calendar update happened.
     */
    private long lastCalendarUpdateTimeMillis = SystemClock.uptimeMillis();

    EverchangingRender(Context context) {
        this.context = context;
    }

    void onDestroy() {
        scenes.clear();
    }

    void onTouchEvent(MotionEvent motionEvent) {
        final int pointerCount = motionEvent.getPointerCount() - 1;
        posX = motionEvent.getX(pointerCount);
        posY = motionEvent.getY(pointerCount);

        if (motionEvent.getAction() == 0) {
            downTap = true;
        } else if (motionEvent.getAction() == 1) {
            downTap = false;
        }
    }

    @Override
    public void onSurfaceCreated(final GL10 gl, final EGLConfig config) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        GLES20.glEnable(GLES20.GL_BLEND);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);


        scenes.add(new BackgroundScene(context, calendar));
        scenes.add(new CrystalBlickScene(context));
        scenes.add(new FireFliesScene(context, calendar));
        scenes.add(new DandelionsScene(context, calendar));
        scenes.add(new RainsScene(context, calendar));
        scenes.add(new PetalsScene(context));
        scenes.add(new SnowsScene(context, calendar));
        scenes.add(new LeavesScene(context, calendar));
        scenes.add(new FireWorksScene(context, calendar));
        scenes.add(new EyesScene(context, calendar));
        scenes.add(new ButterFliesScene(context, calendar));
        scenes.add(new BatsScene(context));
        scenes.add(new HeartsScene(context, calendar));
        scenes.add(new ValentinesScene(context));
        scenes.add(new FairiesScene(context));
        scenes.add(new TouchBlickScene(context));

        GLES20.glReleaseShaderCompiler();
    }

    @Override
    public void onSurfaceChanged(final GL10 gl, final int width, final int height) {
        final WindowManager windowManager = (WindowManager)
                context.getSystemService(Context.WINDOW_SERVICE);
        assert windowManager != null;

        final int displayRotation = windowManager.getDefaultDisplay().getRotation();
        final float ratio = ((float) height / (float) width);
        final int surfaceWidth = 240;
        final int surfaceHeight = (int) (surfaceWidth * ratio);
        GLES20.glViewport(0, 0, width, height);

        final float scaleImageHeight = surfaceHeight / 320f;
        //todo setup position
        final int scenesSize = scenes.size();
        for (int i = 0; i < scenesSize; i++) {
            scenes.get(i)
                    .setupPosition(surfaceWidth, surfaceHeight, scaleImageHeight, displayRotation);
        }
    }

    private Scene.ShortTypes getAnim() {
        final int currentMonth = calendar.get(Calendar.MONTH);
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        final int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int currentDayAnim = DayAnimation[currentMonth][currentDay];
        return TimeAnimation[currentDayAnim][currentHour];
    }

    void update() {
        // todo update
        final Scene.ShortTypes currentScene = getAnim();
        final int scenesSize = scenes.size();
        for (int i = 0; i < scenesSize; i++) {
            final Scene scene = scenes.get(i);
            final boolean createObject = scene.sceneType == currentScene;
            switch (scene.sceneType) {
                case BG:
                    ((BackgroundScene) scene).update();
                    break;

                case CB:
                    ((CrystalBlickScene) scene).update(createObject);
                    break;

                case FF:
                    ((FireFliesScene) scene).update(createObject);
                    break;

                case D:
                    ((DandelionsScene) scene).update(createObject);
                    break;

                case R:
                    ((RainsScene) scene).update(createObject);
                    break;

                case P:
                    ((PetalsScene) scene).update(createObject);
                    break;

                case S:
                    ((SnowsScene) scene).update(createObject);
                    break;

                case L:
                    ((LeavesScene) scene).update(createObject);
                    break;

                case FW:
                    ((FireWorksScene) scene).update(createObject);
                    break;

                case E:
                    ((EyesScene) scene).update(createObject);
                    break;

                case B:
                    ((ButterFliesScene) scene).update(createObject);
                    break;

                case BA:
                    ((BatsScene) scene).update(createObject);
                    break;

                case H:
                    ((HeartsScene) scene).update(createObject);
                    break;

                case V:
                    ((ValentinesScene) scene).update(createObject);
                    break;

                case F:
                    ((FairiesScene) scene).update(createObject);
                    break;

                case TB:
                    ((TouchBlickScene) scene).update(downTap, posX, posY);
                    break;
            }
        }

        if (SystemClock.uptimeMillis() >=
                lastCalendarUpdateTimeMillis + UPDATE_CALENDAR_DELAY_MILLIS) {
            lastCalendarUpdateTimeMillis = SystemClock.uptimeMillis();
            calendar.setTimeInMillis(System.currentTimeMillis());
        }
    }

    void render() {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        //todo draw
        final int scenesSize = scenes.size();
        for (int i = 0; i < scenesSize; i++) {
            scenes.get(i).render();
        }
        GLES20.glFinish();
    }

    @Override
    public void onDrawFrame(final GL10 gl) {
        update();
        render();
    }
}
