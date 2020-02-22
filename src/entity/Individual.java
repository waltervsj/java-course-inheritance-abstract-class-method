package entity;

public class Individual extends Payer {
	private Double healthExpenditures;
	
	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxPaid() {
		Double taxPercentage = this.getAnualIncome() < 20000 ? 0.15 : 0.25;
		return this.getAnualIncome() * taxPercentage - this.healthExpenditures * 0.5;
	}
}
