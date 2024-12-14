package ProjectFiles;

import PictureHelperClasses.CMYKPixel;
import PictureHelperClasses.HSVPixel;
import PictureHelperClasses.Pixel;
import PictureHelperClasses.SimplePicture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	private Random rand = new Random();

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();

		rand = new Random();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 *
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 *
	 * @param height the height of the desired picture
	 * @param width  the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 *
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 *
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 *
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/**
	 * Sets all pictures to single color
	 * @param color Color to be set
	 * @return monocolored picture
	 */
	public Picture setColor(Color color) {
		Pixel[][] coloredPixels = this.getPixels2DColumnMajor();

		for(int row = 0; row < coloredPixels[0].length; row++) {
			for(int col = 0; col < coloredPixels.length; col++) {
				coloredPixels[col][row].setColor(color);
			}
		}

		return this;
	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int length = pixels.length;
		for (int row = 0; row < length / 2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int length = pixels.length;
		for (int row = 0; row < length / 2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[length - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		for (int row = 0; row < pixels.length && row < pixels[0].length; row++) {
			for (int col = 0; col < pixels[0].length && col < pixels.length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[col][row];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			count++;
			for (int col = 13; col < mirrorPoint; col++) {
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.println(count);
	}

	public void mirrorArms() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		for (int row = 159; row < 191; row++) {
			for (int col = 105; col < 170; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[191 - row + 191][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
		for (int row = 172; row < 196; row++) {
			for (int col = 239; col < 294; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[196 - row + 196][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int mirrorPoint = 357;
		for (int row = 234; row < 325; row++) {
			for (int col = 238; col < 344; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 *
	 * @param fromPic  the picture to copy from
	 * @param startRow the start row to copy to
	 * @param startCol the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void partialCopy(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < endRow && toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < endCol
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("images/flower1.png");
		Picture flower2 = new Picture("images/flower2.png");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.png");
	}

	public void myCollage() {
		Picture robot1 = new Picture("images/robot.png");
		Picture robot2 = new Picture("images/robot.png");
		this.copy(robot1, 0, 0);
		this.copy(robot2, 100, 0);
		this.copy(robot1, 200, 0);
		Picture flowerNoBlue = new Picture(robot2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(robot1, 400, 0);
		this.copy(robot2, 500, 0);
		this.mirrorVertical();
		this.write("collage.png");
	}

	/**
	 * Method to show large changes in color
	 *
	 * @param edgeDist the distance for finding edges
	 */
	public Picture edgeDetection(int edgeDist) {
		Pixel pixel1 = null;
		Pixel pixel2 = null;
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		Picture edges = new Picture(pixels[0].length, pixels.length);
		Pixel[][] edgePixels = edges.getPixels2DColumnMajor();
		Color color2 = null;
		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length - 1; col++) {
				pixel1 = pixels[col][row];
				pixel2 = pixels[col][row + 1];
				color2 = pixel2.getColor();
				if (pixel1.colorDistance(color2) > edgeDist)
					edgePixels[col][row].setColor(Color.BLACK);
				else
					edgePixels[col][row].setColor(Color.WHITE);
			}
		}
		return edges;
	}

	public Picture betterEdgeDetection(int edgeDist) {
		Pixel pixel1 = null;
		Pixel pixel2 = null;
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		Picture edges = new Picture(pixels[0].length, pixels.length);
		Pixel[][] edgePixels = edges.getPixels2DColumnMajor();
		Color color2 = null;
		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length - 1; col++) {
				pixel1 = pixels[col][row];
				pixel2 = pixels[col + 1][row];
				color2 = pixel2.getColor();
				if (pixel1.colorDistance(color2) > edgeDist)
					edgePixels[col][row].setColor(Color.BLACK);
				else
					edgePixels[col][row].setColor(Color.WHITE);
			}
		}
		for(int col = 0; col < pixels.length; col++) {
			for (int row = 0; row< pixels[0].length - 1; row++) {
				pixel1 = pixels[col][row];
				pixel2 = pixels[col][row  + 1];
				color2 = pixel2.getColor();
				if (pixel1.colorDistance(color2) > edgeDist) {
					edgePixels[col][row].setColor(Color.BLACK);
				}
			}
		}
		return edges;
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		for (Pixel[] colArray : pixels) {
			for (Pixel pixelObj : colArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());
			}
		}
	}

	public Picture grayscale() {
		int ave = 0;
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		for (Pixel[] colArray : pixels) {
			for (Pixel pixelObj : colArray) {
				ave = 0;
				ave += pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen();
				ave = (ave / 3);
				pixelObj.setRed(ave);
				pixelObj.setBlue(ave);
				pixelObj.setGreen(ave);
			}
		}
		return this;
	}

	public Picture weightedGrayscale() {
		float ave;
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		for (Pixel[] colArray : pixels) {
			for (Pixel pixelObj : colArray) {
				ave = 0;
				ave += (pixelObj.getRed() * .2126) + (pixelObj.getBlue() * .0722) + (pixelObj.getGreen() * .7152);
				pixelObj.setRed(Math.round(ave));
				pixelObj.setBlue(Math.round(ave));
				pixelObj.setGreen(Math.round(ave));
			}
		}
		return this;
	}

	public Picture ultimateGrayscale() {
		float ave;
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		for (Pixel[] colArray : pixels) {
			for (Pixel pixelObj : colArray) {
				int red = pixelObj.getRed();
				int green = pixelObj.getGreen();
				int blue = pixelObj.getBlue();

				double Y = (0.299 * red) + (0.587 * green) + (0.114 * blue);
				double U = (blue - Y) * 0.565;
				double V = (red - Y) * 0.713;
				double UV = U + V;
				double R1 = red * 0.299;
				double R2 = red * 0.587;
				double R3 = red * 0.114;
				double G1 = green * 0.299;
				double G2 = green * 0.587;
				double G3 = green * 0.114;
				double B1 = blue * 0.299;
				double B2 = blue * 0.587;
				double B3 = blue * 0.114;
				double R4 = (R1 + R2 + R3)/3;
				double G4 = (G1 + G2 + G3)/3;
				double B4 = (B1 + B2 + B3)/3;
				double I1 = (R4 + G4 + B4 + UV);

				pixelObj.setRed((int) Math.round(I1));
				pixelObj.setBlue((int) Math.round(I1));
				pixelObj.setGreen((int) Math.round(I1));
			}
		}
		return this;
	}

	public void clearLow() {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				if (pixels[row][col].getRed() > 25 || pixels[row][col].getGreen() < 150) {
					pixels[row][col].setColor(Color.WHITE);
				}
			}
		}
	}

	public void darker(Picture pic) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] pixels2 = pic.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				if (!(pixels2[row][col].getColor().equals(Color.WHITE))) {
					pixels[row][col].setColor(pixels[row][col].getColor().darker());
				}
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("images/beach.png");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public void getGreen(Picture add) {
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] put = add.getPixels2D();
		for (int row = 0; row < put.length; row++) {
			for (int col = 0; col < put[0].length - 1; col++) {
				if (put[row][col].colorDistance(new Color(105, 210, 155)) > 90) {
					pixels[row + 187][col + 338].setColor(put[row][col].getColor());
				}
			}
		}
	}

	public void getGreen1(Picture add) {
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] put = add.getPixels2D();
		for (int row = 0; row < put.length; row++) {
			for (int col = 0; col < put[0].length - 1; col++) {
				if (put[row][col].colorDistance(Color.ORANGE) > 20) {
					pixels[row + 265][col + 93].setColor(put[row][col].getColor());
				}
			}
		}
	}

	public void setPink() {
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (pixels[row][col].colorDistance(new Color(102, 208, 110)) < 30) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (pixels[row][col].colorDistance(new Color(76, 177, 101)) < 30) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
		for (int row = 373; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				if (pixels[row][col].colorDistance(new Color(47, 120, 100)) < 45) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
		for (int row = 0; row < 277; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (pixels[row][col].colorDistance(new Color(149, 226, 148)) < 70) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
		for (int row = 359; row < pixels.length; row++) {
			for (int col = 0; col < 224; col++) {
				if (pixels[row][col].colorDistance(new Color(64, 153, 71)) < 55
						&& pixels[row][col].colorDistance(new Color(25, 29, 32)) > 40) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
		for (int row = 506; row < 578; row++) {
			for (int col = 187; col < 338; col++) {
				if (pixels[row][col].colorDistance(new Color(39, 98, 50)) < 40) {
					pixels[row][col].setColor(Color.ORANGE);
				}
			}
		}
//		for (int row = 0; row < pixels.length; row++) {
//			for (int col = 0; col < pixels[0].length; col++) {
//				if (pixels[row][col].colorDistance(new Color(83, 191, 71)) < 45) {
//					pixels[row][col].setColor(Color.ORANGE);
//				}
//			}
//		}
//		for (int row = 0; row < pixels.length; row++) {
//			for (int col = 0; col < pixels[0].length; col++) {
//				if (pixels[row][col].colorDistance(new Color(82, 144, 121)) < 25) {
//					pixels[row][col].setColor(Color.ORANGE);
//				}
//			}
//		}
//		for (int row = 0; row < 30; row++) {
//			for (int col = 165; col < pixels[0].length; col++) {
//				if (pixels[row][col].colorDistance(new Color(186, 239, 183)) < 70) {
//					pixels[row][col].setColor(Color.ORANGE);
//				}
//			}
//		}
//		for (int row = 146; row < 196; row++) {
//			for (int col = 46; col < 136; col++) {
//				if (pixels[row][col].colorDistance(new Color(33, 98, 42)) < 25) {
//					pixels[row][col].setColor(Color.ORANGE);
//				}
//			}
//		}

	}

	public void lightUp() {
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				if (pixels[row][col].colorDistance(new Color(30, 68, 47)) < 35) {
					pixels[row][col].setColor(pixels[row][col].getColor().brighter().brighter());
				}
			}
		}

	}

	public void lightsaber() {
		int dist = 8;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (pixels[row][col].colorDistance(new Color(232, 8, 42)) < 80) {
//				if(pixels[row][col].getColor().equals(Color.RED)) {
					Color from = (pixels[row][col].getColor());
					for (int i = col; (i >= col - dist); i--) {
						Color to = pixels[row][i].getColor();
						Color ave = new Color(((from.getRed()) + (to.getRed() * 10)) / 11,
								((from.getGreen()) + (to.getGreen() * 10)) / 11,
								((from.getBlue()) + (to.getBlue() * 10)) / 11);
//						if(rand.nextInt(Math.abs((col - i)) +1) == 0) {
						pixels[row][i].setColor(ave);
//						} 
						// Color ave = new Color(((from.getRed() * Math.abs(col - dist - i)
						// )+(to.getRed() * (col - i)))/dist, ((from.getGreen() * Math.abs(col - dist -
						// i))+(to.getGreen() * (col - i)))/dist, ((from.getBlue() * Math.abs(col - dist
						// - i))+(to.getBlue() * (col - i)))/dist);
//						Color ave = new Color((int) (from.getRed() * .15), (int) (from.getGreen() * .15),
//								(int) (from.getBlue() * .15));
//						pixels[row][i].setColor(ave);
					}
				}
			}
		}
		for (int row = 0; row < pixels.length; row++) {
			for (int col = pixels[0].length - 1; col >= 0; col--) {
				if (pixels[row][col].colorDistance(new Color(232, 8, 42)) < 100) {
//					if(pixels[row][col].getColor().equals(Color.RED)) {
					Color from = (pixels[row][col].getColor());
					for (int i = col; (i <= col + dist); i++) {
						Color to = pixels[row][i].getColor();
						Color ave = new Color(((from.getRed()) + (to.getRed() * 10)) / 11,
								((from.getGreen()) + (to.getGreen() * 10)) / 11,
								((from.getBlue()) + (to.getBlue() * 10)) / 11);
//						if(rand.nextInt(Math.abs((i-col)) + 1) == 0) {
//							pixels[row][i].setColor(ave);
//						} 
						// Color ave = new Color(((from.getRed() * (col + dist - i))+(to.getRed() *
						// (i-col)))/dist, ((from.getGreen() * (col + dist - i))+(to.getGreen()*
						// (i-col)))/dist, ((from.getBlue() * (col + dist - i))+(to.getBlue()*
						// (i-col)))/dist);
//						Color ave = new Color((int) (from.getRed() * .15), (int) (from.getGreen() * .15),
//								(int) (from.getBlue() * .15));
						pixels[row][i].setColor(ave);
					}
				}
			}
		}

	}

	public void reColor() {
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < 242; row++) {
			for (int col = 83; col < 120; col++) {
				if (pixels[row][col].colorDistance(new Color(248, 0, 46)) < 110
						|| pixels[row][col].colorDistance(new Color(140, 106, 68)) < 110) {
					pixels[row][col].setColor(Color.RED);
				}
			}
		}

	}

	public void getStar(Picture death) {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		Pixel[][] to = death.getPixels2DColumnMajor();
		for (int row = 0; row < to[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {
				if (pixels[col][row].colorDistance(new Color(126, 182, 231)) < 45) {
					pixels[col][row].setColor(to[col][row].getColor());
				}
			}
		}
		for (int row = 0; row < 40; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (pixels[col][row].colorDistance(new Color(86, 154, 215)) < 30) {
					pixels[col][row].setColor(to[col][row].getColor());
				}
			}
		}
	}

	public void hideEasyStego(int[] words) {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		for (int row = 0, hold = 0; row < pixels[0].length && hold < words.length; row++) {
			for (int col = 0; col < pixels.length && hold < words.length; col++) {
				if (pixels[row][col].getBlue() < 100 && pixels[row][col].getGreen() < 100) {
					pixels[row][col].setRed(words[hold]);
					hold++;
					if(hold == words.length) {
						return;
					}
				}
			}
		}
		//this.write("easyRick.png");
	}

	public ArrayList<String> getEasyNums() {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		String temp = "";
		String check = "";
		ArrayList<String> hold = new ArrayList<>();
		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {
				if (pixels[row][col].getBlue() < 100 && pixels[col][row].getGreen() < 100) {
					temp = "" + ((char)pixels[col][row].getRed());
					hold.add(temp);
					if(hold.size() > 3) {
						check = "" + hold.get(hold.size() -1) + hold.get(hold.size() -2) + hold.get(hold.size() -3);
						if(check.equals("~~~")) {
							return hold;
						}
					}
				}
			}
		}
		return hold;

	}

	public void hideHardStego(ArrayList<Character> bins) {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		String temp = "";
		for (int row = 0, hold = 0; row < pixels[0].length && hold < bins.size(); row++) {
			for (int col = 0; col < pixels.length && hold < bins.size(); col++) {
				temp = Integer.toBinaryString(pixels[col][row].getBlue());
				if(!(bins.get(hold).equals(temp.charAt(temp.length() -1)))) {
					temp = temp.substring(0, temp.length() -1) + bins.get(hold);
					temp = String.format("%8s", temp).replace(' ', '0');
					pixels[col][row].setBlue(Integer.parseInt(temp, 2));
				}
				hold++;
			}
		}
		//this.write("hardRick.png");
	}

	public ArrayList<String> getHardNums() {
		Pixel[][] pixels = this.getPixels2DColumnMajor();
		String temp = "";
		String check = "";
		String floop = "";
		ArrayList<String> hold = new ArrayList<>();
		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {
				floop = Integer.toBinaryString(pixels[col][row].getBlue());
				temp += "" + floop.charAt(floop.length() -1);
				if(temp.length() == 8) {
					temp = "" + (char)(Integer.parseInt(temp, 2));
					hold.add(temp);
					temp = "";
				}
				if(hold.size() > 3) {
					check = "" + hold.get(hold.size() -1) + hold.get(hold.size() -2) + hold.get(hold.size() -3);
					if(check.equals("~~~")) {
						return hold;
					}
				}
			}
		}
		return hold;
	}

	public Picture rotate90() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture rotatedPicture = new Picture(currentPixels.length, currentPixels[0].length);
		Pixel[][] newPixels = rotatedPicture.getPixels2DColumnMajor();

		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[currentPixels[0].length - row - 1][col].setColor(currentPixels[col][row].getColor());
			}
		}
		rotatedPicture.write(getFileName().substring(0, this.getFileName().indexOf('.')) + "rotated90.png");
		return rotatedPicture;
	}

	public Picture rotate180() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture rotatedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = rotatedPicture.getPixels2DColumnMajor();

		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[currentPixels.length - col - 1][currentPixels[0].length - row - 1].setColor(currentPixels[col][row].getColor());
			}
		}
		rotatedPicture.write(getFileName().substring(0, this.getFileName().indexOf('.')) + "rotated180.png");
		return rotatedPicture;
	}

	public Picture rotate270() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture rotatedPicture = new Picture(currentPixels.length, currentPixels[0].length);
		Pixel[][] newPixels = rotatedPicture.getPixels2DColumnMajor();

		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[row][currentPixels.length - col - 1].setColor(currentPixels[col][row].getColor());
			}
		}
		rotatedPicture.write(getFileName().substring(0, this.getFileName().indexOf('.')) + "rotated270.png");
		return rotatedPicture;
	}

	public Picture rotate360() {
		Picture rotatedPicture = this;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		rotatedPicture.write(getFileName().substring(0, this.getFileName().indexOf('.')) + "rotated360.png");
		return rotatedPicture;
	}

	public Picture lowPassFiltering() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture rotatedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = rotatedPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(averagePixel(currentPixels, row, col, maxHeight - 1, maxWidth - 1));
			}
		}

        return rotatedPicture;
	}


	private Color averagePixel(Pixel[][] pixelArray, int row, int col, int maxRow, int maxCol) {
		int redAvg = 0;
		int greenAvg = 0;
		int blueAvg = 0;
        int count = 0;

        /*
        This better way of doing it came from this stack overflow question
        https://stackoverflow.com/questions/4622572/best-way-to-check-the-indices-around-a-certain-index-in-a-2d-array?rq=4
         */

        for(int y = Math.max(row - 1, 0); y < Math.min(row + 1, maxRow); y++) {
            for (int x = Math.max(col - 1, 0); x < Math.min(col + 1, maxCol); x++) {
                redAvg += pixelArray[x][y].getRed();
                greenAvg += pixelArray[x][y].getGreen();
                blueAvg += pixelArray[x][y].getBlue();
                count++;
            }
        }
		return new Color(redAvg / count, greenAvg / count, blueAvg / count);
	}

	public int[][] createHistograms() {
		int[] redVals = new int[256];
		int[] greenVals = new int[256];
		int[] blueVals = new int[256];
		Pixel[][] pixels = this.getPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {
				redVals[pixels[col][row].getRed()] += 1;
				greenVals[pixels[col][row].getGreen()] += 1;
				blueVals[pixels[col][row].getBlue()] += 1;
			}
		}
		return new int[][]{redVals, greenVals, blueVals};
	}

	public Picture pixelize(int pixelRange) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture pixelatedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = pixelatedPicture.getPixels2DColumnMajor();
		int maxCol = currentPixels.length - 1;
		int maxRow = currentPixels[0].length - 1;

		for(int row = 0; row < currentPixels[0].length; row += pixelRange) {
			for(int col = 0; col < currentPixels.length; col += pixelRange) {
				setSurroundingColor(newPixels, col, row, maxCol, maxRow, currentPixels[col][row].getColor(), pixelRange);
			}
		}

		return pixelatedPicture;
	}

	private void setSurroundingColor(Pixel[][] newPixels, int col, int row, int maxCol, int maxRow, Color setColor, int pixelRange) {
		int radius = pixelRange % 2 == 0 ? pixelRange / 2 : pixelRange / 2 + 1;

		//See averagePixel() function
		for(int y = Math.max(row - radius, 0); y < Math.min(row + radius, maxRow); y++) {
			for (int x = Math.max(col - radius, 0); x < Math.min(col + radius, maxCol); x++) {
				newPixels[x][y].setColor(setColor);
			}
		}
	}

	/**
	 * Applies sepia filter to picuture
	 *
	 * sepia values gotten from
	 * https://www.geeksforgeeks.org/image-processing-in-java-colored-image-to-sepia-image-conversion/
	 *
	 * @return sepia modified picture
	 */
	public Picture sepia() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture sepiaPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = sepiaPicture.getPixels2DColumnMajor();
		int newRed;
		int newGreen;
		int newBlue;
		Pixel tempPixel;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[col][row];
				newRed = Math.min(255, (int)((0.393 * tempPixel.getRed()) + (0.769 * tempPixel.getGreen()) + (0.189 * tempPixel.getBlue())));
				newGreen = Math.min(255, (int)((0.349 * tempPixel.getRed()) + (0.686 * tempPixel.getGreen()) + (0.168 * tempPixel.getBlue())));
				newBlue = Math.min(255, (int)((0.272 * tempPixel.getRed()) + (0.534 * tempPixel.getGreen()) + (0.131 * tempPixel.getBlue())));
				newPixels[col][row].setColor(new Color(newRed, newGreen, newBlue));
			}
		}

		return sepiaPicture;
	}

	public Picture lighten() {
		double factor = 2.2;

		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture lighterPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = lighterPicture.getPixels2DColumnMajor();
		int newRed;
		int newGreen;
		int newBlue;
		Pixel tempPixel;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[col][row];
				newRed = Math.min(255, (int)(factor * tempPixel.getRed()));
				newGreen = Math.min(255, (int)(factor * tempPixel.getGreen()));
				newBlue = Math.min(255, (int)(factor * tempPixel.getBlue()));
				newPixels[col][row].setColor(new Color(Math.max(newRed, 1), Math.max(newGreen, 1), Math.max(newBlue, 1)));
			}
		}

		return lighterPicture;
	}

	public Picture darken() {
		double factor = .7;

		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture darkerPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = darkerPicture.getPixels2DColumnMajor();
		int newRed;
		int newGreen;
		int newBlue;
		Pixel tempPixel;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[col][row];
				newRed = Math.min(255, (int)(factor * tempPixel.getRed()));
				newGreen = Math.min(255, (int)(factor * tempPixel.getGreen()));
				newBlue = Math.min(255, (int)(factor * tempPixel.getBlue()));
				newPixels[col][row].setColor(new Color(newRed, newGreen, newBlue));
			}
		}

		return darkerPicture;
	}

	// This is technically a nearest neighbor scale
	public Picture scale(double amount) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture((int)(currentPixels[0].length * amount), (int)(currentPixels.length * amount));
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();
		Pixel tempPixel;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[(int)(col / amount)][(int) (row / amount)];
				newPixels[col][row].setColor(tempPixel.getColor());
			}
		}

		return scaledPicture;
	}


	/**
	 * Scales the picture to match the size of the target picture
	 * @param target Picture to be scaled to
	 * @return
	 */
	public Picture scaleToMatch(Picture target) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture(target.getHeight(), target.getWidth());
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();
		Pixel tempPixel;

		double colRatio = ((double) target.getWidth())/getWidth();
		double rowRatio = ((double) target.getHeight())/getHeight();

		System.out.println("colRation: " + colRatio + " rowRation: " + rowRatio);

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[(int)(col / colRatio)][(int) (row / rowRatio)];
				double[] cubicInterpolated = biHermiteInterpolate(col/colRatio, row/rowRatio, currentPixels);

				newPixels[col][row].setColor(new Color(correctDoubleToIntForRGB(cubicInterpolated[0]), correctDoubleToIntForRGB(cubicInterpolated[1]), correctDoubleToIntForRGB(cubicInterpolated[2])));
			}
		}

		return scaledPicture;
	}

	public Picture betterScale(double amount) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture((int)(currentPixels[0].length * amount), (int)(currentPixels.length * amount));
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();
		Pixel tempPixel;
		Color tempColor1;
		Color tempColor2;
		double fromCol;
		double fromRow;
		int maxCol = currentPixels.length - 1;
		int maxRow = currentPixels[0].length -1;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {

				fromCol = col/amount;
				fromRow = row/amount;

				tempPixel = currentPixels[(int) fromCol][(int) fromRow];

				if(fromCol - (int)fromCol > .15 && fromRow - (int)fromRow > .15 && col < maxCol && row < maxRow) {
					tempColor1 = currentPixels[(int) fromCol][(int) fromRow].getColor();
					tempColor2 = currentPixels[(int) fromCol + 1][(int) fromRow + 1].getColor();
					tempPixel.setColor(averageColors(tempColor1, tempColor2));

				} else if (fromCol - (int)fromCol > .15 && col < maxCol) {
					tempColor1 = currentPixels[(int) fromCol][(int) fromRow].getColor();
					tempColor2 = currentPixels[(int) fromCol + 1][(int) fromRow].getColor();
					tempPixel.setColor(averageColors(tempColor1, tempColor2));
				} else if (fromRow - (int)fromRow > .15 && row < maxRow) {
					tempColor1 = currentPixels[(int) fromCol][(int) fromRow].getColor();
					tempColor2 = currentPixels[(int) fromCol][(int) fromRow + 1].getColor();
					tempPixel.setColor(averageColors(tempColor1, tempColor2));
				}

				newPixels[col][row].setColor(tempPixel.getColor());
			}
		}

		return scaledPicture;
	}

	private Color averageColors(Color color1, Color color2) {
		return new Color(
				(color1.getRed() + color2.getRed()) / 2,
				(color1.getGreen() + color2.getGreen()) / 2,
				(color1.getBlue() + color2.getBlue()) / 2
		);
	}
	public Picture gaussianBlur() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture guassianPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = guassianPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromKernel(PixelKernel.GAUSSIAN_BLUR,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return guassianPicture;
	}

	private Color guassianAveragePixel(Pixel[][] pixelArray, int row, int col, int maxRow, int maxCol) {
		int redAvg = 0;
		int greenAvg = 0;
		int blueAvg = 0;
		int count = 0;

        /*
        This better way of doing it came from this stack overflow question
        https://stackoverflow.com/questions/4622572/best-way-to-check-the-indices-around-a-certain-index-in-a-2d-array?rq=4
         */

		for (int y = Math.max(row - 1, 0); y < Math.min(row + 1, maxRow); y++) {
			for (int x = Math.max(col - 1, 0); x < Math.min(col + 1, maxCol); x++) {
				int tempRed = pixelArray[y][x].getRed();
				int tempGreen = pixelArray[y][x].getGreen();
				int tempBlue = pixelArray[y][x].getBlue();
				if(y == row && x == col) {
					count += 4;
					redAvg += 4 * tempRed;
					greenAvg += 4 * tempGreen;
					blueAvg += 4 * tempBlue;
				} else if (y == row || x == col) {
					count += 2;
					redAvg += 2 * tempRed;
					greenAvg += 2 * tempGreen;
					blueAvg += 2 * tempBlue;
				}
				else {
					count++;
					redAvg += tempRed;
					greenAvg += tempGreen;
					blueAvg += tempBlue;
				}
			}
		}
		return new Color(redAvg / count, greenAvg / count, blueAvg / count);
	}

	public Picture createMask() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture maskPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = maskPicture.getPixels2DColumnMajor();
		Picture blurredPicture = this.gaussianBlur();
		Pixel[][] blurredPixels = blurredPicture.getPixels2DColumnMajor();
		for(int row = 0; row < currentPixels.length; row++) {
			for (int col = 0; col < currentPixels[row].length; col++) {
				newPixels[col][row].setColor(subtractColors(currentPixels[col][row].getColor(), blurredPixels[col][row].getColor()));
			}
		}

		return maskPicture;
	}

	private Color subtractColors(Color color1, Color color2) {
		return new Color(
			Math.max(color1.getRed() - color2.getRed(), 0),
			Math.max(color1.getGreen() - color2.getGreen(), 0),
			Math.max(color1.getBlue() - color2.getBlue(), 0)
		);
	}

	/**
	 * Applys a mask to the image
	 * @param mask mask to be applied to the image
	 * @return masked image
	 */
	public Picture applyMask(Picture mask) {

		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture enhancedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = enhancedPicture.getPixels2DColumnMajor();
		if(mask.getPixels2DColumnMajor().length != currentPixels.length || mask.getPixels2DColumnMajor()[0].length != currentPixels[0].length) {
			System.out.println("Mask is of improper size");
			return null;
		}
		Pixel[][] maskPixels = mask.getPixels2D();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(addColors(currentPixels[col][row].getColor(), maskPixels[col][row].getColor()));
			}
		}

		return enhancedPicture;
	}

	/**
	 * Creates a mask of the image and reapplies it to the image
	 * @return masked image
	 */
	public Picture createAndApplyMask() {

		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture enhancedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = enhancedPicture.getPixels2DColumnMajor();
		Picture mask = this.createMask();
		if(mask.getPixels2DColumnMajor().length != currentPixels.length || mask.getPixels2DColumnMajor()[0].length != currentPixels[0].length) {
			System.out.println("Mask is of improper size");
			return null;
		}
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(addColors(currentPixels[col][row].getColor(), mask.getPixels2D()[col][row].getColor()));
			}
		}

		return enhancedPicture;
	}

	private Color addColors(Color color1, Color color2) {
		return new Color(
				Math.min(color1.getRed() + color2.getRed(), 255),
				Math.min(color1.getGreen() + color2.getGreen(), 255),
				Math.min(color1.getBlue() + color2.getBlue(), 255)
		);
	}

	private Color addColorsWithWeight(Color color1, Color color2, int weight) {
		return new Color(
				Math.min(color1.getRed() + (weight * color2.getRed()), 255),
				Math.min(color1.getGreen() + (weight * color2.getGreen()), 255),
				Math.min(color1.getBlue() + (weight * color2.getBlue()), 255)
		);
	}

	public Picture topSobel() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture sobelPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = sobelPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromKernel(PixelKernel.TOP_SOBEL,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return sobelPicture;
	}

	public Picture topAndLeftSobel() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture sobelPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = sobelPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromTwoKernels(PixelKernel.TOP_SOBEL, PixelKernel.LEFT_SOBEL,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return sobelPicture;
	}

	public Picture applyDoubleKernel(PixelKernel kernel1, PixelKernel kernel2) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture sobelPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = sobelPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromTwoKernels(kernel1, kernel2,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return sobelPicture;
	}

	public Picture gaussian5X5() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture gaussianPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = gaussianPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromKernel(PixelKernel.GAUSSIAN_BLUR_5X5,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return gaussianPicture;
	}

	public Picture applyKernel(PixelKernel kernel) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture kerneledPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = kerneledPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromKernel(kernel,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}

		return kerneledPicture;
	}

	public Picture applyDoubleKernelHSV(PixelKernel kernel1, PixelKernel kernel2) {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture sobelPicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = sobelPicture.getHSVPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = generateHSVFromTwoKernels(kernel1, kernel2,
						row, col, maxHeight, maxWidth, currentPixels);
			}
		}
		sobelPicture.updateHSVToRGB(currentPixels);
		return sobelPicture;
	}

	public Picture unsharpMasking() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture unsharpPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = unsharpPicture.getPixels2DColumnMajor();
		int maxWidth = currentPixels.length;
		int maxHeight = currentPixels[0].length;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row].setColor(generateColorFromKernel(PixelKernel.UNSHARP_MASKING_5X5,
						row, col, maxHeight, maxWidth, currentPixels));
			}
		}
		return unsharpPicture;
	}

	public Picture applySplitKernel(SeparatedPixelKernel kernel){
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture tempPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] intermediateArray = tempPicture.getPixels2DColumnMajor();
		Picture kerneledPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = kerneledPicture.getPixels2DColumnMajor();

		float combinedRed = 0;
		float combinedGreen = 0;
		float combinedBlue = 0;

		float[] vertKernel = kernel.getVerticalArray();
		int range = vertKernel.length / 2;

		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {

				float count = 0;
				combinedRed = 0;
				combinedGreen = 0;
				combinedBlue = 0;
				for(int ker = row - range; ker < row + range + 1; ker++) {
					int pullKer = Math.max(Math.min(ker, currentPixels[0].length - 1), 0);

					combinedRed += (currentPixels[col][pullKer].getRed() * vertKernel[row - ker + range]);
					combinedGreen += (currentPixels[col][pullKer].getGreen() * vertKernel[row - ker + range]);
					combinedBlue += (currentPixels[col][pullKer].getBlue() * vertKernel[row - ker + range]);

					count += vertKernel[row - ker + range];
				}
				if(kernel.getAverage()) {
					combinedRed /= count;
					combinedGreen /= count;
					combinedBlue /= count;
				}

				intermediateArray[col][row].setColor(
						new Color(
								Math.min(Math.max(Math.round(combinedRed), 0), 255),
								Math.min(Math.max(Math.round(combinedGreen), 0), 255),
								Math.min(Math.max(Math.round(combinedBlue), 0), 255))
				);
			}
		}

		float[] horzKernel = kernel.getHorizontalArray();
		range = horzKernel.length / 2;

		for(int row = 0; row < intermediateArray[0].length; row++) {
			for (int col = 0; col < intermediateArray.length; col++) {

				float count = 0;
				combinedRed = 0;
				combinedGreen = 0;
				combinedBlue = 0;
				for(int ker = col - range; ker < col + range + 1; ker++) {
					int pullKer = Math.max(Math.min(ker, intermediateArray.length - 1), 0);

					combinedRed += (intermediateArray[pullKer][row].getRed() * horzKernel[col - ker + range]);
					combinedGreen += (intermediateArray[pullKer][row].getGreen() * horzKernel[col - ker + range]);
					combinedBlue += (intermediateArray[pullKer][row].getBlue() * horzKernel[col - ker + range]);

					count += vertKernel[col - ker + range];
				}
				if(kernel.getAverage()) {
					combinedRed /= count;
					combinedGreen /= count;
					combinedBlue /= count;
				}

				newPixels[col][row].setColor(
						new Color(
								Math.min(Math.max(Math.round(combinedRed), 0), 255),
								Math.min(Math.max(Math.round(combinedGreen), 0), 255),
								Math.min(Math.max(Math.round(combinedBlue), 0), 255))
				);
			}
		}

		return kerneledPicture;
	}

	public Picture applyMultipleSplitKernel(SeparatedPixelKernel kernel1, SeparatedPixelKernel kernel2){
		if(kernel1.getHorizontalArray().length != kernel2.getHorizontalArray().length ||
				kernel1.getVerticalArray().length != kernel2.getVerticalArray().length) {
			System.err.println("Kernels are of unequal length!");
			return null;
		}

		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture tempPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] intermediateArray = tempPicture.getPixels2DColumnMajor();
		Picture kerneledPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = kerneledPicture.getPixels2DColumnMajor();

		float combinedRed = 0;
		float combinedGreen = 0;
		float combinedBlue = 0;

		float red1 = 0;
		float red2 = 0;
		float green1 = 0;
		float green2 = 0;
		float blue1 = 0;
		float blue2 = 0;

		float[] vertKernel1 = kernel1.getVerticalArray();
		float[] vertKernel2 = kernel2.getHorizontalArray();
		int range = vertKernel1.length / 2;
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				combinedRed = 0;
				combinedGreen = 0;
				combinedBlue = 0;

				red1 = 0;
				red2 = 0;
				green1 = 0;
				green2 = 0;
				blue1 = 0;
				blue2 = 0;
				for(int ker = row - range; ker < row + range + 1; ker++) {
					int pullKer = Math.max(Math.min(ker, currentPixels[0].length - 1), 0);

					int red = currentPixels[col][pullKer].getRed();
					int green = currentPixels[col][pullKer].getGreen();
					int blue = currentPixels[col][pullKer].getBlue();

					red1 += (red * vertKernel1[row - ker + range]);
					red2 += (red * vertKernel2[row - ker + range]);
					green1 += (green * vertKernel1[row - ker + range]);
					green2 += (green * vertKernel2[row - ker + range]);
					blue1 += (blue * vertKernel1[row - ker + range]);
					blue2 += (blue * vertKernel2[row - ker + range]);

					combinedRed += ((red * vertKernel1[row - ker + range]) + (red * vertKernel2[row - ker + range]));
					combinedGreen += ((green * vertKernel1[row - ker + range]) + (green * vertKernel2[row - ker + range]));
					combinedBlue += ((blue * vertKernel1[row - ker + range]) + (blue * vertKernel2[row - ker + range]));
				}
				if(kernel1.getGradient() && kernel2.getGradient()) {
					float gRed = (float)Math.sqrt(Math.pow(red1, 2) + Math.pow(red2, 2));
					float gGreen = (float)Math.sqrt(Math.pow(green1, 2) + Math.pow(green2, 2));
					float gBlue = (float)Math.sqrt(Math.pow(blue1, 2) + Math.pow(blue2, 2));

					intermediateArray[col][row].setColor(
							new Color(
									Math.min(Math.max(Math.round(gRed), 0), 255),
									Math.min(Math.max(Math.round(gGreen), 0), 255),
									Math.min(Math.max(Math.round(gBlue), 0), 255))
					);
				}

				else {
					intermediateArray[col][row].setColor(
							new Color(
									Math.min(Math.max(Math.round(combinedRed), 0), 255),
									Math.min(Math.max(Math.round(combinedGreen), 0), 255),
									Math.min(Math.max(Math.round(combinedBlue), 0), 255))
					);
				}
			}
		}

		float[] horzKernel1 = kernel1.getHorizontalArray();
		float[] horzKernel2 = kernel2.getVerticalArray();
		range = horzKernel1.length / 2;

		for(int row = 0; row < intermediateArray[0].length; row++) {
			for (int col = 0; col < intermediateArray.length; col++) {

				combinedRed = 0;
				combinedGreen = 0;
				combinedBlue = 0;

				red1 = 0;
				red2 = 0;
				green1 = 0;
				green2 = 0;
				blue1 = 0;
				blue2 = 0;

				for(int ker = col - range; ker < col + range + 1; ker++) {
					int pullKer = Math.max(Math.min(ker, intermediateArray.length - 1), 0);

					int red = intermediateArray[pullKer][row].getRed();
					int green = intermediateArray[pullKer][row].getGreen();
					int blue = intermediateArray[pullKer][row].getGreen();

					red1 += (red * vertKernel1[col - ker + range]);
					red2 += (red * vertKernel2[col - ker + range]);
					green1 += (green * vertKernel1[col - ker + range]);
					green2 += (green * vertKernel2[col - ker + range]);
					blue1 += (blue * vertKernel1[col - ker + range]);
					blue2 += (blue * vertKernel2[col - ker + range]);

					combinedRed += ((red * horzKernel1[col - ker + range]) + (red * horzKernel2[col - ker + range]));
					combinedGreen += ((green * horzKernel1[col - ker + range]) + (green * horzKernel2[col - ker + range]));
					combinedBlue += ((blue * horzKernel1[col - ker + range]) * (blue * horzKernel1[col - ker + range]));
				}
				if(kernel1.getGradient() && kernel2.getGradient()) {
					float gRed = (float)Math.sqrt(Math.pow(red1, 2) + Math.pow(red2, 2));
					float gGreen = (float)Math.sqrt(Math.pow(green1, 2) + Math.pow(green2, 2));
					float gBlue = (float)Math.sqrt(Math.pow(blue1, 2) + Math.pow(blue2, 2));

					newPixels[col][row].setColor(
							new Color(
									Math.min(Math.max(Math.round(gRed), 0), 255),
									Math.min(Math.max(Math.round(gGreen), 0), 255),
									Math.min(Math.max(Math.round(gBlue), 0), 255))
					);
				}
				else {
					newPixels[col][row].setColor(
							new Color(
									Math.min(Math.max(Math.round(combinedRed), 0), 255),
									Math.min(Math.max(Math.round(combinedGreen), 0), 255),
									Math.min(Math.max(Math.round(combinedBlue), 0), 255))
					);
				}
			}
		}

		return kerneledPicture;
	}

	/**
	 * Creates a new color for a pixel based on the provided kernel
	 * @param kernelName kernel transformation will be based on
	 * @param row row of current pixel
	 * @param col column of current pixel
	 * @param maxRow last row in picture
	 * @param maxCol last column in picture
	 * @param pixels a column major matrix of pixels
	 * @return a new color based on the provided kernel and surrounding pixels
	 */
	private Color generateColorFromKernel(PixelKernel kernelName, int row, int col, int maxRow, int maxCol, Pixel[][] pixels) {
		/*
        This better way of doing it came from this stack overflow question
        https://stackoverflow.com/questions/4622572/best-way-to-check-the-indices-around-a-certain-index-in-a-2d-array?rq=4
         */

		float[][] kernel = kernelName.getKernelMatrix();

		float combinedRed = 0;
		float combinedGreen = 0;
		float combinedBlue = 0;

		int count = 0;

		int range = kernel.length / 2;

		for (int y = row - range; y < row + range + 1; y++) {
			for (int x = col - range; x < col + range + 1; x++) {
				int pullX = Math.max(Math.min(x, maxCol - 1), 0);
				int pullY = Math.max(Math.min(y, maxRow - 1), 0);
				combinedRed += (pixels[pullX][pullY].getRed() * kernel[x - col + range][y - row + range]);
				combinedGreen += (pixels[pullX][pullY].getGreen() * kernel[x - col + range][y - row + range]);
				combinedBlue += (pixels[pullX][pullY].getBlue() * kernel[x - col + range][y - row + range]);

				count += kernel[x - col + range][y - row + range];
			}
		}

//		for(int x = Math.max(col - range, 0), y = Math.max(row - range, 0);
//			x < Math.min(col + range + 1, maxCol) && y < Math.min(row + range + 1, maxRow) ; x++) {
//			combinedRed += (pixels[x][y].getRed() * kernel[x - col + range][y - row + range]);
//			combinedGreen += (pixels[x][y].getGreen() * kernel[x - col + range][y - row + range]);
//			combinedBlue += (pixels[x][y].getBlue() * kernel[x - col + range][y - row + range]);
//
//		}

		if(kernelName.getAverage()) {
			combinedRed /= count;
			combinedGreen /= count;
			combinedBlue /= count;
		}

		return new Color(
				Math.min(Math.max(Math.round(combinedRed), 0), 255),
				Math.min(Math.max(Math.round(combinedGreen), 0), 255),
				Math.min(Math.max(Math.round(combinedBlue), 0), 255));
	}

	private Color generateColorFromTwoKernels(PixelKernel kernelName1, PixelKernel kernelName2, int row, int col, int maxRow, int maxCol, Pixel[][] pixels) {
		/*
        This better way of doing it came from this stack overflow question
        https://stackoverflow.com/questions/4622572/best-way-to-check-the-indices-around-a-certain-index-in-a-2d-array?rq=4
         */

		float[][] kernel1 = kernelName1.getKernelMatrix();
		float[][] kernel2 = kernelName2.getKernelMatrix();

		float combinedRed = 0;
		float combinedGreen = 0;
		float combinedBlue = 0;

		float red1 = 0;
		float red2 = 0;
		float green1 = 0;
		float green2 = 0;
		float blue1 = 0;
		float blue2 = 0;

		int range = kernel1.length / 2;

		for (int y = row - range; y < row + range + 1; y++) {
			for (int x = col - range; x < col + range + 1; x++) {
				int pullX = Math.max(Math.min(x, maxCol - 1), 0);
				int pullY = Math.max(Math.min(y, maxRow - 1), 0);

				int pixelRed = pixels[pullX][pullY].getRed();
				int pixelGreen = pixels[pullX][pullY].getGreen();
				int pixelBlue = pixels[pullX][pullY].getBlue();

				red1 += (pixelRed * kernel1[x - col + range][y - row + range]);
				red2 += (pixelRed * kernel2[x - col + range][y - row + range]);
				green1 += (pixelGreen * kernel1[x - col + range][y - row + range]);
				green2 += (pixelGreen * kernel2[x - col + range][y - row + range]);
				blue1 += (pixelBlue * kernel1[x - col + range][y - row + range]);
				blue2 += (pixelBlue * kernel2[x - col + range][y - row + range]);

				combinedRed += (pixelRed * kernel1[x - col + range][y - row + range]) +
						(pixelRed * kernel2[x - col + range][y - row + range]);
				combinedGreen += (pixelGreen * kernel1[x - col + range][y - row + range]) +
						(pixelGreen * kernel2[x - col + range][y - row + range]);
				combinedBlue += (pixelBlue * kernel1[x - col + range][y - row + range]) +
						(pixelBlue * kernel2[x - col + range][y - row + range]);
			}
		}

//		for(int x = Math.max(col - range, 0), y = Math.max(row - range, 0);
//			x < Math.min(col + range + 1, maxCol) && y < Math.min(row + range + 1, maxRow) ; x++) {
//			combinedRed += (pixels[x][y].getRed() * kernel[x - col + range][y - row + range]);
//			combinedGreen += (pixels[x][y].getGreen() * kernel[x - col + range][y - row + range]);
//			combinedBlue += (pixels[x][y].getBlue() * kernel[x - col + range][y - row + range]);
//
//		}

		if(kernelName1.getGradient() && kernelName2.getGradient()) {
			float gRed = (float)Math.sqrt(Math.pow(red1, 2) + Math.pow(red2, 2));
			float gGreen = (float)Math.sqrt(Math.pow(green1, 2) + Math.pow(green2, 2));
			float gBlue = (float)Math.sqrt(Math.pow(blue1, 2) + Math.pow(blue2, 2));

			return new Color(
					Math.min(Math.max(Math.round(gRed), 0), 255),
					Math.min(Math.max(Math.round(gGreen), 0), 255),
					Math.min(Math.max(Math.round(gBlue), 0), 255));
		}

		else {
			return new Color(
					Math.min(Math.max(Math.round(combinedRed), 0), 255),
					Math.min(Math.max(Math.round(combinedGreen), 0), 255),
					Math.min(Math.max(Math.round(combinedBlue), 0), 255));
		}
	}

	private HSVPixel generateHSVFromTwoKernels(PixelKernel kernelName1, PixelKernel kernelName2, int row, int col, int maxRow, int maxCol, HSVPixel[][] pixels) {
		/*
        This better way of doing it came from this stack overflow question
        https://stackoverflow.com/questions/4622572/best-way-to-check-the-indices-around-a-certain-index-in-a-2d-array?rq=4
         */

		float[][] kernel1 = kernelName1.getKernelMatrix();
		float[][] kernel2 = kernelName2.getKernelMatrix();

		float combinedHue = 0;

		float hue1 = 0;
		float hue2 = 0;
		int range = kernel1.length / 2;

		for (int y = row - range; y < row + range + 1; y++) {
			for (int x = col - range; x < col + range + 1; x++) {
				int pullX = Math.max(Math.min(x, maxCol - 1), 0);
				int pullY = Math.max(Math.min(y, maxRow - 1), 0);

				double pixelHue = pixels[pullX][pullY].getHue();

				hue1 += (pixelHue * kernel1[x - col + range][y - row + range]);
				hue2 += (pixelHue * kernel2[x - col + range][y - row + range]);

				combinedHue += (pixelHue * kernel1[x - col + range][y - row + range]) +
						(pixelHue * kernel2[x - col + range][y - row + range]);
			}
		}

		if(kernelName1.getGradient() && kernelName2.getGradient()) {
			float gHue = (float)Math.sqrt(Math.pow(hue1, 2) + Math.pow(hue2, 2));
			HSVPixel tempPixel = pixels[col][row];
			tempPixel.setHue(gHue);
			return tempPixel;
		}

		else {
			HSVPixel tempPixel = pixels[col][row];
			tempPixel.setHue(combinedHue);
			return tempPixel;
		}
	}


	public Picture rotateByFixedAngle(double angle) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture rotatedPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = rotatedPicture.getPixels2DColumnMajor();


		double cosTheta = Math.cos(-angle);
		double sinTheta = Math.sin(-angle);

		double dx = - cosTheta * this.getWidth()/2.0 + sinTheta * this.getHeight()/2.0 + this.getWidth()/2.0;
		double dy = - sinTheta * this.getWidth()/2.0 - cosTheta * this.getHeight()/2.0 + this.getHeight()/2.0;

		for(int row = 0; row < newPixels[0].length; row++){
			for(int col = 0; col < newPixels.length; col++) {
				double newCol = cosTheta * col - sinTheta * row + dx;
				double newRow = sinTheta * col + cosTheta * row + dy;

				int colCord = (int) newCol;
				int rowCord = (int) newRow;

				if((colCord >= 0 && colCord < this.getWidth()) && (rowCord >= 0 && rowCord < this.getHeight())) {
					double[] cubicInterpolated = biHermiteInterpolate(newCol, newRow, currentPixels);

					newPixels[col][row].setColor(new Color(correctDoubleToIntForRGB(cubicInterpolated[0]), correctDoubleToIntForRGB(cubicInterpolated[1]), correctDoubleToIntForRGB(cubicInterpolated[2])));
				}
				else
					newPixels[col][row].setColor(Color.BLACK);
			}
		}

		return rotatedPicture;
	}

	public Picture rotateAndExpand(double angle) {
		double cosTheta = Math.cos(-angle);
		double sinTheta = Math.sin(-angle);

    // Calculate new canvas size
		double[][] corners = new double[][]{
        {-getWidth()/2.0, -getHeight()/2.0},
        {getWidth()/2.0, -getHeight()/2.0},
        {getWidth()/2.0, getHeight()/2.0},
        {-getWidth()/2.0, getHeight()/2.0}
    };

		double maxX = 0;
		double maxY = 0;

		for (double[] corner : corners){
			double newCorner[] = rotationNoCentering(corner, angle);
			if (Math.abs(newCorner[0]) > maxX) {
				maxX = Math.abs(newCorner[0]);
			}
			if (Math.abs(newCorner[1]) > maxY) {
				maxY = Math.abs(newCorner[1]);
			}
		}

		Picture newImage = new Picture( (int) (maxY*2), (int) (maxX*2) );;
		Pixel[][] newPixels = newImage.getPixels2DColumnMajor();
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();

		for (int row = 0; row < newImage.getHeight(); row++) {
			for (int col = 0; col < newImage.getWidth(); col++) {

				int offsetX = (getWidth() - newImage.getWidth()) / 2;
				int offsetY = (getHeight() - newImage.getHeight()) / 2;

				double[] newCords = rotationFast(new int[]{col + offsetX, row + offsetY}, cosTheta, sinTheta);

				int newX = (int) newCords[0];
				int newY = (int) newCords[1];

				if ((0 <= newX && newX < getWidth()) && (0 <= newY && newY < getHeight())){
					double[] cubicInterpolated = biHermiteInterpolate(newX, newY, currentPixels);

					newPixels[col][row].setColor(new Color(correctDoubleToIntForRGB(cubicInterpolated[0]), correctDoubleToIntForRGB(cubicInterpolated[1]), correctDoubleToIntForRGB(cubicInterpolated[2])));
				}
            	else{
					newPixels[col][row].setColor(Color.BLACK);
				}

			}
		}
		return newImage;
	}

	public Picture rotateAndFit(double angle) {

		// Calculate new canvas size
		int[] dims = getNewDimensions(getWidth(), getHeight(), angle);

		Picture newImage = new Picture( dims[1], dims[0] );
		Pixel[][] newPixels = newImage.getPixels2DColumnMajor();
		Picture rotatedImage = this.rotateAndExpand(angle);
		Pixel[][] currentPixels = rotatedImage.getPixels2DColumnMajor();

		int horzOff = (rotatedImage.getWidth() - dims[0])/2;
		int vertOff = (rotatedImage.getHeight() - dims[1])/2;

		for (int row = 0; row < newImage.getHeight(); row++) {
			for (int col = 0; col < newImage.getWidth(); col++) {

				if ((0 <= col + horzOff && col + horzOff < rotatedImage.getWidth()) && (0 <= row + vertOff && row + vertOff < rotatedImage.getHeight())) {
					newPixels[col][row].setColor(currentPixels[col + horzOff][row + vertOff].getColor());
				}
				else{
					newPixels[col][row].setColor(Color.BLACK);
				}

			}
		}

		return newImage;
	}

	//Based it off this stack overflow Koi sent me
	//https://stackoverflow.com/questions/16702966/rotate-image-and-crop-out-black-borders?noredirect=1&lq=1
	private int[] getNewDimensions(int width, int height, double angle) {

		boolean width_is_longer = width >= height;
		double longSide, shortSide;
		if(width_is_longer) {
			longSide = width;
			shortSide = height;
		}
		else {
			longSide = height;
			shortSide = width;
		}

  		// since the solutions for angle, -angle and 180-angle are all the same,
		// it suffices to look at the first quadrant and the absolute values of sin,cos:
		double sin_a = Math.abs(Math.sin(angle));
		double cos_a = Math.abs(Math.cos(angle));

		double wr,hr;

		if (shortSide <= 2. * sin_a * cos_a * longSide || Math.abs(sin_a-cos_a) < 1e-10) {
			//half constrained case: two crop corners touch the longer side,
			//the other two corners are on the mid-line parallel to the longer line
			double x = 0.5 * shortSide;

			if (width_is_longer) {
				wr = x/sin_a;
				hr = x/cos_a;
			}
			else {
				wr = x/cos_a;
				hr = x/sin_a;
			}
		}
		else {
			double cos_2a = cos_a*cos_a - sin_a*sin_a;
			wr = (width * cos_a - height *sin_a) / cos_2a;
			hr = (height * cos_a - width * sin_a) / cos_2a;
		}

		return new int[]{(int) wr, (int) hr};
	}

	private double[] rotation(int[] point, double angle) {
		int x = point[0];
		int y = point[1];

		double cosTheta = Math.cos(angle);
		double sinTheta = Math.sin(angle);

		double dx = - cosTheta * getWidth() / 2.0 + sinTheta * getHeight() / 2.0 + getWidth() / 2.0;
		double dy = - sinTheta * getWidth() / 2.0 - cosTheta * getHeight() / 2.0 + getHeight() / 2.0;

		double newX = cosTheta * x - sinTheta * y + dx;
		double newY = sinTheta * x + cosTheta * y + dy;

		return new double[]{newX, newY};
	}



	private double[] rotationFast(int[] point, double cosTheta, double sinTheta) {
		int x = point[0];
		int y = point[1];

		double dx = - cosTheta * getWidth() / 2.0 + sinTheta * getHeight() / 2.0 + getWidth() / 2.0;
		double dy = - sinTheta * getWidth() / 2.0 - cosTheta * getHeight() / 2.0 + getHeight() / 2.0;

		double newX = cosTheta * x - sinTheta * y + dx;
		double newY = sinTheta * x + cosTheta * y + dy;

		return new double[]{newX, newY};
	}


	private double[] rotationNoCentering(double[] point, double angle) {
		double cosTheta = Math.cos(-angle);
		double sinTheta = Math.sin(-angle);

		double x = point[0];
		double y = point[1];

		double newX = cosTheta * x - sinTheta * y;
		double newY = sinTheta * x + cosTheta * y;

		return new double[]{newX, newY};
	}

	public Picture startFloodFill(Color targetColor, Color replacementColor, int col, int row) {
		recursiveFloodFill(targetColor, replacementColor, col, row, this.getPixels2DColumnMajor());

		return this;
	}

	public Picture startFloodFillDiagonal(Color targetColor, Color replacementColor, int col, int row) {
		recursiveFloodFillDiagonal(targetColor, replacementColor, col, row, this.getPixels2DColumnMajor());

		return this;
	}

	class fillObj{

		private Color targetColor;
		private Color replacementColor;
		private int col;
		private int row;
		private Pixel[][] pixels;

		public fillObj(Color targetColor, Color replacementColor, int col, int row, Pixel[][] pixels) {
			this.targetColor = targetColor;
			this.replacementColor = replacementColor;
			this.col = col;
			this.row = row;
			this.pixels = pixels;
		}

		public Color getTargetColor() {
			return targetColor;
		}

		public Color getReplacementColor() {
			return replacementColor;
		}

		public int getCol() {
			return col;
		}

		public int getRow() {
			return row;
		}

		public Pixel[][] getPixels() {
			return pixels;
		}
	}

	private void recursiveFloodFill(Color targetColor, Color replacementColor, int col, int row, Pixel[][] pixels) {
		Stack<fillObj> fillStack = new Stack<>();
		fillStack.push(new fillObj(targetColor, replacementColor, col, row, pixels));

		int count = 0;
		while (!fillStack.empty()) {
			fillObj temp = fillStack.pop();
			if(!checkHorizontalValid(temp.getCol()) || !checkVerticalValid(temp.getRow()) || !temp.getPixels()[temp.getCol()][temp.getRow()].getColor().equals(temp.getTargetColor())) {
				continue;
			}
			if(temp.getPixels()[temp.getCol()][temp.getRow()].getColor().equals(temp.getTargetColor())) {

				temp.getPixels()[temp.getCol()][temp.getRow()].setColor(temp.getReplacementColor());
			}

			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol(), temp.getRow() + 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() + 1, temp.getRow(), temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol(), temp.getRow() - 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() - 1, temp.getRow(), temp.getPixels()));
		}
	}

	private void recursiveFloodFillDiagonal(Color targetColor, Color replacementColor, int col, int row, Pixel[][] pixels) {
		Stack<fillObj> fillStack = new Stack<>();
		fillStack.push(new fillObj(targetColor, replacementColor, col, row, pixels));

		int count = 0;
		while (!fillStack.empty()) {
			fillObj temp = fillStack.pop();
			if(!checkHorizontalValid(temp.getCol()) || !checkVerticalValid(temp.getRow()) || temp.getPixels()[temp.getCol()][temp.getRow()].colorDistance(temp.getTargetColor()) > 20) {
				continue;
			}
			if(temp.getPixels()[temp.getCol()][temp.getRow()].colorDistance(temp.getTargetColor()) < 20) {

				temp.getPixels()[temp.getCol()][temp.getRow()].setColor(temp.getReplacementColor());
			}

			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol(), temp.getRow() + 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() + 1, temp.getRow(), temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol(), temp.getRow() - 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() - 1, temp.getRow(), temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() + 1, temp.getRow() + 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() + 1, temp.getRow() - 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() - 1, temp.getRow() - 1, temp.getPixels()));
			fillStack.push(new fillObj(temp.getTargetColor(), temp.getReplacementColor(), temp.getCol() - 1, temp.getRow() + 1, temp.getPixels()));
		}
	}

	private boolean checkHorizontalValid(int col) {
		return 0 <= col && col < this.getWidth();
	}

	private boolean checkVerticalValid(int row) {
		return 0 <= row && row < this.getHeight();
	}

	public Picture invertHue() {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture invertedHuePicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = invertedHuePicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = currentPixels[col][row].hue(100 - currentPixels[col][row].getHue());
			}
		}
		invertedHuePicture.updateHSVToRGB(currentPixels);
		return invertedHuePicture;
	}

	public Picture invertSaturation() {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture invertedSaturationPicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = invertedSaturationPicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = currentPixels[col][row].saturation(100 - currentPixels[col][row].getSaturation());
			}
		}
		invertedSaturationPicture.updateHSVToRGB(currentPixels);
		return invertedSaturationPicture;
	}

	public Picture invertValue() {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture invertedValuePicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = invertedValuePicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = currentPixels[col][row].value(100 - currentPixels[col][row].getValue());
			}
		}
		invertedValuePicture.updateHSVToRGB(currentPixels);
		return invertedValuePicture;
	}

	public Picture hsvEdgeDetection(int edgeDist) {
		HSVPixel pixel1 = null;
		HSVPixel pixel2 = null;
		HSVPixel[][] hsvPixels = this.getHSVPixels2DColumnMajor();
		Picture edges = new Picture(hsvPixels[0].length, hsvPixels.length);
		Pixel[][] edgePixels = edges.getPixels2DColumnMajor();
		for (int row = 0; row < hsvPixels[0].length; row++) {
			for (int col = 0; col < hsvPixels.length - 1; col++) {
				pixel1 = hsvPixels[col][row];
				pixel2 = hsvPixels[col + 1][row];
				if (Math.abs(pixel1.getHue() - pixel2.getHue()) > edgeDist)
					edgePixels[col][row].setColor(Color.WHITE);
				else
					edgePixels[col][row].setColor(Color.BLACK);
			}
		}
		for(int col = 0; col < hsvPixels.length; col++) {
			for (int row = 0; row< hsvPixels[0].length - 1; row++) {
				pixel1 = hsvPixels[col][row];
				pixel2 = hsvPixels[col][row  + 1];
				if (Math.abs(pixel1.getHue() - pixel2.getHue()) > edgeDist) {
					edgePixels[col][row].setColor(Color.WHITE);
				}
			}
		}
		return edges;
	}

	public Picture basicNoise() {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture noisyPicture = new Picture(currentPixels[0].length, currentPixels.length);
		Pixel[][] newPixels = noisyPicture.getPixels2DColumnMajor();
		Pixel tempPixel;

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {
				tempPixel = currentPixels[col][row];
				int red = tempPixel.getRed();
				int green = tempPixel.getGreen();
				int blue = tempPixel.getBlue();
				if(red > green && red > blue) {
					tempPixel.setRed(Math.min(255, (int) (red * 1.1)));
				}
				else if (green > blue) {
					tempPixel.setGreen(Math.min(255, (int) (green * 1.1)));
				}
				else {
					tempPixel.setBlue(Math.min(255, (int) (blue * 1.1)));
				}
				newPixels[col][row].setColor(tempPixel.getColor());
			}
		}

		return noisyPicture;
	}

	public Picture maxSaturation() {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture invertedSaturationPicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = invertedSaturationPicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = currentPixels[col][row].saturation(100);
			}
		}
		invertedSaturationPicture.updateHSVToRGB(currentPixels);
		return invertedSaturationPicture;
	}

	public Picture widenSaturation() {
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture invertedSaturationPicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = invertedSaturationPicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				newPixels[col][row] = currentPixels[col][row].saturation(currentPixels[col][row].getSaturation() + 15);
			}
		}
		invertedSaturationPicture.updateHSVToRGB(currentPixels);
		return invertedSaturationPicture;
	}

	public Picture vignette() {
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()/2;
		int avgRadius = (this.getWidth() + this.getHeight())/2;

		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture vignettePicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = vignettePicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				double dist = Math.sqrt( Math.pow((centerX - col), 2) + Math.pow((centerY - row), 2) );

				double brightness = currentPixels[col][row].getValue() * (avgRadius - dist)/avgRadius;

				newPixels[col][row] = currentPixels[col][row].value((float) brightness);
			}
		}
		vignettePicture.updateHSVToRGB(currentPixels);
		return vignettePicture;
	}

	public Picture vignette2() {
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()/2;
		int avgRadius = (this.getWidth() + this.getHeight())/2;

		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		Picture vignettePicture = new Picture(currentPixels[0].length, currentPixels.length);
		HSVPixel[][] newPixels = vignettePicture.getHSVPixels2DColumnMajor();
		for(int row = 0; row < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				double dist = Math.sqrt( Math.pow((centerX - col), 2) + Math.pow((centerY - row), 2) );

				int offset = Math.max(this.getWidth(), this.getHeight())/8;

				double brightness = currentPixels[col][row].getValue() * (avgRadius - dist - offset)/avgRadius;

				newPixels[col][row] = currentPixels[col][row].value((float) brightness);
			}
		}
		vignettePicture.updateHSVToRGB(currentPixels);
		return vignettePicture;
	}

	public Picture oldTimeyVignette() {
		return this.vignette2().sepia();
	}

	public Picture greenScreenHSV(float targetHue, Picture pullPicture) {

		Picture combinedPic = new Picture(getHeight(), getWidth());
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		HSVPixel[][] pullPixels = pullPicture.getHSVPixels2DColumnMajor();

		int maxRow = Math.min(getHeight(), pullPicture.getHeight());
		int maxCol = Math.min(getWidth(), pullPicture.getWidth());
		for(int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				if (Math.abs(pullPixels[col][row].getHue() - targetHue) < 20 && pullPixels[col][row].getValue() > 50) {
					continue;
				}
				else {
					currentPixels[col][row] = pullPixels[col][row];
				}
//				if(Math.abs(pullPixels[col][row].getHue() - targetHue) > 20 ) {
//					currentPixels[col][row] = pullPixels[col][row];
//				}
			}
		}
		combinedPic.updateHSVToRGB(currentPixels);
		return combinedPic;
	}

	public Picture greenScreenHSV2(int targetCol, int targetRow, Picture pullPicture) {

		if (targetCol < 0 || targetCol > pullPicture.getWidth() || targetRow < 0 || targetRow > pullPicture.getHeight()) {
			throw new ArrayIndexOutOfBoundsException("Provided Pixel is out of Bounds");
		}

		Picture combinedPic = new Picture(getHeight(), getWidth());
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		HSVPixel[][] pullPixels = pullPicture.getHSVPixels2DColumnMajor();

		HSVPixel targetPixel = pullPixels[targetCol][targetRow];

		int maxRow = Math.min(getHeight(), pullPicture.getHeight());
		int maxCol = Math.min(getWidth(), pullPicture.getWidth());
		for(int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				if (hsvInRange(currentPixels[col][row], targetPixel, 20)) {
					continue;
				}
				else {
					currentPixels[col][row] = pullPixels[col][row];
				}
			}
		}
		combinedPic.updateHSVToRGB(currentPixels);
		return combinedPic;
	}

	public Picture greenScreenHSV3(int targetCol, int targetRow, Picture pullPicture, int colOffset, int rowOffset) {

		if (targetCol < 0 || targetCol > pullPicture.getWidth() || targetRow < 0 || targetRow > pullPicture.getHeight()) {
			throw new ArrayIndexOutOfBoundsException("Provided Pixel is out of Bounds");
		}

		Picture combinedPic = new Picture(getHeight(), getWidth());
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		HSVPixel[][] pullPixels = pullPicture.getHSVPixels2DColumnMajor();

		HSVPixel targetPixel = pullPixels[targetCol][targetRow];

		int maxRow = Math.min(getHeight(), pullPicture.getHeight());
		int maxCol = Math.min(getWidth(), pullPicture.getWidth());
		for(int row = 0; row < maxRow && row + rowOffset < currentPixels[0].length; row++) {
			for (int col = 0; col < maxCol && col + colOffset < currentPixels.length; col++) {
				if (hsvInRange(pullPixels[col][row], targetPixel, 20)) {
					continue;
				}
				else {
					if (col + colOffset < 0 || row + rowOffset < 0) {
						continue;
					}
					currentPixels[col + colOffset][row + rowOffset] = pullPixels[col][row];
				}
			}
		}
		combinedPic.updateHSVToRGB(currentPixels);
		return combinedPic;
	}

	public Picture greenScreenHSV4(int targetCol, int targetRow, Picture pullPicture, int colOffset, int rowOffset) {

		if (targetCol < 0 || targetCol > pullPicture.getWidth() || targetRow < 0 || targetRow > pullPicture.getHeight()) {
			throw new ArrayIndexOutOfBoundsException("Provided Pixel is out of Bounds");
		}

		Picture combinedPic = new Picture(getHeight(), getWidth());
		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();
		HSVPixel[][] pullPixels = pullPicture.getHSVPixels2DColumnMajor();

		HSVPixel targetPixel = pullPixels[targetCol][targetRow];

		pullPixels = pullPicture.blackoutHSV(targetPixel).getHSVPixels2DColumnMajor();

		int maxRow = Math.min(getHeight(), pullPicture.getHeight());
		int maxCol = Math.min(getWidth(), pullPicture.getWidth());

		HSVPixel setPixel = new HSVPixel(130, 100, 100.0);
		setPixel = new HSVPixel(setPixel.getRGBColor());

		for(int row = 0; row < maxRow && row + rowOffset < currentPixels[0].length; row++) {
			for (int col = 0; col < maxCol && col + colOffset < currentPixels.length; col++) {

				if(!pullPixels[col][row].equals(setPixel)) {
					currentPixels[col + colOffset][row + rowOffset] = pullPixels[col][row];
				}

			}
		}
		combinedPic.updateHSVToRGB(currentPixels);
		return combinedPic;
	}

	/**
	 * Takes in a greenscreen photo and returns a photo with the greenscreen uniformly set to a rare pixel color
	 * @param targetPixel HSV color to remove
	 * @return a blacked out image
	 */
	public Picture blackoutHSV(HSVPixel targetPixel) {

		HSVPixel[][] currentPixels = this.getHSVPixels2DColumnMajor();

		HSVPixel setPixel = new HSVPixel(130, 100, 100.0);
		setPixel = new HSVPixel(setPixel.getRGBColor());

		// Intial pass to get most of the green screen
		for(int row = 0; row  < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {
				if (hsvInRange(currentPixels[col][row], targetPixel, 20)) {
					currentPixels[col][row] = setPixel;
				}
			}
		}

		boolean inObject = false;

		HSVPixel comparePixel = setPixel;

		//Find remaining Halo left to right
		for(int row = 0; row  < currentPixels[0].length; row++) {
			for (int col = 0; col < currentPixels.length; col++) {

				//moving into object
				if (!currentPixels[col][row].equals(comparePixel) && !inObject) {

					//do halo testing
					if (hsvInRange(currentPixels[col][row], targetPixel, 50)) {
						currentPixels[col][row] = setPixel;
					}
					inObject = true;
				}
				//moving out of object
				else if (inObject && currentPixels[col][row].equals(comparePixel)) {
					inObject = false;

					//make sure previous pixel is still in bounds then do halo testing
					if ((col - 1) > 0 && hsvInRange(currentPixels[col - 1][row], targetPixel, 50)) {
						currentPixels[col - 1][row] = setPixel;
					}
				}


			}
		}

		//Find remaining Halo top to bottom
		for(int col = 0; col  < currentPixels.length; col++) {
			for (int row = 0; row < currentPixels[0].length; row++) {

				//moving into object
				if (!currentPixels[col][row].equals(comparePixel) && !inObject) {

					//do halo testing
					if (hsvInRange(currentPixels[col][row], targetPixel, 50)) {
						currentPixels[col][row] = setPixel;
					}
					inObject = true;
				}
				//moving out of object
				else if (inObject && currentPixels[col][row].equals(comparePixel)) {
					inObject = false;

					//make sure previous pixel is still in bounds then do halo testing
					if ((row - 1) > 0 && hsvInRange(currentPixels[col][row - 1], targetPixel, 50)) {
						currentPixels[col][row - 1] = setPixel;
					}
				}


			}
		}

		Picture resPic = new Picture(getHeight(), getWidth());

		resPic.updateHSVToRGB(currentPixels);
		return resPic;

	}

	private boolean hsvInRange(HSVPixel pixel1, HSVPixel pixel2, int range) {
		return (Math.abs(pixel1.getHue() - pixel2.getHue()) < range &&
				Math.abs(pixel1.getValue() - pixel2.getValue()) < range &&
				Math.abs(pixel1.getSaturation() - pixel2.getSaturation()) < range);
	}


	private HSVPixel removeHalo(HSVPixel setPixel, int x, int y, HSVPixel[][] currentPixels) {

		HSVPixel[][] borderPixels = new HSVPixel[4][4];


		//This does work
		for (int row = -1; row < 3; row++)  {
			for (int col = -1; col < 3; col++) {
				int pullCol = Math.min(Math.max(0, x + col), getWidth() - 1);
				int pullRow = Math.min(Math.max(0, y + row), getHeight() - 1);

				borderPixels[1 + row][1 + col] = currentPixels[pullCol][pullRow];
			}
		}

		int count = 0;
		for(HSVPixel[] pixArr : borderPixels) {
			for (HSVPixel pixel : pixArr) {
				if(pixel.equals(setPixel)) {
					count++;
				}
			}
		}

		if(count >= 8) {
			return setPixel;
		}
		return currentPixels[x][y];

	}

	private double colorDistance(Color color1, Color color2)
	{
		double redDistance = color2.getRed() - color1.getRed();
		double greenDistance = color2.getGreen() - color1.getGreen();
		double blueDistance = color2.getBlue() - color1.getBlue();
		double distance = Math.sqrt(redDistance * redDistance +
				greenDistance * greenDistance +
				blueDistance * blueDistance);
		return distance;
	}

	@Deprecated
	public Picture basicGrayscaleToRGB() {

		Picture recoloredPic = new Picture(getHeight(), getWidth());
		Pixel[][] grayscalePixels = this.getPixels2DColumnMajor();
		Pixel[][] coloredPixels = recoloredPic.getPixels2DColumnMajor();

		double rWeight = .2126;
		double gWeight = .7152;
		double bWeight = .0722;


		for(int row = 0; row < grayscalePixels[0].length; row++) {
			for (int col = 0; col < coloredPixels.length; col++) {

				double grayValue = grayscalePixels[col][row].getRed();

//				System.out.println("Gray: " + grayValue + " GWeight * gray: " + (grayValue * .7152) + " BWeight * gray: " + (grayValue * .0722));


				int red = (int) ((grayValue - (grayValue * gWeight) - (grayValue * bWeight))/rWeight);
				int green = (int) ((grayValue - (grayValue * rWeight) - (grayValue * bWeight))/gWeight);
				int blue = (int) ((grayValue - (grayValue * gWeight) - (grayValue * rWeight))/bWeight);

//				System.out.println("Gray: " + grayValue + " Red: " + red + " Green: " + green + " Blue: " + blue);

				coloredPixels[col][row].setColor(new Color(red, green, blue));
			}
		}
		return recoloredPic;
	}

	@Deprecated
	public Picture weightedGrayscaleToRGB() {

		Picture recoloredPic = new Picture(getHeight(), getWidth());
		Pixel[][] grayscalePixels = this.getPixels2DColumnMajor();
		Pixel[][] coloredPixels = recoloredPic.getPixels2DColumnMajor();

		double mean = calculateMean(grayscalePixels);
		double stdDev = calculateStandardDeviation(grayscalePixels, mean);
		double skew = calculateSkew(grayscalePixels, mean, stdDev);

		System.out.println("Mean: " + mean + " Standard Deviation: " + stdDev + " Skew: " + skew);

		double rWeight;
		double gWeight;
		double bWeight;

		if (mean/255 > .3985 && skew > 0) {
			bWeight = skew * mean/255;
			gWeight = (1 - bWeight) - (mean/255 + stdDev/255);
			rWeight = 1 - (bWeight + gWeight);
		}
		else if(mean/255 < .3985 && skew > 0 && skew > .3 && stdDev/255 < .25) {
			rWeight = skew * mean/255;
			gWeight = (1 - rWeight) - (mean/255 + stdDev/255);
			bWeight = 1 - (rWeight + gWeight);
		}
		else if (mean/255 < .3985 && skew < .3 && stdDev/255 > .25 && skew < 0) {
			bWeight = skew * mean/255 * (2 * stdDev/255);
			gWeight = (1 - bWeight) - mean/255;
			rWeight = 1 - (bWeight + gWeight);
		}
		else {
			rWeight = .2126;
			gWeight = .7152;
			bWeight = .0722;
		}

		for(int row = 0; row < grayscalePixels[0].length; row++) {
			for (int col = 0; col < coloredPixels.length; col++) {

				double grayValue = grayscalePixels[col][row].getRed();

//				System.out.println("Gray: " + grayValue + " GWeight * gray: " + (grayValue * .7152) + " BWeight * gray: " + (grayValue * .0722));


				int red = (int) ((grayValue - (grayValue * gWeight) - (grayValue * bWeight))/rWeight);
				int green = (int) ((grayValue - (grayValue * rWeight) - (grayValue * bWeight))/gWeight);
				int blue = (int) ((grayValue - (grayValue * gWeight) - (grayValue * rWeight))/bWeight);

//				System.out.println("Gray: " + grayValue + " Red: " + red + " Green: " + green + " Blue: " + blue);

				coloredPixels[col][row].setColor(new Color(red, green, blue));
			}
		}
		return recoloredPic;
	}


	/**
	 *
	 * @param grayPixels A column major matrix of grayscaled pixels
	 * @return the mean (average) of all the pixel values
	 */
	@Deprecated
	private double calculateMean(Pixel[][] grayPixels) {
		double total = 0;

		for (int row = 0; row < grayPixels[0].length; row++) {
			for (int col = 0; col < grayPixels.length; col++) {
				total += grayPixels[col][row].getRed(); //sinces rgb should all be the same choosing red is arbitrary
			}
		}

		return total/(grayPixels[0].length * grayPixels.length);
	}

	@Deprecated
	private double calculateStandardDeviation(Pixel[][] grayPixels, double mean) {
		double sum = 0;

		int totalPixels = grayPixels[0].length * grayPixels.length;

		for (int row = 0; row < grayPixels[0].length; row++) {
			for (int col = 0; col < grayPixels.length; col++) {
				sum += Math.pow(grayPixels[col][row].getRed() - mean, 2); //sinces rgb should all be the same choosing red is arbitrary
			}
		}

		return Math.sqrt(sum/totalPixels);
	}

	@Deprecated
	private double calculateSkew(Pixel[][] grayPixels, double mean, double stdDev) {
		float sum = 0;

		int totalPixels = grayPixels[0].length * grayPixels.length;

		for (int row = 0; row < grayPixels[0].length; row++) {
			for (int col = 0; col < grayPixels.length; col++) {
				sum += Math.pow(grayPixels[col][row].getRed() - mean, 3); //sinces rgb should all be the same choosing red is arbitrary
			}
		}

		return  sum/(totalPixels * Math.pow(stdDev, 3));
	}

	public Picture invertCMYK() {

		Picture cmykInverse = new Picture(getHeight(), getWidth());
		CMYKPixel[][] currentPixels = this.getCMYKPixels2DColumnMajor();
		CMYKPixel[][] pixels = cmykInverse.getCMYKPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {

				CMYKPixel tempPixel = currentPixels[col][row];

				tempPixel.cyan(255 - tempPixel.getCyan())
						.magenta(255 - tempPixel.getMagenta())
						.yellow(255 - tempPixel.getYellow())
						.k(255 - tempPixel.getK());

				pixels[col][row] = tempPixel;
			}
		}

		cmykInverse.updateCMYKToRGB(pixels);

		return cmykInverse;
	}

	public Picture emptyCyan() {

		Picture emptyCyan = new Picture(getHeight(), getWidth());
		CMYKPixel[][] currentPixels = this.getCMYKPixels2DColumnMajor();
		CMYKPixel[][] pixels = emptyCyan.getCMYKPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {

				CMYKPixel tempPixel = currentPixels[col][row];

				tempPixel.cyan(0);

				pixels[col][row] = tempPixel;
			}
		}

		emptyCyan.updateCMYKToRGB(pixels);

		return emptyCyan;
	}

	public Picture emptyMagenta() {

		Picture emptyMagenta = new Picture(getHeight(), getWidth());
		CMYKPixel[][] currentPixels = this.getCMYKPixels2DColumnMajor();
		CMYKPixel[][] pixels = emptyMagenta.getCMYKPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {

				CMYKPixel tempPixel = currentPixels[col][row];

				tempPixel.magenta(0);

				pixels[col][row] = tempPixel;
			}
		}

		emptyMagenta.updateCMYKToRGB(pixels);

		return emptyMagenta;
	}

	public Picture emptyYellow() {

		Picture emptyYellow = new Picture(getHeight(), getWidth());
		CMYKPixel[][] currentPixels = this.getCMYKPixels2DColumnMajor();
		CMYKPixel[][] pixels = emptyYellow.getCMYKPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {

				CMYKPixel tempPixel = currentPixels[col][row];

				tempPixel.yellow(0);

				pixels[col][row] = tempPixel;
			}
		}

		emptyYellow.updateCMYKToRGB(pixels);

		return emptyYellow;
	}

	public Picture cmykDarken() {

		Picture darker = new Picture(getHeight(), getWidth());
		CMYKPixel[][] currentPixels = this.getCMYKPixels2DColumnMajor();
		CMYKPixel[][] pixels = darker.getCMYKPixels2DColumnMajor();

		for (int row = 0; row < pixels[0].length; row++) {
			for (int col = 0; col < pixels.length; col++) {

				CMYKPixel tempPixel = currentPixels[col][row];

				tempPixel.k(tempPixel.getK() + tempPixel.getK()/10);

				pixels[col][row] = tempPixel;
			}
		}

		darker.updateCMYKToRGB(pixels);

		return darker;
	}

	private double interpolate(double start, double end, double percent) {
		return (end - start) * percent + start;
	}

	private double[] interpolateRGB(double[] start, double[] end, double percent) {

		double rStart = start[0];
		double gStart = start[1];
		double bStart = start[2];

		double rEnd = end[0];
		double gEnd = end[1];
		double bEnd = end[2];

		double r = interpolate(rStart, rEnd, percent);
		double g = interpolate(gStart, gEnd, percent);
		double b = interpolate(bStart, bEnd, percent);

		return new double[]{r, g, b};

	}

	private Color nnInterpolation(Pixel[][] data, double x, double y){
		return data[(int) Math.floor(x)][(int) Math.floor(y)].getColor();
	}

	private Color bilinearInterpolation(Pixel[][] data, double x, double y) {

		//Gather my pixels
		int xStart = (int) Math.floor(x);
		int xEnd = xStart;
		if(xStart < getWidth() - 1) {
			xEnd = xStart + 1;
		}
		double xPercent = x - xStart;
		int yStart = (int) Math.floor(y);
		int yEnd = yStart;
		if(yStart < getHeight() - 1) {
			yEnd = yStart + 1;
		}
		double yPercent = y - yStart;

		Color topLeft = data[xStart][yStart].getColor();
		Color topRight = data[xEnd][yStart].getColor();
		Color bottomLeft = data[xStart][yEnd].getColor();
		Color bottomRight = data[xEnd][yEnd].getColor();

		//Interpolate across the top
		double[] top = interpolateRGB(
				new double[] {topLeft.getRed(), topLeft.getGreen(), topLeft.getBlue()},
				new double[] {topRight.getRed(), topRight.getGreen(), topRight.getBlue()},
				xPercent);

		//Interpolate across the bottom
		double[] bottom = interpolateRGB(
				new double[] {bottomLeft.getRed(), bottomLeft.getGreen(), bottomLeft.getBlue()},
				new double[] {bottomRight.getRed(), bottomRight.getGreen(), bottomRight.getBlue()},
				xPercent);

    	//Interpolate vertically
		double[] result = interpolateRGB(top, bottom, yPercent);

    	//Return the result
		Color resColor = new Color((int) Math.floor(result[0]), (int) Math.floor(result[1]), (int) Math.floor(result[2]));
		return resColor;

	}

	// Found this Stack overflow about cubic interpolation and deciced to use this instead. Just need to translate for
	// image processing and fix the errors he had in it.
	// https://stackoverflow.com/questions/34020143/java-2d-array-bicubic-interpolation

	// Also found this.
	// https://blog.demofox.org/2015/08/15/resizing-images-with-bicubic-interpolation/

	// And this
	// https://paulbourke.net/miscellaneous/interpolation/

	private double[] cubicInterpolate(double[][] pixels, double center)
	{

		double percent = center;
		int percentIntValue = (int) center;
		percent -= percentIntValue;

		double[] pointA = pixels[0];
		double[] pointB = pixels[1];
		double[] pointC = pixels[2];
		double[] pointD = pixels[3];

		double aRed = pointD[0] - pointC[0] - pointA[0] + pointB[0];
		double bRed = pointA[0] - pointB[0] - aRed;
		double cRed = pointC[0] - pointA[0];
		double dRed = pointB[0];

		double redFinal = (aRed * Math.pow(percent, 3)) + (bRed * Math.pow(percent, 2)) + (cRed * percent) + dRed;

		double aGreen = pointD[1] - pointC[1] - pointA[1] + pointB[1];
		double bGreen = pointA[1] - pointB[1] - aGreen;
		double cGreen = pointC[1] - pointA[1];
		double dGreen = pointB[1];

		double greenFinal = (aGreen * Math.pow(percent, 3)) + (bGreen * Math.pow(percent, 2)) + (cGreen * percent) + dGreen;

		double aBlue = pointD[2] - pointC[2] - pointA[2] + pointB[2];
		double bBlue = pointA[2] - pointB[2] - aBlue;
		double cBlue = pointC[2] - pointA[2];
		double dBlue = pointB[2];

		double blueFinal = (aBlue * Math.pow(percent, 3)) + (bBlue * Math.pow(percent, 2)) + (cBlue * percent) + dBlue;

//		System.out.println(String.format("Red: %3.3f Green: %3.3f Blue: %3.3f", redFinal, greenFinal, blueFinal));

		return new double[]{redFinal, greenFinal, blueFinal};
	}

	private double[] hermiteInterpolate(double[][] pixels, double center)
	{

		double percent = center;
		int percentIntValue = (int) center;
		percent -= percentIntValue;

		double[] pointA = pixels[0];
		double[] pointB = pixels[1];
		double[] pointC = pixels[2];
		double[] pointD = pixels[3];

		double aRed = -pointA[0] / 2.0 + (3.0*pointB[0]) / 2.0 - (3.0*pointC[0]) / 2.0 + pointD[0] / 2.0;
		double bRed = pointA[0] - (5.0*pointB[0]) / 2.0 + 2.0*pointC[0] - pointD[0] / 2.0;
		double cRed = -pointA[0] / 2.0 + pointC[0] / 2.0;
		double dRed = pointB[0];

		double redFinal = (aRed * Math.pow(percent, 3)) + (bRed * Math.pow(percent, 2)) + (cRed * percent) + dRed;

		double aGreen = -pointA[1] / 2.0 + (3.0*pointB[1]) / 2.0 - (3.0*pointC[1]) / 2.0 + pointD[1] / 2.0;
		double bGreen = pointA[1] - (5.0*pointB[1]) / 2.0 + 2.0*pointC[1] - pointD[1] / 2.0;
		double cGreen = -pointA[1] / 2.0 + pointC[1] / 2.0;
		double dGreen = pointB[1];

		double greenFinal = (aGreen * Math.pow(percent, 3)) + (bGreen * Math.pow(percent, 2)) + (cGreen * percent) + dGreen;

		double aBlue = -pointA[2] / 2.0 + (3.0*pointB[2]) / 2.0 - (3.0*pointC[2]) / 2.0 + pointD[2] / 2.0;
		double bBlue = pointA[2] - (5.0*pointB[2]) / 2.0 + 2.0*pointC[2] - pointD[2] / 2.0;
		double cBlue = -pointA[2] / 2.0 + pointC[2] / 2.0;
		double dBlue = pointB[2];

		double blueFinal = (aBlue * Math.pow(percent, 3)) + (bBlue * Math.pow(percent, 2)) + (cBlue * percent) + dBlue;

//		System.out.println(String.format("Red: %3.3f Green: %3.3f Blue: %3.3f", redFinal, greenFinal, blueFinal));

		return new double[]{redFinal, greenFinal, blueFinal};
	}

	private int correctToInBoundsCol(int col) {
		return Math.max(0, Math.min(col, getWidth() -1));
	}

	private int correctToInBoundsRow(int row) {
		return Math.max(0, Math.min(row, getHeight() -1));
	}

	private double[][][] setUpArray(int x, int y, Pixel[][] currentPixels) {
		double[][][] bicubicArray = new double[4][4][3];


		//First Row

		//First Pixel
		bicubicArray[0][0][0] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y - 1)].getRed();
		bicubicArray[0][0][1] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y - 1)].getGreen();
		bicubicArray[0][0][2] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y - 1)].getBlue();

		//Second Pixel
		bicubicArray[0][1][0] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y - 1)].getRed();
		bicubicArray[0][1][1] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y - 1)].getGreen();
		bicubicArray[0][1][2] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y - 1)].getBlue();

		//Third Pixel
		bicubicArray[0][2][0] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y - 1)].getRed();
		bicubicArray[0][2][1] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y - 1)].getGreen();
		bicubicArray[0][2][2] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y - 1)].getBlue();

		//Fourth Pixel
		bicubicArray[0][3][0] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y - 1)].getRed();
		bicubicArray[0][3][1] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y - 1)].getGreen();
		bicubicArray[0][3][2] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y - 1)].getBlue();


		//Second Row
		bicubicArray[1][0][0] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y)].getRed();
		bicubicArray[1][0][1] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y)].getGreen();
		bicubicArray[1][0][2] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y)].getBlue();

		bicubicArray[1][1][0] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y)].getRed();
		bicubicArray[1][1][1] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y)].getGreen();
		bicubicArray[1][1][2] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y)].getBlue();

		bicubicArray[1][2][0] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y)].getRed();
		bicubicArray[1][2][1] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y)].getGreen();
		bicubicArray[1][2][2] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y)].getBlue();

		bicubicArray[1][3][0] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y)].getRed();
		bicubicArray[1][3][1] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y)].getGreen();
		bicubicArray[1][3][2] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y)].getBlue();


		//Third Row
		bicubicArray[2][0][0] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 1)].getRed();
		bicubicArray[2][0][1] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 1)].getGreen();
		bicubicArray[2][0][2] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 1)].getBlue();

		bicubicArray[2][1][0] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 1)].getRed();
		bicubicArray[2][1][1] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 1)].getGreen();
		bicubicArray[2][1][2] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 1)].getBlue();

		bicubicArray[2][2][0] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 1)].getRed();
		bicubicArray[2][2][1] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 1)].getGreen();
		bicubicArray[2][2][2] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 1)].getBlue();

		bicubicArray[2][3][0] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 1)].getRed();
		bicubicArray[2][3][1] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 1)].getGreen();
		bicubicArray[2][3][2] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 1)].getBlue();


		//Fourth Row
		bicubicArray[3][0][0] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 2)].getRed();
		bicubicArray[3][0][1] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 2)].getGreen();
		bicubicArray[3][0][2] = currentPixels[correctToInBoundsCol(x - 1)][correctToInBoundsRow(y + 2)].getBlue();

		bicubicArray[3][1][0] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 2)].getRed();
		bicubicArray[3][1][1] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 2)].getGreen();
		bicubicArray[3][1][2] = currentPixels[correctToInBoundsCol(x)][correctToInBoundsRow(y + 2)].getBlue();

		bicubicArray[3][2][0] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 2)].getRed();
		bicubicArray[3][2][1] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 2)].getGreen();
		bicubicArray[3][2][2] = currentPixels[correctToInBoundsCol(x + 1)][correctToInBoundsRow(y + 2)].getBlue();

		bicubicArray[3][3][0] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 2)].getRed();
		bicubicArray[3][3][1] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 2)].getGreen();
		bicubicArray[3][3][2] = currentPixels[correctToInBoundsCol(x + 2)][correctToInBoundsRow(y + 2)].getBlue();


		return bicubicArray;
	}

	private double[] biHermiteInterpolate(double x, double y, Pixel[][] currentPixels)
	{
		double[][][] bicubicArray = new double[4][4][3];

		int intX = (int) x;
		int intY = (int) y;

//		bicubicArray = setUpArray(intX, intY, currentPixels);


		//This doesn't work
//		for (int row = -1; row < 3; row++)  {
//			for (int col = -1; col < 3; col++) {
//				int pullCol = (int) Math.min(Math.max(0, x + col), getWidth() - 1);
//				int pullRow = (int) Math.min(Math.max(0, y + row), getHeight() - 1);
//
//				Pixel pullPixel = currentPixels[pullCol][pullRow];
//
//				bicubicArray[1 + col][1 + row][0] = pullPixel.getRed();
//				bicubicArray[1 + col][1 + row][1] = pullPixel.getGreen();
//				bicubicArray[1 + col][1 + row][2] = pullPixel.getBlue();
// 			}
//		}


		//This does work
		for (int row = -1; row < 3; row++)  {
			for (int col = -1; col < 3; col++) {
				int pullCol = (int) Math.min(Math.max(0, x + col), getWidth() - 1);
				int pullRow = (int) Math.min(Math.max(0, y + row), getHeight() - 1);

				Pixel pullPixel = currentPixels[pullCol][pullRow];

				bicubicArray[1 + row][1 + col][0] = pullPixel.getRed();
				bicubicArray[1 + row][1 + col][1] = pullPixel.getGreen();
				bicubicArray[1 + row][1 + col][2] = pullPixel.getBlue();
 			}
		}

		double[] beforePoint1 = hermiteInterpolate(bicubicArray[0], x);
		double[] point1 = hermiteInterpolate(bicubicArray[1], x);
		double[] point2 = hermiteInterpolate(bicubicArray[2], x);
		double[] afterPoint2 = hermiteInterpolate(bicubicArray[3], x);

		return hermiteInterpolate(new double[][]{beforePoint1, point1, point2, afterPoint2}, y);
	}

	private double[] bicubicInterpolate(double x, double y, Pixel[][] currentPixels)
	{
		double[][][] bicubicArray = new double[4][4][3];

		int intX = (int) x;
		int intY = (int) y;

		bicubicArray = setUpArray(intX, intY, currentPixels);


		//This doesn't work
//		for (int row = -1; row < 3; row++)  {
//			for (int col = -1; col < 3; col++) {
//				int pullCol = (int) Math.min(Math.max(0, x + col), getWidth() - 1);
//				int pullRow = (int) Math.min(Math.max(0, y + row), getHeight() - 1);
//
//				Pixel pullPixel = currentPixels[pullCol][pullRow];
//
//				bicubicArray[1 + col][1 + row][0] = pullPixel.getRed();
//				bicubicArray[1 + col][1 + row][1] = pullPixel.getGreen();
//				bicubicArray[1 + col][1 + row][2] = pullPixel.getBlue();
// 			}
//		}


		//This does work
		for (int row = -1; row < 3; row++)  {
			for (int col = -1; col < 3; col++) {
				int pullCol = (int) Math.min(Math.max(0, x + col), getWidth() - 1);
				int pullRow = (int) Math.min(Math.max(0, y + row), getHeight() - 1);

				Pixel pullPixel = currentPixels[pullCol][pullRow];

				bicubicArray[1 + row][1 + col][0] = pullPixel.getRed();
				bicubicArray[1 + row][1 + col][1] = pullPixel.getGreen();
				bicubicArray[1 + row][1 + col][2] = pullPixel.getBlue();
			}
		}

		double[] beforePoint1 = cubicInterpolate(bicubicArray[0], x);
		double[] point1 = cubicInterpolate(bicubicArray[1], x);
		double[] point2 = cubicInterpolate(bicubicArray[2], x);
		double[] afterPoint2 = cubicInterpolate(bicubicArray[3], x);

		return cubicInterpolate(new double[][]{beforePoint1, point1, point2, afterPoint2}, y);
	}

	public Picture hermiteInterpolationScale(double ratio) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture((int) (getHeight() * ratio), (int) (getWidth() * ratio));
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {

				double[] cubicInterpolated = biHermiteInterpolate(col/ratio, row/ratio, currentPixels);

				newPixels[col][row].setColor(new Color(correctDoubleToIntForRGB(cubicInterpolated[0]), correctDoubleToIntForRGB(cubicInterpolated[1]), correctDoubleToIntForRGB(cubicInterpolated[2])));
			}
		}


		return scaledPicture;
	}

	public Picture bicubicInterpolationScale(double ratio) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture((int) (getHeight() * ratio), (int) (getWidth() * ratio));
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {

				double[] cubicInterpolated = bicubicInterpolate(col/ratio, row/ratio, currentPixels);

				newPixels[col][row].setColor(new Color(correctDoubleToIntForRGB(cubicInterpolated[0]), correctDoubleToIntForRGB(cubicInterpolated[1]), correctDoubleToIntForRGB(cubicInterpolated[2])));
			}
		}


		return scaledPicture;
	}

	public Picture linearInterpolationScale(double ratio) {
		Pixel[][] currentPixels = this.getPixels2DColumnMajor();
		Picture scaledPicture = new Picture((int) (getHeight() * ratio), (int) (getWidth() * ratio));
		Pixel[][] newPixels = scaledPicture.getPixels2DColumnMajor();

		for(int row = 0; row < newPixels[0].length; row++) {
			for (int col = 0; col < newPixels.length; col++) {

				Color linearInterplated = bilinearInterpolation(currentPixels, col/ratio, row/ratio);

				newPixels[col][row].setColor(linearInterplated);
			}
		}


		return scaledPicture;
	}

	private int correctDoubleToIntForRGB(double rgbInt) {
		int rgb = (int) Math.round(rgbInt);

		return Math.max(0, Math.min(rgb, 255));
	}

	public Picture pictureDiff(Picture picture2) {

		if(getWidth() != picture2.getWidth() || getHeight() != picture2.getHeight()) {
			throw new IndexOutOfBoundsException("Pictures are not the same size");
		}

		Pixel[][] pixels1 = getPixels2DColumnMajor();
		Pixel[][] pixels2 = picture2.getPixels2DColumnMajor();

		for(int row = 0; row < pixels1[0].length; row++) {
			for (int col = 0; col < pixels1.length; col++) {

				int newRed = Math.abs(pixels1[col][row].getRed() - pixels2[col][row].getRed());
				int newGreen = Math.abs(pixels1[col][row].getGreen() - pixels2[col][row].getGreen());
				int newBlue = Math.abs(pixels1[col][row].getBlue() - pixels2[col][row].getBlue());

				pixels2[col][row].setColor(new Color(newRed, newGreen, newBlue));
			}
		}

		return picture2;
	}





} // this } is the end of class Picture, put all new methods before this


