package br.quarkusspending.com.dto.creditcard;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.model.Users;

public class ResponseCreditCardDTO {
    private String nameCard;
    private String name;
    private String agency;
    private String account;
    private LocalDate validity;
    private String cardNumber;
    private Integer cvv;
    private Double limit;
    private Users users;

    public static ResponseCreditCardDTO fromModel(CreditCard card){
        ModelMapper modelMapper = new ModelMapper();
        ResponseCreditCardDTO responseCreditCardDTO = modelMapper.map(card, ResponseCreditCardDTO.class);
        return responseCreditCardDTO;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
}
