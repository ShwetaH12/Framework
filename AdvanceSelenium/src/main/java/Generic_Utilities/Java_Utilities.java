package Generic_Utilities;

import java.util.Random;

public class Java_Utilities {

	/*
	 * this method is used to avoid duplicate names
	 * shweta
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranInt = ran.nextInt(1000);
		return ranInt;
	}
}
