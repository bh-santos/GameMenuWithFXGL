package com.brendondias.game.util;

import javafx.scene.effect.*;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.*;

public class Effects {

    public static class ShadowEffects {
        public static final DropShadow LEAF_SHADOW = new DropShadow(BlurType.GAUSSIAN, GREEN, 10, 0, 0, 0);
        public static final DropShadow SAND_SHADOW = new DropShadow(BlurType.GAUSSIAN, Color.rgb(100, 76, 29), 10, 0, 0, 0);
        public static final DropShadow MIST_SHADOW = new DropShadow(BlurType.GAUSSIAN, BLUE, 10, 0, 0, 0);
        public static final DropShadow STONE_SHADOW = new DropShadow(BlurType.GAUSSIAN, BROWN, 10, 0, 0, 0);
        public static final DropShadow CLOUD_SHADOW = new DropShadow(BlurType.GAUSSIAN, YELLOW, 10, 0, 0, 0);

        public static final DropShadow WHITE_SHADOW = new DropShadow(BlurType.GAUSSIAN, WHITE, 10, 0, 0, 0);

        public static final DropShadow BLANCHE_SHADOW = new DropShadow(BlurType.GAUSSIAN, BLANCHEDALMOND, 5, 0, 0, 0);
        public static final DropShadow BLACK_SHADOW = new DropShadow(BlurType.GAUSSIAN, BLACK, 10, 0, 0, 0);

        public static final DropShadow BROWN_BLACK_SHADOW = new DropShadow(BlurType.GAUSSIAN, Color.rgb(43,38,35),10,0,0,0);

        public static final DropShadow ORANGE_SHADOW = new DropShadow(BlurType.GAUSSIAN, ORANGE, 10, 0, 0, 0);
        public static final DropShadow RED_SHADOW = new DropShadow(BlurType.GAUSSIAN, RED, 10, 0, 0, 0);

        public static final DropShadow GREEN_SHADOW = new DropShadow(BlurType.GAUSSIAN, GREEN, 10, 0, 0, 0);

        public static final DropShadow DARK_GRAY_SHADOW = new DropShadow(BlurType.GAUSSIAN,DARKSLATEGREY,5,0,0,0);

        public static final DropShadow YELLOW_SHADOW = new DropShadow(BlurType.GAUSSIAN,YELLOW,5,0,0,0);

        public static final InnerShadow WHITE_INNER_SHADOW = new InnerShadow(BlurType.GAUSSIAN,BLACK,5,0,0,0);
    }

    public static class LightEffects{
        public static final Lighting LIGHTING_EFFECT = new Lighting();
        public static final Light LIGHT_EFFECT = new Light.Distant();

    }

    public static class ColorEffects{
        public static final ColorAdjust BLACK_WHITE = new ColorAdjust(0,-0.4,0,0);
        public static final ColorAdjust LOW_SATURATION = new ColorAdjust(0,-0.8,0,0);
    }

}
