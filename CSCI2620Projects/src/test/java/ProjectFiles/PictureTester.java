package ProjectFiles;

import java.awt.*;
import java.io.IOException;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("images/caterpillar.png");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("images/temple.png");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("images/640x480.png");
		canvas.explore();
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("images/swan.png");
		swan.explore();
		swan.edgeDetection(10).explore();
		swan.betterEdgeDetection(10).explore();
	}

	public static void testKeepOnlyBlue() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.keepOnlyBlue();
		beach.explore();
	}

	public static void testKeepOnlyRed() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.keepOnlyRed();
		beach.explore();
	}

	public static void testKeepOnlyGreen() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.keepOnlyGreen();
		beach.explore();
	}

	public static void testNegate() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.negate();
		beach.explore();
	}

	public static void testGrayscale() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.grayscale();
		beach.explore();
	}
	
	public static void testMirrorVerticalRightToLeft() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.mirrorVerticalRightToLeft();
		beach.explore();
	}
	
	public static void testMirrorHorizontal() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.mirrorHorizontal();
		beach.explore();
	}
	
	public static void testMirrorHorizontalBotToTop() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.mirrorHorizontalBotToTop();
		beach.explore();
	}
	
	public static void testMirrorDiagonal() {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.mirrorDiagonal();
		beach.explore();
	}
	
	public static void testMirrorArms() {
		Picture snowman = new Picture("images/snowman.png");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}
	
	public static void testMirrorGull() {
		Picture gull = new Picture("images/seagull.png");
		gull.explore();
		gull.mirrorGull();
		gull.explore();
	}
	
	public static void testMyCollage() {
		Picture canvas = new Picture("images/640x480.png");
		canvas.explore();
		canvas.myCollage();
		canvas.explore();
	}
	
	public static void testFishDetection() {
		Picture fish = new Picture("images/water.png");
		fish.explore();
		fish.edgeDetection(10);
		fish.explore();
	}
	
	public static void testFixUnderwater() {
		Picture fish = new Picture("images/water.png");
		fish.explore();
		fish.clearLow(); 
		fish.explore();
//		fish.edgeDetection(3);
//		fish.explore();
		Picture fish2 = new Picture("images/water.png"); 
		fish2.darker(fish);
		fish2.explore();
		
	}

	public static void testRotates() {
		Picture dDay = new Picture("images/dDay.png");
		dDay.explore();
		dDay.rotate90().explore();
		dDay.rotate180().explore();
		dDay.rotate270().explore();
	}

	public static void testGrayscaleEdgeDetection() {
		Picture swan = new Picture("images/quokka.png");
		Picture explorePic;
		swan.explore();
		explorePic = swan.edgeDetection(70);
		explorePic.explore();
		explorePic = swan.betterEdgeDetection(70);
		explorePic.explore();
	}

	public static void testRotate360() {
		Picture dDay = new Picture("images/dDay.png");
		Picture explorePic;
		dDay.explore();
		dDay.rotate360().explore();
	}

	public static void testSoften() {
//		Picture swan = new Picture("images/swan.png");
//		swan.explore();
//		swan.lowPassFiltering().explore();
//		swan.lowPassFiltering().betterEdgeDetection(25).explore();
//		swan.betterEdgeDetection(25).explore();

		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.lowPassFiltering().explore();
		quokka.lowPassFiltering().betterEdgeDetection(25).explore();
		quokka.betterEdgeDetection(25).explore();

//		Picture skyLine = new Picture("images/sfSkyline.png");
//		skyLine.explore();
//		skyLine.betterEdgeDetection(20).explore();
//		skyLine.lowPassFiltering().explore();
//		skyLine.lowPassFiltering().betterEdgeDetection(20).explore();
	}

	public static void testPixelize() {
		Picture rick = new Picture("images/rickRoll.png");
		rick.explore();
		rick.pixelize(15).explore();
	}

	public static void testSepia() {
		Picture rick = new Picture("images/swan.png");
		rick.explore();
		rick.sepia().explore();
	}

	public static void testLighten() {
		Picture rick = new Picture("images/snowman.png");
		rick.explore();
		Picture tempPicture = rick;
		for (int i = 0; i < 10; i++) {
			tempPicture = tempPicture.lighten();
			tempPicture.explore();
		}
	}

	public static void testDarken() {
		Picture rick = new Picture("images/snowman.png");
		rick.explore();
		Picture tempPicture = rick;
		for (int i = 0; i < 10; i++) {
			tempPicture = tempPicture.darken();
			tempPicture.explore();
		}
	}
	public static void testScale() {
		Picture dDay = new Picture("images/dDay.png");
		dDay.explore();
		dDay.scale(2.0).explore();
	}
	public static void testBetterScale() {
		Picture dDay = new Picture("images/dDay.png");
		dDay.explore();
		dDay.betterScale(2.0).explore();
		dDay.betterScale(2.0).lowPassFiltering().explore();
	}

	public static void testGaussianBlur() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.lowPassFiltering().explore();
		quokka.gaussianBlur().explore();
	}

	public static void testCreateMask() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.createMask().explore();
	}

	public static void testApplyMask() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
