public class Cabbage extends Vegetable {

	public Cabbage() {
		super(Color.GREEN, 0.0098, 0.038, 13);
	}

	@Override
	protected void grow(double luxAmount, double rainDensity, int daysAmount) {
		this.checkStatus(rainDensity, daysAmount);
		if (luxAmount < 8499) {
			return;
		}
		
		this.increaseSize(luxAmount * this.getSUN_GROWING_RATIO_PER_LUX());
		this.increaseSize(rainDensity * this.getRAIN_GROWING_RATIO_PER_MM());
		this.checkIfReady();
	}

	private void checkStatus(double rainDensity, int daysAmount) {
		if (this.isRainSufficient(rainDensity, 36, daysAmount, 7)) {
			this.status = Status.DAMAGED;
		}
	}
}
