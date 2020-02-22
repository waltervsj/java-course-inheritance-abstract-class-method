package entity;

public class Company extends Payer {
	private Integer numberOfEmployees;
	
	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	@Override
	public Double taxPaid() {
		Double taxPercentage = this.numberOfEmployees > 10 ? 0.14 : 0.16;
		return this.getAnualIncome() * taxPercentage;
	}
}
