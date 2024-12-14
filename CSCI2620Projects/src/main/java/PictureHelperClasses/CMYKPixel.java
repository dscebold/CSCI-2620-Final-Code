package PictureHelperClasses;

import java.awt.*;

public class CMYKPixel {

    private double cyan, magenta, yellow, k;

    public CMYKPixel(double cyan, double magenta, double yellow, double k) {
        this.cyan = correctInput(cyan);
        this.magenta = correctInput(magenta);
        this.yellow = correctInput(yellow);
        this.k = correctInput(k);
    }

    public CMYKPixel(Color color) {
        double[] cmykValues = CMYKUtil.rgbToCMYK(color.getRed(), color.getGreen(), color.getBlue());

        this.cyan = correctInput(cmykValues[0] * 255);
        this.magenta = correctInput(cmykValues[1] * 255);
        this.yellow = correctInput(cmykValues[2] * 255);
        this.k = correctInput(cmykValues[3] * 255);
    }

    public CMYKPixel(int red, int green, int blue) {
        double[] cmykValues = CMYKUtil.rgbToCMYK(red, green, blue);

        this.cyan = correctInput(cmykValues[0] * 255);
        this.magenta = correctInput(cmykValues[1] * 255);
        this.yellow = correctInput(cmykValues[2] * 255);
        this.k = correctInput(cmykValues[3] * 255);
    }

    public double getCyan() {
        return cyan;
    }

    public void setCyan(double cyan) {
        this.cyan = cyan;
    }

    public CMYKPixel cyan(double cyan) {
        this.cyan = correctInput(cyan);
        return this;
    }

    public double getMagenta() {
        return magenta;
    }

    public void setMagenta(double magenta) {
        this.magenta = magenta;
    }

    public CMYKPixel magenta(double magenta) {
        this.magenta = correctInput(magenta);
        return this;
    }

    public double getYellow() {
        return yellow;
    }

    public void setYellow(double yellow) {
        this.yellow = yellow;
    }

    public CMYKPixel yellow(double yellow) {
        this.yellow = correctInput(yellow);
        return this;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public CMYKPixel k(double k) {
        this.k = correctInput(k);
        return this;
    }



    public void setCMYK(double[] cmykValues) {

        this.cyan = correctInput(cmykValues[0] * 255);
        this.magenta = correctInput(cmykValues[1] * 255);
        this.yellow = correctInput(cmykValues[2] * 255);
        this.k = correctInput(cmykValues[3] * 255);
    }

    private double correctInput(double input) {
        if (input < 0) {
            return 0;
        } else if (input > 255) {
            return 255;
        }
        return input;
    }

    public Color getRGBColor() {
        return CMYKUtil.cmykToRGBColor(this.cyan/255, this.magenta/255, this.yellow/255, this.k/255);
    }

}
