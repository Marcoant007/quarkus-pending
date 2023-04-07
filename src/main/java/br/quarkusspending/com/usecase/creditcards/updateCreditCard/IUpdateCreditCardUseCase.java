package br.quarkusspending.com.usecase.creditcards.updateCreditCard;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.creditcard.RequestCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.ResponseCreditCardDTO;

@ApplicationScoped
public interface IUpdateCreditCardUseCase {
    public ResponseCreditCardDTO updateCreditCard(Integer userId, Integer cardId, RequestCreditCardDTO requestCreditCardDTO);
}
