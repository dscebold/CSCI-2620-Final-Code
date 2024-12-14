package PictureHelperClasses;

import java.awt.*;

public class CMYKUtil {

    public static double[] rgbToCMYK(int red, int green, int blue) {

        double decRed = red/255.0;
        double decGreen = green/255.0;
        double decBlue = blue/255.0;

        double v = Math.max(Math.max(decRed, decGreen), decBlue);

        if (v == 0) {
            return new double[]{0, 0, 0, 1};
        }


        double k = 1 - v;

        double c = 1 - decRed/v;
        double m = 1 - decGreen/v;
        double y = 1 - decBlue/v;

        return new double[]{c, m, y, k};
    }


    public static int[] cmykToRGB(double cyan, double magenta, double yellow, double k){
        double v = 1 - k;

        double red = v - v * cyan;
        double green = v - v * magenta;
        double blue = v - v * yellow;

        return new int[]{(int) Math.round(red * 255), (int) Math.round(green * 255), (int) Math.round(blue * 255)};
    }

    public static Color cmykToRGBColor(double cyan, double magenta, double yellow, double k) {
        int[] rgb = cmykToRGB(cyan, magenta, yellow, k);

        return new Color(
                Math.max(Math.min(rgb[0], 255), 0),
                Math.max(Math.min(rgb[1], 255), 0),
                Math.max(Math.min(rgb[2], 255), 0));
    }

    public static CMYKPixel cmykPixelFromRGB(int red, int green, int blue) {
        double[] cmykValues = rgbToCMYK(red, green, blue);
        return new CMYKPixel(
                cmykValues[0] * 255,
                cmykValues[1] * 255,
                cmykValues[2] * 255,
                cmykValues[3] * 255
        );
    }

    public static CMYKPixel cmykPixelFromColor(Color color) {
        return cmykPixelFromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static Color rgbColorFromCMYKPixel(CMYKPixel pixel) {
        return cmykToRGBColor(pixel.getCyan()/255, pixel.getMagenta()/255, pixel.getYellow()/255, pixel.getK()/255);
    }




}
