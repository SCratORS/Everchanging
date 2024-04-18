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

import com.scrat.everchanging.scheduler.FrameScheduler;

public final class Everchanging extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new GLEngine();
    }

    private class GLEngine extends Engine {

        private final FrameScheduler frameScheduler = new FrameScheduler() {

            @Override
            public void scheduleNextFrame(final long delayMillis) {
                if (visible) {
                    handler.removeCallbacks(mDrawRender);
                    handler.postDelayed(mDrawRender, delayMillis);
                }
            }
        };

        private final EverchangingRender renderer = new EverchangingRender(
                getContext(),
                frameScheduler
        );

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
            return Everchanging.this;
        }

        private GestureDetector gestureDetector;
        private WallpaperGLSurfaceView glSurfaceView;
        private boolean rendererHasBeenSet;
        private EverchangingRender mRender;

        // Volatile because can be set from both render thread or main thread (Service onDestroy)
        private volatile boolean visible;

        private final Handler handler = new Handler();
        private final Runnable mDrawRender = new Runnable() {
            @Override
            public void run() {
                glSurfaceView.requestRender();
            }
        };

        @Override
        public void onSurfaceCreated(final SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            glSurfaceView = new WallpaperGLSurfaceView(getContext());

            final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            assert activityManager != null;
            final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
            final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
            if (supportsEs2) {
                setEGLContextClientVersion();
                setPreserveEGLContextOnPause();
                setRenderer(renderer);
            }
        }

        @Override
        public void onVisibilityChanged(final boolean visible) {
            super.onVisibilityChanged(visible);
            if (rendererHasBeenSet) {
                this.visible = visible;
                if (visible) {
                    mRender.forceUpdateCalendar();
                    glSurfaceView.onResume();
                    gestureDetector = new GestureDetector(getContext(), new GestureListener());
                    frameScheduler.scheduleNextFrame(0); // запускаем рендеринг
                } else {
                    glSurfaceView.onPause();
                    gestureDetector = null;
                    mRender.onTouchEvent(false);
                }
                mRender.setVisible(visible);
            }
        }

        @Override
        public void onSurfaceDestroyed(final SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            visible = false;
        }

        @Override
        public void onDestroy() {
            visible = false;
            try {
                super.onDestroy(); //NullPointerException
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
    }
}
