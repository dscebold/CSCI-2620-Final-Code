package ProjectFiles;

public enum PixelKernel {

    /*
    Contains kernels for various effects
    Kernel Values come from:
    https://setosa.io/ev/image-kernels/

    https://en.wikipedia.org/wiki/Kernel_(image_processing)
     */

    GAUSSIAN_BLUR(
        new float[][]
            {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
            },
            true,
            false
    ),
    BOTTOM_SOBEL(
        new float[][]
            {
                {-1, -2, -1},
                {0, 0, 0},
                {1, 2, 1}
            },
            false,
            true
    ),
    EMBOSS(
        new float[][]
            {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}
            },
            false,
            false
    ),
    LEFT_SOBEL(
        new float[][]
            {
                {1, 0, -1},
                {2, 0, -2},
                {1, 0, -1}
            },
            false,
            true
    ),
    OUTLINE(
        new float[][]
            {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
            },
            false,
            false
    ),
    RIGHT_SOBEL(
        new float[][]
            {
                {-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}
            },
            false,
            true
    ),
    SHARPEN(
        new float[][]
            {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
            },
            false,
            false
    ),
    TOP_SOBEL(
        new float[][]
            {
                {1, 2, 1},
                {0, 0, 0},
                {-1, -2, -1}
            },
            false,
            true
    ),
    TOP_SOBEL_5X5(
        new float[][]
            {
                {2, 2, 4, 2, 2},
                {1, 1, 2, 1, 1},
                {0, 0, 0, 0, 0},
                {-1, -1, -2, -1, -1},
                {-2, -2, -4, -2, -2}
            },
            false,
            true
    ),
    GAUSSIAN_BLUR_5X5(
        new float[][]
            {
                { 1, 4, 6, 4, 1},
                { 4, 16, 24, 16, 4},
                { 6, 24, 36, 24, 6},
                { 4, 16, 24, 16, 4},
                { 1, 4, 6, 4, 1}
            },
            true,
            false
    ),
    UNSHARP_MASKING_5X5(
        new float[][]
            {
                { -.00390625f, -.015625f, -.0234375f, -.015625f, -.00390625f},
                { -.015625f, -.0625f, -.09375f, -.0625f, -.015625f},
                { -.0234375f, -.09375f, 1.859375f, -.09375f, -.0234375f},
                { -.015625f, -.0625f, -.09375f, -.0625f, -.015625f},
                { -.00390625f, 0-.015625f, -.0234375f, 0-.015625f, .00390625f}
            },
            false,
            false
    );

    PixelKernel(float[][] kernelMatrix, boolean average, boolean gradient) {
        this.kernelMatrix = kernelMatrix;
        this.length = kernelMatrix.length;
        this.average = average;
        this.gradient = gradient;
    }

    private final float[][] kernelMatrix;
    private final int length;
    private final boolean average;
    private final boolean gradient;

    public float[][] getKernelMatrix() {
        return this.kernelMatrix;
    }

    public int getLength() {
        return this.length;
    }

    public boolean getAverage() {
        return this.average;
    }

    public boolean getGradient() {
        return this.gradient;
    }

}
