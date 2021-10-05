public class proxecto {

	public static void main(String[] args) {

		System.out.println(getDurationString(65,45));
		System.out.println(getDurationString(3945));
		
	}

	private static String getDurationString(int min, int sec) {

		if ((min >= 0) && (sec >= 0 && sec <= 59)) {

			int hours = min / 60;
			int remainingMinutes = min % 60;
			return hours + "h " + remainingMinutes + "m " + sec + "s ";

		} else {
			return "Invalid value";
		}

	}

	private static String getDurationString(int sec) {

		if (sec >= 0) {

			int min = sec / 60;
			int remainingSeconds = sec % 60;
			return getDurationString(min, remainingSeconds);
		} else {
			return "Invalid value";
		}

	}

}
