package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Foreground extends TextureObject {

    private final float[][][][] colorTransformValues = {
            /*1 season */
            {
                    {
                            {77, 256, 461, 256},
                            {0, -20, 0, 0}
                    },
                    {
                            {115, 256, 384, 256},
                            {0, -20, 0, 0}
                    },
                    {
                            {166, 256, 256, 256},
                            {0, -20, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {166, 256, 256, 256},
                            {0, -20, 0, 0}
                    },
                    {
                            {115, 256, 384, 256},
                            {0, -20, 0, 0}
                    },
                    {
                            {77, 256, 461, 256},
                            {0, -20, 0, 0}
                    }
            },

            /*2 season */
            {
                    {
                            {128, 282, 358, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 269, 307, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {218, 261, 282, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {218, 261, 282, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 269, 307, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {128, 282, 358, 256},
                            {0, 0, 0, 0}
                    }
            },
            /*3 season */
            {
                    {
                            {0, 384, 640, 256},
                            {0, -10, 0, 0}
                    },
                    {
                            {128, 320, 448, 256},
                            {0, -5, 0, 0}
                    },
                    {
                            {192, 269, 320, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 269, 320, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {128, 320, 448, 256},
                            {0, -5, 0, 0}
                    },
                    {
                            {0, 384, 640, 256},
                            {0, -10, 0, 0}
                    }
            },

            /*4 season */
            {
                    {
                            {205, 294, 1024, 256},
                            {-5, 0, -5, 0}
                    },
                    {
                            {192, 243, 448, 256},
                            {0, 0, -5, 0}
                    },
                    {
                            {230, 254, 358, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {230, 251, 358, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 243, 448, 256},
                            {0, 0, -5, 0}
                    },
                    {
                            {205, 294, 1024, 256},
                            {-5, 0, -5, 0}
                    }
            },

            //NY
            {
                    {
                            {64, 384, 768, 256},
                            {0, -5, 0, 0}
                    },
                    {
                            {128, 333, 614, 256},
                            {0, -4, 0, 0}
                    },
                    {
                            {192, 294, 435, 256},
                            {0, -2, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 294, 435, 256},
                            {0, -2, 0, 0}
                    },
                    {
                            {128, 333, 614, 256},
                            {0, -4, 0, 0}
                    },
                    {
                            {64, 384, 768, 256},
                            {0, -5, 0, 0}
                    }
            },

            //NR
            {
                    {
                            {64, 282, 717, 256},
                            {0, -10, 0, 0}
                    },
                    {
                            {115, 274, 563, 256},
                            {0, -7, 0, 0}
                    },
                    {
                            {192, 264, 410, 256},
                            {0, -3, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 264, 410, 256},
                            {0, -3, 0, 0}
                    },
                    {
                            {115, 274, 563, 256},
                            {0, -7, 0, 0}
                    },
                    {
                            {64, 282, 717, 256},
                            {0, -10, 0, 0}
                    }
            },

            //VD
            {
                    {
                            {51, 256, 512, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {128, 256, 435, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {205, 256, 333, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {205, 256, 333, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {128, 256, 435, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {51, 256, 435, 256},
                            {0, 0, 0, 0}
                    }
            },

            //HD
            {
                    {
                            {102, 282, 358, 256},
                            {0, -40, 0, 0}
                    },
                    {
                            {192, 269, 307, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {218, 261, 282, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {256, 256, 256, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {218, 261, 282, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {192, 269, 307, 256},
                            {0, 0, 0, 0}
                    },
                    {
                            {102, 282, 358, 256},
                            {0, -40, 0, 0}
                    }
            }
    };

    private static final int[][] textureList = {
            {R.drawable.image_287, R.drawable.image_285},                                             //Green
            {R.drawable.image_308, R.drawable.image_306, R.drawable.image_307, R.drawable.image_305}, //Violet
            {R.drawable.image_318, R.drawable.image_320, R.drawable.image_316, R.drawable.image_319}, //Orange
            {R.drawable.image_330, R.drawable.image_331, R.drawable.image_328},                       //Yellow
            {R.drawable.image_359, R.drawable.image_358, R.drawable.image_355, R.drawable.image_357}, //Red New year
            {R.drawable.image_298, R.drawable.image_297, R.drawable.image_295},                       //Red China New Year
            {R.drawable.image_341, R.drawable.image_339},                                             //Red valentines day
            {R.drawable.image_349, R.drawable.image_347}                                              //Violet halloween
    };

    private final int[][][] offsetValues = {
            {{0, 0, 0}, {0, 6, 0}},
            {{0, 10, 0}, {0, 0, 0}, {0, 7, 1}, {0, 135, 0}},
            {{0, 16, 0}, {0, 0, 0}, {0, 51, 1}, {-16, 6, 0}},
            {{0, 26, 0}, {0, 0, 0}, {0, 12, 0}},
            {{0, 15, 0}, {0, 0, 0}, {0, 51, 1}, {-25, 0, 0}},
            {{0, 26, 0}, {0, 0, 0}, {0, 10, 0}},
            {{0, 0, 0}, {0, 6, 0}},
            {{0, 0, 0}, {0, 38, 0}},
    };

    private static final float SCALE = 0.25f;

    private int current = -1;

    Foreground(final Context context) {
        super(context, textureList, null);
    }

    void update(final int foregroundIndex, final int timesOfDay) {
        if (current != foregroundIndex) {
            current = foregroundIndex;
            objects.markAllAsUnused();
            resetMatrix();
            createObjects();
        }

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            iterator.next().setColorTransform(colorTransformValues[current][timesOfDay]);
        }

        iterator.release();
    }

    private void createObjects() {
        final int textureListCurrentLength = textureList[current].length;
        for (int i = 0; i < textureListCurrentLength; i++) {
            int textureIndex = textureManager.getTextureIndex(textureList[current][i]);
            Object object = objects.obtain(textureManager.getTexture(textureIndex), SCALE);
            object.resetViewMatrix();
            object.setObjectScale(1.0f);
        }
        setObjectsPosition();
    }

    private void setObjectsPosition() {
        float deltaHeight = height;
        int index = 0;

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            float spriteWidth = object.texture.width * SCALE;
            float spriteHeight = object.texture.height * SCALE;
            float y = deltaHeight - spriteHeight + offsetValues[current][index][0];
            if (offsetValues[current][index][2] == 0) deltaHeight = deltaHeight - spriteHeight;
            object.resetMatrix();
            object.setTranslate(offsetValues[current][index][1] + spriteWidth * 0.5f, y + spriteHeight * 0.5f);
            index++;
        }

        iterator.release();
    }
}
