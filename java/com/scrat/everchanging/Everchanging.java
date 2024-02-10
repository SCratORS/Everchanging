package com.scrat.everchanging;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public final class Everchanging extends OpenGLES2WallpaperService {

    @Override
    GLSurfaceView.Renderer getNewRenderer(final Context context) {
        return new EverchangingRender(context);
    }
}

abstract class OpenGLES2WallpaperService extends EverchangingWallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new OpenGLES2Engine();
    }

    class OpenGLES2Engine extends Everchanging.GLEngine {

        @Override
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            assert activityManager != null;
            final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
            final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
            if (supportsEs2) {
                setEGLContextClientVersion();
                setPreserveEGLContextOnPause();
                setRenderer(getNewRenderer(getContext()));
            }
        }
    }

    abstract GLSurfaceView.Renderer getNewRenderer(Context context);
}

abstract class EverchangingWallpaperService extends WallpaperService {

    private GestureDetector gestureDetector;

    @Override
    public Engine onCreateEngine() {
        return new GLEngine();
    }

    public class GLEngine extends Engine {

        final class WallpaperGLSurfaceView extends GLSurfaceView {

            WallpaperGLSurfaceView(final Context context) {
                super(context);
            }

            @Override
            public SurfaceHolder getHolder() {
                return getSurfaceHolder();
            }

            void onDestroy() {
                super.onDetachedFromWindow();
            }
        }

        Context getContext() {
            return EverchangingWallpaperService.this;
        }

        private WallpaperGLSurfaceView glSurfaceView;
        private boolean rendererHasBeenSet;
        private EverchangingRender mRender;

        private final Handler handler = new Handler();
        private final Runnable mDrawRender = this::doDrawFrame;

        private static final int FPS = 20;  // кадров в секунду

        @Override
        public void onSurfaceCreated(final SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            glSurfaceView = new WallpaperGLSurfaceView(getContext());
        }

        @Override
        public void onVisibilityChanged(final boolean visible) {
            super.onVisibilityChanged(visible);
            if (rendererHasBeenSet) {
                if (visible) {
                    glSurfaceView.onResume();
                    gestureDetector = new GestureDetector(getContext(), new GestureListener());
                    doDrawFrame(); // запускаем рендеринг
                } else {
                    handler.removeCallbacks(mDrawRender);
                    glSurfaceView.onPause();
                    gestureDetector = null;
                }
            }
        }

        @Override
        public void onDestroy() {
            try {
                super.onDestroy(); //NullPointerException
                handler.removeCallbacks(mDrawRender);
                glSurfaceView.onDestroy();
                mRender.onDestroy();
            } catch (Exception ignore) {
            }
        }

        void setRenderer(final GLSurfaceView.Renderer renderer) {
            mRender = (EverchangingRender) renderer;
            glSurfaceView.setRenderer(renderer);
            glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
            rendererHasBeenSet = true;
        }

        void setPreserveEGLContextOnPause() {
            glSurfaceView.setPreserveEGLContextOnPause(true);
        }

        void setEGLContextClientVersion() {
            glSurfaceView.setEGLContextClientVersion(2);
        }

        @Override
        public void onTouchEvent(final MotionEvent event) {
            super.onTouchEvent(event);
            if (gestureDetector != null) gestureDetector.onTouchEvent(event);
            mRender.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        }

        void doDrawFrame() {
            handler.removeCallbacks(mDrawRender);
            handler.postDelayed(mDrawRender, 1000 / FPS);
            glSurfaceView.requestRender();
        }
    }
}
