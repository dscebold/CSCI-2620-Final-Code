package ProjectFiles;

import java.net.URISyntaxException;

public class ChromaRunner {

	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		ChromaKey floop = new ChromaKey();
//		floop.green1test();
//		floop.green2test();
//		floop.green3test();
//		Picture encodedPic = floop.easyStego("images/rickRoll.png", "easyEncodedRick.png");
//		System.out.println(floop.decodeEasy(encodedPic));
		floop.hardStego("images/rickRoll.png", "hardEncodedRick.png");
		System.out.println(floop.decodeHard("images/hardEncodedRick.png"));
	}

}
