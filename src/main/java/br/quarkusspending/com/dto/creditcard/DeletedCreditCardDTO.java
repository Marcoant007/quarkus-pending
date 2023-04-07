package br.quarkusspending.com.dto.creditcard;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import br.quarkusspending.com.enums.CreditCardStatusEnum;
import br.quarkusspending.com.model.CreditCard;

public class DeletedCreditCardDTO {

    private String nameCard;
    private LocalDate validity;
    private String cardNumber;
    private Double limit;
    private CreditCardStatusEnum status;
    private LocalDateTime deletedAt;

    public static DeletedCreditCardDTO fromModel(CreditCard card){
        ModelMapper modelMapper = new ModelMapper();
        DeletedCreditCardDTO deletedCreditCardDTO = modelMapper.map(card, DeletedCreditCardDTO.class);
        return deletedCreditCardDTO;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
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

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public CreditCardStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CreditCardStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    
}
