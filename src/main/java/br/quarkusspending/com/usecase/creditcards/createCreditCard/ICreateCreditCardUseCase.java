package br.quarkusspending.com.usecase.creditcards.createCreditCard;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.creditcard.RequestCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.ResponseCreditCardDTO;

@ApplicationScoped
public interface ICreateCreditCardUseCase {
    public ResponseCreditCardDTO createCreditCardByUser(int userId, RequestCreditCardDTO responseCreditCardDTO);
}