//		quokka.applyMask(quokka.createMask()).explore();
		Picture red = new Picture(quokka.getHeight(), quokka.getWidth());
		red.setColor(new Color(30, 24,70));
		quokka.applyMask(red).explore();
	}

	public static void testTopSobel() {
		Picture quokka = new Picture("images/swan.png");
		quokka.explore();
		quokka.topSobel().explore();
	}

	public static void testGaussian5X5() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.gaussianBlur().explore();
		quokka.gaussian5X5().explore();
	}

	public static void testUnsharpMask5X5() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.unsharpMasking().explore();
		quokka.unsharpMasking().topSobel().explore();
	}

	public static void testRotate(double angle) {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.rotateByFixedAngle(angle).explore();
	}

	public static void testDoubleSobel() {
		Picture quokka = new Picture("images/sobelTestImage.png");
		quokka.explore();
		quokka.topAndLeftSobel().explore();
		quokka.grayscale().topAndLeftSobel().explore();
		quokka.gaussianBlur().topAndLeftSobel().explore();
	}

	public static void testSplitKernel() {
		Picture swan = new Picture("images/swan.png");
		swan.explore();

		long beforeTime = System.nanoTime();
		swan.applySplitKernel(SeparatedPixelKernel.TOP_SOBEL).explore();
		long afterTime = System.nanoTime();

		long duration = afterTime - beforeTime;

		System.out.println("Split duration: " + duration/1000000 + "ms");

		beforeTime = System.nanoTime();
		swan.topSobel().explore();
		afterTime = System.nanoTime();

		duration = afterTime - beforeTime;

		System.out.println("3x3 duration: " + duration/1000000 + "ms");
	}

	public static void testSplitDoubleKernel() {
		Picture swan = new Picture("images/sobelTestImage.png");
		swan.explore();

		long beforeTime = System.nanoTime();
		swan.grayscale().applyMultipleSplitKernel(SeparatedPixelKernel.TOP_SOBEL, SeparatedPixelKernel.LEFT_SOBEL).explore();
		long afterTime = System.nanoTime();

//		long duration = afterTime - beforeTime;
//
//		System.out.println("Split duration: " + duration/1000000 + "ms");
//
//		beforeTime = System.nanoTime();
//		swan.topAndLeftSobel().explore();
//		afterTime = System.nanoTime();
//
//		duration = afterTime - beforeTime;
//
//		System.out.println("3x3 duration: " + duration/1000000 + "ms");
	}

	public static void testFloodFill() {
		Picture square = new Picture("images/separatedSquare.png");
		square.startFloodFill(Color.WHITE, Color.BLUE, 1, 1).explore();
	}

	public static void testFloodFillDiagonal() {
		Picture square = new Picture("images/separatedSquare.png");
		square.startFloodFillDiagonal(Color.WHITE, Color.BLUE, 236, 236).explore();
	}

	public static void testFloodFillTime() {
		Picture square = new Picture("images/separatedSquare.png");

		long beforeTime = System.nanoTime();
		square.startFloodFillDiagonal(Color.WHITE, Color.BLUE, 236, 236).explore();
		long afterTime = System.nanoTime();

		long duration = afterTime - beforeTime;

		System.out.println("Straight duration: " + duration/1000000 + "ms");

		beforeTime = System.nanoTime();
		square.startFloodFill(Color.WHITE, Color.BLUE, 236, 236).explore();
		afterTime = System.nanoTime();

		duration = afterTime - beforeTime;

		System.out.println("Diagonal duration: " + duration/1000000 + "ms");
	}

	public static void testSplitKernel5X5Time() {
		Picture swan = new Picture("images/swan.png");

		long beforeTime = System.nanoTime();
		swan.applySplitKernel(SeparatedPixelKernel.GAUSSIAN_BLUR_5X5).explore();
		long afterTime = System.nanoTime();

		long duration = afterTime - beforeTime;

		System.out.println("Split duration: " + duration/1000000 + "ms");

		beforeTime = System.nanoTime();
		swan.applyKernel(PixelKernel.GAUSSIAN_BLUR_5X5).explore();
		afterTime = System.nanoTime();

		duration = afterTime - beforeTime;

		System.out.println("5x5 duration: " + duration/1000000 + "ms");
	}

	public static void testApplyKernel() {
		Picture quokka = new Picture("images/sobelTestImage.png");
		quokka.applyKernel(PixelKernel.TOP_SOBEL_5X5).explore();

	}

	public static void sobelTests() {
		Picture test = new Picture("images/sobelTestImage.png");
		test.explore();

		test.applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		test.grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();

//		test.applyMultipleSplitKernel(SeparatedPixelKernel.TOP_SOBEL, SeparatedPixelKernel.LEFT_SOBEL).explore();
//		test.grayscale().applyMultipleSplitKernel(SeparatedPixelKernel.TOP_SOBEL, SeparatedPixelKernel.LEFT_SOBEL).explore();

	}

	public static void hsvSobelTests() {
		Picture test = new Picture("images/sobelTestImage.png");
		test.explore();

		test.applyDoubleKernelHSV(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		test.grayscale().applyDoubleKernelHSV(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
	}

	public static void hsvTests() {
		Picture test = new Picture("images/quokka.png");
		test.explore();

		test.invertHue().explore();
		test.invertSaturation().explore();
		test.invertValue().explore();

	}

	public static void hsvEdgeTests() {
		Picture test = new Picture("images/sobelTestImage.png");
		test.explore();

		test.hsvEdgeDetection(60).explore();
		test.gaussianBlur().hsvEdgeDetection(60).explore();
		test.grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();

	}

	public static void testNoise() {
		Picture test = new Picture("images/quokka.png");
		test.explore();

		test.basicNoise().explore();
	}

	public static void testSaturation() {
		Picture test = new Picture("images/sobelTestImage.png");
		test.explore();

		test.maxSaturation().explore();
		test.widenSaturation().explore();

		test.applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		test.widenSaturation().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();

		test.gaussianBlur().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		test.widenSaturation().gaussianBlur().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();

		test.grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		test.widenSaturation().grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
	}

	public static void testRotateExpand(double angle) {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.rotateAndExpand(angle).explore();
	}

	public static void testVignette() {
//		Picture shark = new Picture("images/shark.png");
//		shark.vignette().write("vignettedShark.png");

		Picture redParrot = new Picture("images/redParrot.png");
		Picture blueParrot = new Picture("images/blueParrot.png");
		Picture quokka = new Picture("images/quokka.png");

		redParrot.vignette().explore();
		redParrot.vignette2().explore();
		blueParrot.vignette().explore();
		blueParrot.vignette2().explore();

		quokka.vignette().explore();
		quokka.vignette2().explore();
	}

	public static void testParrotSobel() {

		Picture redParrot = new Picture("images/redParrot.png");
		Picture blueParrot = new Picture("images/blueParrot.png");

//		redParrot.applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
//		redParrot.widenSaturation().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
//		redParrot.grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
//		redParrot.widenSaturation().grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();

		blueParrot.applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		blueParrot.widenSaturation().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		blueParrot.grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
		blueParrot.widenSaturation().grayscale().applyDoubleKernel(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL).explore();
	}

	public static void testOldTimeyVignette() {

//		Picture redParrot = new Picture("images/redParrot.png");
//
//		redParrot.explore();
//		redParrot.vignette2().explore();
//		redParrot.oldTimeyVignette().explore();

//		Picture cheetah = new Picture("images/cheetah.png");
//
//		cheetah.explore();
//		cheetah.vignette2().explore();
//		cheetah.oldTimeyVignette().explore();

		Picture giraffe = new Picture("images/giraffes.png");

		giraffe.explore();
//		giraffe.vignette2().explore();
//		giraffe.oldTimeyVignette().explore();

		giraffe.applyKernel(PixelKernel.SHARPEN).explore();
	}

	public static void greenScreenTests() {

		Picture markPoint = new Picture("images/markPointing.png");

		Picture markPunch = new Picture("images/markPunch.png");

		Picture jkSimmons = new Picture("images/j.k.simmonsLaughing.png");

		markPoint.explore();

		Picture cheetah = new Picture("images/cheetah.png");

//		cheetah.greenScreenHSV(120.0f, markPoint).explore();
//
//		cheetah.exploreWithRotate();
//
//		cheetah.greenScreenHSV2(2, 2, markPoint).exploreWithRotate();
//
//		cheetah.greenScreenHSV2(2, 2, markPoint).exploreWithRotate();
//
//		cheetah.greenScreenHSV3(2, 2, markPoint, 100, 30).exploreWithRotate();
//
//		cheetah.greenScreenHSV4(2, 2, markPoint, 100, 30).exploreWithRotate();

		cheetah.greenScreenHSV3(2, 2, markPoint, 100, 30).explore();
//		markPunch.explore();
//
//		cheetah.explore();
//
//		markPoint.blackoutHSV(markPoint.getHSVPixels2DColumnMajor()[2][2]).explore();

		cheetah.greenScreenHSV4(2, 2, markPoint, 100 ,30).explore();


//		markPunch.scaleToMatch(cheetah).explore();

	}

	public static void testRecoloring() {
		Picture quokka = new Picture("images/quokka.png");
		quokka.explore();
		quokka.weightedGrayscale().explore();
		quokka.weightedGrayscale().basicGrayscaleToRGB().explore();
		quokka.weightedGrayscale().weightedGrayscaleToRGB().explore();
	}

	public static void testCMYKStuff() {

		Picture parrot = new Picture("images/redParrot.png");

		parrot.explore();
		parrot.invertCMYK().explore();
		parrot.emptyCyan().explore();
		parrot.emptyMagenta().explore();
		parrot.emptyYellow().explore();
		parrot.cmykDarken().explore();
	}

	public static void testGrayscales() {

		Picture parrot = new Picture("images/redParrot.png");

		parrot.explore();
		parrot.grayscale().explore();
		parrot.weightedGrayscale().explore();
		parrot.ultimateGrayscale().explore();

	}

	public static void testCubicIterpolation() {

//		Picture cheeta = new Picture("images/cheetah.png");
//
//		cheeta.hermiteInterpolationScale(2).explore();
//		cheeta.scale(2).explore();
//		cheeta.bicubicInterpolationScale(2).explore();

//		Picture tester = new Picture("images/tester.png");
//
//		tester.hermiteInterpolationScale(25).explore();
//		tester.scale(25).explore();
//		tester.bicubicInterpolationScale(25).explore();
//		tester.linearInterpolationScale(25).explore();


//		Picture testMan = new Picture("images/testGuy.png");
//
//		testMan.cubicInterpolationScale(20).explore();
//		testMan.scale(20).explore();

		Picture example = new Picture("images/tinyManExample.png");

		example.hermiteInterpolationScale(20).explore();
		example.scale(20).explore();
		example.bicubicInterpolationScale(20).explore();
		example.linearInterpolationScale(20).explore();

	}

	public static void testAllRotatesByFixedAngle() {
		Picture quokka = new Picture("images/blueParrot.png");

		quokka.explore();
		quokka.rotateByFixedAngle(.5).explore();
		quokka.rotateAndExpand(.5).explore();
		quokka.rotateAndFit(.5).explore();
//
		quokka.exploreWithRotate();
		quokka.exploreWithRotateThatFits();

	}

	public static void finalPresentationPhotos() {



		try {
			Picture example = new Picture("images/tinyManExample.png");

//			example.hermiteInterpolationScale(10).explore();
//			example.scale(10).explore();
//			example.bicubicInterpolationScale(10).explore();
//			example.linearInterpolationScale(10).explore();
//
//
//			example.hermiteInterpolationScale(10).writeOrFail("finalImages/hermiteTinyMan.png");
//			example.scale(10).writeOrFail("finalImages/nearestNeighborTinyMan.png");
//			example.bicubicInterpolationScale(10).writeOrFail("finalImages/bicubicTinyMan.png");
//			example.linearInterpolationScale(10).writeOrFail("finalImages/linearTinyMan.png");


			Picture cheeta = new Picture("images/cheetah.png");

			cheeta.scale(12).explore();
			cheeta.linearInterpolationScale(12).explore();
			cheeta.bicubicInterpolationScale(12).explore();
			cheeta.hermiteInterpolationScale(12).explore();
//
//			cheeta.hermiteInterpolationScale(10).writeOrFail("finalImages/hermiteCheetah.png");
//			cheeta.scale(10).writeOrFail("finalImages/nearestNeighborCheetah.png");
//			cheeta.bicubicInterpolationScale(10).writeOrFail("finalImages/bicubicCheetah.png");
//			cheeta.linearInterpolationScale(10).writeOrFail("finalImages/linearCheetah.png");

			Picture quokka = new Picture("images/quokka.png");
//
//			quokka.explore();
//			quokka.rotateByFixedAngle(.5).explore();
//			quokka.rotateAndExpand(.5).explore();
//			quokka.rotateAndFit(.5).explore();
//
//			quokka.rotateByFixedAngle(.5).writeOrFail("finalImages/fixedRotateQuokka.png");
//			quokka.rotateAndExpand(.5).writeOrFail("finalImages/fixedRotateExpandQuokka.png");
//			quokka.rotateAndFit(.5).writeOrFail("finalImages/fixedRotateCropQuokka.png");
//
			quokka.exploreWithRotate();
			quokka.exploreWithRotateThatFits();

			Picture parrot = new Picture("images/blueParrot.png");

//			parrot.explore();
//			parrot.rotateByFixedAngle(.5).explore();
//			parrot.rotateAndExpand(.5).explore();
//			parrot.rotateAndFit(.5).explore();
//
//			parrot.rotateByFixedAngle(.5).writeOrFail("finalImages/fixedRotateBlueParrot.png");
//			parrot.rotateAndExpand(.5).writeOrFail("finalImages/fixedRotateExpandBlueParrot.png");
//			parrot.rotateAndFit(.5).writeOrFail("finalImages/fixedRotateCropBlueParrot.png");

			parrot.exploreWithRotate();
			parrot.exploreWithRotateThatFits();

//			Picture markPoint = new Picture("images/markPointing.png");
//
//			Picture cheetah = new Picture("images/cheetah.png");
//
//			markPoint.explore();
//
//			cheetah.explore();
//
//			cheetah.greenScreenHSV3(2, 2, markPoint, 100, 30).explore();
//			cheetah.greenScreenHSV3(2, 2, markPoint, 100, 30).hermiteInterpolationScale(1.5).writeOrFail("finalImages/greenScreenHalo.png");
//
//			cheetah.greenScreenHSV4(2, 2, markPoint, 100 ,30).explore();
//			cheetah.greenScreenHSV4(2, 2, markPoint, 100 ,30).hermiteInterpolationScale(1.5).writeOrFail("finalImages/greenScreenBest.png");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}


	
	

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		//testZeroBlue();
//		testKeepOnlyBlue();
//		testKeepOnlyRed();
//		testKeepOnlyGreen();
//		testNegate();
//		testGrayscale();
//		testFixUnderwater();
//		testMirrorVertical();
//		testMirrorVerticalRightToLeft();
//		testMirrorHorizontal();
//		testMirrorHorizontalBotToTop();
//		testMirrorTemple();
//		testMirrorArms();
//		testMirrorGull();
//		testMirrorDiagonal();
//		testCollage();
//		testMyCollage();
//		testCopy();
//		testFishDetection();
//		testSetRedToHalfValueInTopHalf();
//		testClearBlueOverValue(200);
//		testGrayscaleEdgeDetection();
//		testRotate360();
//		testRotates();
//		testEdgeDetection();
//		testSoften();
//		testPixelize();
//		testSepia();
//		testLighten();
//		testDarken();
//		testScale();
//		testBetterScale();
//		testGaussianBlur();
//		testCreateMask();
//		testApplyMask();
//		testTopSobel();
//		testGaussian5X5();
//		testUnsharpMask5X5();
//		testRotate(.5);
//		testDoubleSobel();
//		testSplitKernel();
//		testSplitDoubleKernel();
//		Picture test = new Picture("images/separatedSquare.png");
//		test.explore();
//		testFloodFill();
//		testFloodFillDiagonal();
//		testFloodFillTime();
//		testSplitKernel5X5Time();
//		testApplyKernel();
//		sobelTests();
//		hsvSobelTests();
//		hsvTests();
//		hsvEdgeTests();
//		testNoise();
//		testSaturation();
//		testRotateExpand(.5);
//		testVignette();
//		testParrotSobel();
//		testOldTimeyVignette();
//		greenScreenTests();
//		testRecoloring();
//		testCMYKStuff();
//		testGrayscales();
//		testCubicIterpolation();
//		testAllRotatesByFixedAngle();
		finalPresentationPhotos();
	}
}