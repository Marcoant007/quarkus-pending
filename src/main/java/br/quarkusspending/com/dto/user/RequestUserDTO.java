package br.quarkusspending.com.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import br.quarkusspending.com.enums.ProfileEnum;

public class RequestUserDTO {
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String cpf;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private Integer year;
    
    @Email
    private String email;
    
    @Positive
    private Double income;
    
    @NotEmpty
    private ProfileEnum profile;

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
    public ProfileEnum getProfile() {
        return profile;
    }
    public void setProfile(ProfileEnum profileEnum) {
        this.profile = profileEnum;
    }

}
