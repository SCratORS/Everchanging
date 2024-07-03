package com.scrat.everchanging;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public final class EverchangingLaunch extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final int ACTION_CHANGE_LIVE_WALLPAPER_REQUEST_CODE = 0xf00a;
        final int ACTION_LIVE_WALLPAPER_CHOOSER_REQUEST_CODE = 0xf009;
        try {
            final Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                    new ComponentName(this, Everchanging.class));
            startActivityForResult(intent, ACTION_CHANGE_LIVE_WALLPAPER_REQUEST_CODE);
        } catch (android.content.ActivityNotFoundException e3) {
            try {
                final Intent intent = new Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
                startActivityForResult(intent, ACTION_LIVE_WALLPAPER_CHOOSER_REQUEST_CODE);
            } catch (android.content.ActivityNotFoundException e2) {
                showDialog(R.string.activity_error);
            }
        }
        super.onCreate(savedInstanceState);
        finish();
    }
}
