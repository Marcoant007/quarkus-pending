package br.quarkusspending.com.usecase.creditcards.deleteCreditCard;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.creditcard.DeletedCreditCardDTO;

@ApplicationScoped
public interface IDeleteCreditCardUseCase {
    public DeletedCreditCardDTO deleteCreditCard(Integer userId, Integer cardId);
}
