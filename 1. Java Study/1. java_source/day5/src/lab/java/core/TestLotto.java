package lab.java.core;

public class TestLotto {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		int[] lottoNumbers = lotto.generateLottoNumbers();
		lotto.sortLottoNumbers(lottoNumbers);
		lotto.displayLottoNumbers(lottoNumbers);

	}

}
