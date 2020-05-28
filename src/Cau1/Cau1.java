package Cau1;

public class Cau1 {
	public String wordCorrect(String s) {
		s = s.trim();
		while (s.indexOf("  ") != -1) {
			s = s.replaceAll("  ", " ");
		}
		String kiTuDau = String.valueOf(s.charAt(0));
		kiTuDau = kiTuDau.toUpperCase();
		char[] arr = kiTuDau.toCharArray();
		s = s.replace(s.charAt(0), arr[0]);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				String inHoa = String.valueOf(s.charAt(i + 1));
				inHoa = inHoa.toUpperCase();
				char[] arrr = inHoa.toCharArray();
				s = s.replace(s.charAt(i + 1), arrr[0]);
			}
		}

		return s;
	}

	public static void main(String[] args) {
		Cau1 test = new Cau1();
		System.out.println(test.wordCorrect("huynh  van vien"));
	}
}
