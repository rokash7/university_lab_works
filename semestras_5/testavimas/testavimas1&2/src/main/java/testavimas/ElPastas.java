package testavimas;

import java.util.Calendar;
import java.util.Random;

public class ElPastas {

	public String elPastas()
	{
		String email = "robotas.policininkas@gmail.com";
		
		Random random = new Random();
		int x = random.nextInt(1000000000)*Calendar.SECOND*Calendar.MILLISECOND/1000;
		
		email = "robocop" + x + Calendar.SECOND + Calendar.MILLISECOND + "@gmail.com";
		
		return email;
	}
	
}
