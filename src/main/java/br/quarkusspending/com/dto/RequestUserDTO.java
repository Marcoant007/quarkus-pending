package br.quarkusspending.com.dto;

public class RequestUserDTO {
    private String name;
    private String cpf;
    private String password;
    private Integer year;
    private String email;
    private Double income;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getIncome() {
        return income;
    }
    public void setIncome(Double income) {
        this.income = income;
    }

    
}