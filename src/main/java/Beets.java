public class Beets extends Vegetable {

	public Beets() {
		super(Color.ORANGE, 0.000025, 0.0039, 26);
	}

	@Override
	protected void grow(double luxAmount, double rainDensity, int daysAmount) {
		this.checkStatus(rainDensity, daysAmount);
		this.increaseSize(luxAmount * this.getSUN_GROWING_RATIO_PER_LUX());
		this.increaseSize(rainDensity * this.getRAIN_GROWING_RATIO_PER_MM());
		this.checkIfReady();
	}

	private void checkStatus(double rainDensity, int daysAmount) {
		if (!this.isRainSufficient(rainDensity, 19, daysAmount, 6)) {
			this.status = Status.DAMAGED;
		}
	}
}
