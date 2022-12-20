public abstract class Vegetable {
	protected final double SUN_GROWING_RATIO_PER_LUX;
	protected final double RAIN_GROWING_RATIO_PER_MM;
	protected final double READY_AMOUNT_CM;

	protected double size;
	protected Color color;
	protected Status status;

	public Vegetable(Color color, double sunGrowingRatio, double rainGrowingRatio, double readyAmountCM) {
		this.color = color;
		this.SUN_GROWING_RATIO_PER_LUX = sunGrowingRatio;
		this.RAIN_GROWING_RATIO_PER_MM = rainGrowingRatio;
		this.READY_AMOUNT_CM = readyAmountCM;
	}

	public Vegetable(Color color, double sunGrowingRatio, double rainGrowingRatio, double readyAmountCM, double size) {
		this.color = color;
		this.SUN_GROWING_RATIO_PER_LUX = sunGrowingRatio;
		this.RAIN_GROWING_RATIO_PER_MM = rainGrowingRatio;
		this.READY_AMOUNT_CM = readyAmountCM;
		this.size = size;
		this.status = Status.GROWING;
	}

	public double getSUN_GROWING_RATIO_PER_LUX() {
		return this.SUN_GROWING_RATIO_PER_LUX;
	}

	public double getRAIN_GROWING_RATIO_PER_MM() {
		return this.RAIN_GROWING_RATIO_PER_MM;
	}

	public double getREADY_AMOUNT_CM() {
		return this.READY_AMOUNT_CM;
	}

	public double getSize() {
		return this.size;
	}

	public void increaseSize(double value) {
		if (value > 0) {
			this.size += value;
		}
	}

	public Color getColor() {
		return this.color;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		if (status.equals(Status.READY_FOR_HARVESTING)) {
			if (this.size >= this.READY_AMOUNT_CM) {
				this.status = status;
			} else {
//				throw new RuntimeException("The vegetable is not big enough to be ready!");
				this.status = Status.GROWING;
			}
		} else {
			this.status = status;
		}
	}

	protected abstract void grow(double luxAmount, double rainDensity, int daysAmount);

	protected void checkIfReady() {
		if (this.getSize() >= this.getREADY_AMOUNT_CM()) {
			this.setStatus(Status.READY_FOR_HARVESTING);
		}
	}

	/**
	 * The method will return if the given rain density in mm was sufficient for 'x' number of days
	 * Example: if rain density has to be 19mm within 6 days then:
	 * 12 days and 35 mm -> False (the mm has to be higher or equal than 38)
	 *
	 * @param rainDensity               The actual rain density
	 * @param rainDensityToCheckAgainst The rain density that is sufficient
	 * @param daysAmount                The actual days that passed
	 * @param dayToCheckAgainst         The threshold amount of days for the rain density that is sufficient
	 * @return True if the rain density is enough for the amount of days passed, False otherwise
	 */
	protected boolean isRainSufficient(double rainDensity, double rainDensityToCheckAgainst, int daysAmount, int dayToCheckAgainst) {
		return rainDensity >= rainDensityToCheckAgainst * Math.floor(daysAmount / dayToCheckAgainst);
	}
}
