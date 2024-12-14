package ProjectFiles;

public enum SeparatedPixelKernel {

    TOP_SOBEL(
        new float[]
            {1,
            0,
            -1},
        new float[] {1, 2, 1},
            false,
            true
    ),
    RIGHT_SOBEL(
        new float[]
            {1,
            2,
            1},
        new float[] {-1, 0, 1},
            false,
            true
    ),
    LEFT_SOBEL(
        new float[]
            {1,
            2,
            1},
        new float[] {1, 0, -1},
            false,
            true
    ),
    BOTTOM_SOBEL(
        new float[]
            {-1,
            0,
            1},
        new float[] {1, 2, 1},
            false,
            true
    ),
    TOP_SOBEL_5X5(
        new float[]
            {2,
            1,
            0,
            -1,
            -2},
        new float[] {1, 1, 2, 1, 1},
            false,
            true
    ),
    BOTTOM_SOBEL_5X5(
        new float[]
            {2,
            1,
            0,
            -1
            -2},
        new float[] {1, 1, 2, 1, 1},
            false,
            true
    ),
    LEFT_SOBEL_5X5(
        new float[]
            {1,
            1,
            2,
            1,
            1},
        new float[] {2, 1, 0, -1, -2},
            false,
            true
    ),
    RIGHT_SOBEL_5X5(
        new float[]
            {1,
            1,
            2,
            1,
            1},
        new float[] {-2, -1, 0, 1, 2},
            false,
            true
    ),
    GAUSSIAN_BLUR_3X3(
        new float[]
            {1,
            2,
            1},
        new float[] {1, 2, 1},
            true,
            false
    ),
    GAUSSIAN_BLUR_5X5(
        new float[]
            {1,
            4,
            6,
            4,
            1},
        new float[] {1, 4, 6, 4, 1},
            true,
            false
    );

    SeparatedPixelKernel(float[] verticalArray, float[] horizontalArray, boolean average, boolean gradient) {
        this.verticalArray = verticalArray;
        this.horizontalArray = horizontalArray;
        this.average = average;
        this.gradient = gradient;
    }

    private final float[] verticalArray;
    private final float[] horizontalArray;
    private final boolean average;
    private final boolean gradient;

    public float[] getVerticalArray() {
        return this.verticalArray;
    }

    public float[] getHorizontalArray() {
        return this.horizontalArray;
    }

    public boolean getAverage() {
        return this.average;
    }

    public boolean getGradient() {
        return this.gradient;
    }
}
