package br.quarkusspending.com.dto;

import org.modelmapper.ModelMapper;

import br.quarkusspending.com.model.Users;

public class ResponseUserDTO {
    
    private String name;
    private String cpf;
    private Integer year;
    private String email;
    private Double income;
    private String password;

    public static ResponseUserDTO fromModel(Users users){
        ModelMapper modelMapper = new ModelMapper();
        ResponseUserDTO responseUserDTO = modelMapper.map(users, ResponseUserDTO.class);
        return responseUserDTO;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
