package br.quarkusspending.com.usecase.creditcards.findCreditCard;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.CreditCard;

@ApplicationScoped
public interface IFindCreditCardByUserUseCase {
    public List<CreditCard> findCreditCardByUser(int userId);
}
