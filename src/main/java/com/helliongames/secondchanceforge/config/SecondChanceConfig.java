package com.helliongames.secondchanceforge.config;

public class SecondChanceConfig {
    //COMMON

    public enum FeatureConfig {
        COYOTE_TIME_ENABLED("coyoteTimeEnabled", false),
        SECOND_CHANCE_ENABLED("secondChanceEnabled", false);

        private final String translationName;
        private final boolean isSlider;
        private boolean booleanValue;
        private double doubleValue;

        FeatureConfig(String translationName, boolean isSlider) {
            this.translationName = translationName;
            this.isSlider = isSlider;
            this.booleanValue = false;
            this.doubleValue = 0.0D;
        }

        public String getTranslationName() {
            return translationName;
        }

        public boolean getBoolean() {
            return booleanValue;
        }

        public void setBoolean(boolean value) {
            this.booleanValue = value;
        }

        public double getDouble() {
            return doubleValue;
        }

        public void setDouble(double value) {
            this.doubleValue = value;
        }

        public boolean isSlider() {
            return isSlider;
        }
    }
}
