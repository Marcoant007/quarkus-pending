package br.quarkusspending.com.usecase.creditcards.findCreditCard;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.repository.CreditCardRepository;

@ApplicationScoped
public class FindCreditCardByUserUseCase implements IFindCreditCardByUserUseCase {

    @Inject CreditCardRepository creditCardRepository;

    @Override
    public List<CreditCard> findCreditCardByUser(int userId) {
        return creditCardRepository.findCreditCardByUser(userId);
    }
    
}
