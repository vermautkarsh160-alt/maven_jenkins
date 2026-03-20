package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_Utility {

    public static int generateRanNum() {
        int random = (int) (Math.random() * 9999);
        return random;
    }

    static String getTodaysDateAndTime() {

        // 17022026_151130
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public static void main(String[] args) {
        String orgName = "qspiders_" + generateRanNum();
        System.out.println(orgName);

        String dateTime = getTodaysDateAndTime();
        System.out.println(dateTime);
    }

	public String randomString(int i) {
		// TODO Auto-generated method stub
		return java.util.UUID.randomUUID().toString().replace("=", "").substring(i);
	}
}
