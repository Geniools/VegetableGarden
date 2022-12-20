public class Pineapple extends Vegetable {

	public Pineapple() {
		super(Color.YELLOW, 0.000078, 0.0041, 13);
	}

	@Override
	protected void grow(double luxAmount, double rainDensity, int daysAmount) {
		if (isRainSufficient(rainDensity, 44, daysAmount, 6)) {
			return;
		}
		
		this.increaseSize(luxAmount * this.getSUN_GROWING_RATIO_PER_LUX());
		this.increaseSize(rainDensity * this.getRAIN_GROWING_RATIO_PER_MM());
		this.checkIfReady();
	}
}
