package ProjectFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChromaKey {
	private Scanner scan;
	private File file;
	private PrintWriter write;
	private String read, allText;

	private ClassLoader classLoader;

	public ChromaKey() throws URISyntaxException {
		classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("textFiles/rick.txt").toURI());
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		allText = "";
		while (scan.hasNextLine()) {
			String temp = scan.nextLine();
			allText += temp + "\n";
		}
		allText = allText + "~~~";
	}

	public void green1test() {
		Picture pic = new Picture("images/dDay.png");
		Picture grev = new Picture("images/nolightsaberGrevious1.png");
		// pic.explore();
		// grev.explore();
		pic.getGreen(grev);
		pic.grayscale();
		pic.explore();
	}

	public void green2test() {
		Picture pic2 = new Picture("images/endgame.png");
		Picture grev = new Picture("images/lightsaberGrevious1.png");
		pic2 = pic2.scale(3.5, 3.5);
//		pic2.explore();
//		grev.explore();
		grev = grev.scale(3, 3);
		grev.setPink();
//		grev.reColor(); 
//		grev.explore();
//		grev.lightUp();
//		grev.explore();
		pic2.getGreen1(grev);
//		pic.explore();
//		pic.Grayscale();
		pic2.lightsaber();
		pic2.explore();
	}

	public void green3test() {
		Picture pic = new Picture("images/sfSkyline.png");
		Picture death = new Picture("images/deathStar.png");
		pic = pic.scale(1.1603011583, 1.1603011583);
		// pic.explore();
		pic.getStar(death);
		pic.explore();
	}

	public String decodeEasy(String encodedPic) {
		String last = "";
		Picture pic = new Picture(encodedPic);
		ArrayList<String> rewrite = pic.getEasyNums();
		for (String text : rewrite) {
			last += text;
		}
		return last;
	}

	public String decodeEasy(Picture encodedPic) {
		String last = "";
        ArrayList<String> rewrite = encodedPic.getEasyNums();
		for (String text : rewrite) {
			last += text;
		}
		return last;
	}
	
	public String decodeHard(Picture encodedPict) {
		String last = "";
        ArrayList<String> rewrite = encodedPict.getHardNums();
		for (String text : rewrite) {
			last += text;
		}
		return last;
	}
	
	public String decodeHard(String encodedPict) {
		StringBuilder last = new StringBuilder();
		Picture pic = new Picture(encodedPict);
		ArrayList<String> rewrite = pic.getHardNums();
		for (String text : rewrite) {
			last.append(text);
		}
		return last.toString();
	}

	public Picture easyStego(String pict, String encodedName) {
		int[] words = new int[allText.length()];
		String temp = "";
		int hold = 0;
		Picture pic = new Picture(pict);
		pic = pic.scale(5, 5);
		for (int i = 0; i < allText.length(); i++) {
			temp = Integer.toBinaryString(allText.charAt(i));
			temp = String.format("%8s", temp).replace(' ', '0');
			hold = Integer.parseInt(temp, 2);
			words[i] = hold;
		}
		pic.hideEasyStego(words);
		try {
			pic.writeOrFail("images/" + encodedName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pic;
	}

	public Picture hardStego(String pict, String encodedName) {
		Picture encodePic = new Picture(pict);
		String hold = "";
		ArrayList<Character> bins = new ArrayList<>();
		for (int i = 0; i < allText.length(); i++) {
			hold = Integer.toBinaryString(allText.charAt(i));
			hold = String.format("%8s", hold).replace(' ', '0');
			for(int j = 0; j < hold.length(); j++) {
				bins.add(hold.charAt(j));
			}
		}
		encodePic.hideHardStego(bins);
		try {
			encodePic.writeOrFail("images/" + encodedName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encodePic;
	}

}
