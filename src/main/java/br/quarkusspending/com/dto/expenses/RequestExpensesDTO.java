package br.quarkusspending.com.dto.expenses;

public class RequestExpensesDTO {
    
    private boolean fixed;
    private String name;
    private String company;
    private double value;

    public boolean isFixed() {
        return fixed;
    }
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
