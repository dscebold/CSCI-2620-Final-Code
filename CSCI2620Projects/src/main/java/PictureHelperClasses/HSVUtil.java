package PictureHelperClasses;

public class HSVUtil {

    public static double[] rgbToHSV(int red, int green, int blue) {

        double maxVal = Math.max(red, Math.max(green, blue));
        double minVal = Math.min(red, Math.min(green, blue));
        double diffVal = maxVal - minVal;

        // Black Exception
        if (maxVal == 0){
            return new double[]{0, 0, 0};
        }



        double value255 = maxVal;

        double sat = diffVal/maxVal;

        double hue360 = 0;

        if (diffVal == 0) {
            hue360 = 0.0f;
        }
        else {
            if (red == maxVal) {
                hue360 = 0 + ((60.0f * (green - blue)) / diffVal);
            }
            if (green == maxVal) {
                hue360 = 120.0f + ((60.0f * (blue - red)) / diffVal);
            }
            if (blue == maxVal) {
                hue360 = 240.0f + ((60.0f * (red - green)) / diffVal);
            }
        }

        if(hue360 < 0) {
            hue360 += 360;
        }

        return new double[]{hue360/360.0f, sat, value255/255};

    }


    public static int[] hsvToRGB(double hue, double saturation, double value) {
        double maxVal = value;
        double minVal = (value - saturation*value);
        double diffVal = maxVal - minVal;
        double midVal = 0; 

        double baseAngle = 0;
        if (1.0/6 < hue && hue <= 3.0/6) {
            baseAngle = 120;
        }
        if (3.0/6 < hue && hue <= 5.0/6) {
            baseAngle = 240;
        }

        boolean rotatePositive = (0.0 < hue && hue <= 1.0 / 6) || (2.0 / 6 < hue && hue <= 3.0 / 6) || (4.0 / 6 < hue && hue <= 5.0 / 6);

        if (rotatePositive) {
            midVal = (((hue * 360 - baseAngle) * diffVal)/60) + minVal;
            
        }
        else {
            midVal = (((baseAngle - hue * 360) * diffVal)/60) + minVal;
        }

        if (midVal < minVal) {
            //base angle is 0 and rotate positive is false, blue is midval and red is maxval
            midVal = (((baseAngle - 360*(hue - 1)) * diffVal)/60) + minVal;
        }

        if (baseAngle == 0) {
            if (rotatePositive) {
                return new int[]{(int)Math.round(maxVal * 255), (int)Math.round(midVal * 255), (int)Math.round(minVal * 255)};
            }
            else {
                return new int[]{(int)Math.round(maxVal * 255), (int)Math.round(minVal * 255), (int)Math.round(midVal * 255)};
            }
        }
        if (baseAngle == 120) {
            if (rotatePositive) {
                return new int[]{(int)Math.round(minVal * 255), (int)Math.round(maxVal * 255), (int)Math.round(midVal * 255)};
            }
            else {
                return new int[]{(int)Math.round(midVal * 255), (int)Math.round(maxVal * 255), (int)Math.round(minVal * 255)};
            }
        }
        if (baseAngle == 240) {
            if (rotatePositive) {
                return new int[]{(int) Math.round(midVal * 255), (int)Math.round(minVal * 255), (int)Math.round(maxVal * 255)};
            }
            else {
                return new int[]{(int)Math.round(minVal * 255), (int)Math.round(midVal * 255), (int)Math.round(maxVal * 255)};
            }
        }

        return new int[]{0, 0, 0};
    }

    public static void main(String[] args) {

//        double[] hsvVals = rgbToHSV(189, 172, 178);
//
//        System.out.println(hsvVals[0] * 360 + " " + hsvVals[1] * 100 + " " + hsvVals[2] * 100);
//
//        int[] rgbVals = hsvToRGB(hsvVals[0], hsvVals[1], hsvVals[2]);
//
//        System.out.println(rgbVals[0] + " " + rgbVals[1] + " " + rgbVals[2]);

//        int[] test = hsvToRGB(0, 0, 10.0);
//
//        double[] ss = rgbToHSV(test[0], test[1], test[2]);
//
//        System.out.println(ss[0] + " " + ss[1] + " " + ss[2]);

        repeatTest();

        double[] hsvVals = rgbToHSV(26, 26, 26);
        System.out.println(String.format("Hue: %3.3f Saturation: %3.3f Value: %3.3f", hsvVals[0],hsvVals[1], hsvVals[2]));
    }


    private static void repeatTest() {

        double[] hsvVals = new double[]{0/360.0, 0/100.0, 10/100.0};
        int[] rgbVals = new int[3];

        for(int i = 0; i < 100; i++) {
            rgbVals = hsvToRGB(hsvVals[0], hsvVals[1], hsvVals[2]);

            hsvVals = rgbToHSV(rgbVals[0], rgbVals[1], rgbVals[2]);
            System.out.println(String.format("Hue: %3.3f Saturation: %3.3f Value: %3.3f", hsvVals[0]*360,hsvVals[1]*100, hsvVals[2]*100));
            System.out.println(String.format("Red: %d Green: %d Blue: %d", rgbVals[0],rgbVals[1], rgbVals[2]));
        }

        System.out.println(String.format("Hue: %3.3f Saturation: %3.3f Value: %3.3f", hsvVals[0]*360,hsvVals[1]*100, hsvVals[2]*100));
        System.out.println(String.format("Red: %d Green: %d Blue: %d", rgbVals[0],rgbVals[1], rgbVals[2]));
    }


}
