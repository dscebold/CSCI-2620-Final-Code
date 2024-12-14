package PictureHelperClasses;

import java.awt.*;

public class HSVPixel {

    private double hue, saturation, value;

    public HSVPixel(double hue, double saturation, double value) {
        this.hue = correctDegree(hue);
        this.saturation = correctPerecent(saturation);
        this.value = correctPerecent(value);
    }

    public HSVPixel(Color color) {
        double[] hsbValues = HSVUtil.rgbToHSV(color.getRed(), color.getGreen(), color.getBlue());

        this.hue = correctDegree(hsbValues[0] * 360);
        this.saturation = correctPerecent(hsbValues[1] * 100);
        this.value = correctPerecent(hsbValues[2] * 100);
    }

    public HSVPixel(int red, int green, int blue) {
        double[] hsbValues = HSVUtil.rgbToHSV(red, green, blue);

        this.hue = correctDegree(hsbValues[0] * 360);
        this.saturation = correctPerecent(hsbValues[1] * 100);
        this.value = correctPerecent(hsbValues[2] * 100);
    }

    public double getHue() {
        return hue;
    }

    public void setHue(double hue) {
        this.hue = correctDegree(hue);
    }

    public HSVPixel hue(double hue) {
        this.hue = correctDegree(hue);
        return this;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = correctPerecent(saturation);
    }

    public HSVPixel saturation(double saturation) {
        this.saturation = correctPerecent(saturation);
        return this;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = correctPerecent(value);
    }

    public HSVPixel value(double value) {
        this.value = correctPerecent(value);
        return this;
    }

    public void setHSV(double[] hsvVals) {
        this.hue = hsvVals[0];
        this.saturation = hsvVals[1];
        this.value = hsvVals[2];
    }

    private double correctDegree(double value) {
        if (value < 0) {
            return 360 + value;
        } else if (value > 360) {
            return value % 360;
        }
        return value;
    }

    private double correctPerecent(double value) {
        if (value < 0) {
            return 0;
        } else if (value > 100) {
            return 100;
        }
        return value;
    }

    public Color getRGBColor() {
        int[] rgbVals = HSVUtil.hsvToRGB(this.hue/360.0f, this.saturation/100.0f, this.value/100.0f);
        int red = Math.min(Math.max(rgbVals[0], 0), 255);
        int green = Math.min(Math.max(rgbVals[1], 0), 255);
        int blue = Math.min(Math.max(rgbVals[2], 0), 255);
        return new Color(red, green, blue);
    }

    public boolean equals(HSVPixel comparePixel) {
        return (Math.abs(this.hue - comparePixel.getHue()) < .001 &&
                Math.abs(this.saturation - comparePixel.getSaturation()) < .001 &&
                Math.abs(this.value - comparePixel.getValue()) < .001);
    }

    public boolean equalsWide(HSVPixel comparePixel) {
        return (Math.abs(this.hue - comparePixel.getHue()) < .2 &&
                Math.abs(this.saturation - comparePixel.getSaturation()) < .2 &&
                Math.abs(this.value - comparePixel.getValue()) < .2);
    }

    @Override
    public String toString() {
        return String.format("Hue: %3.4f Saturation: %3.4f Value: %3.4f\n", this.hue, this.saturation, this.value);
    }
}
