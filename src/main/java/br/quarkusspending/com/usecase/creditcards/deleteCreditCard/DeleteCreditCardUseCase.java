package br.quarkusspending.com.usecase.creditcards.deleteCreditCard;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.dto.creditcard.DeletedCreditCardDTO;
import br.quarkusspending.com.enums.CreditCardStatusEnum;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.repository.CreditCardRepository;

@ApplicationScoped
public class DeleteCreditCardUseCase implements IDeleteCreditCardUseCase {
    
    @Inject CreditCardRepository creditCardRepository;

    @Override
    @Transactional
    public DeletedCreditCardDTO deleteCreditCard(Integer userId, Integer cardId) {
        try {
            Optional<CreditCard> creditCardOp = creditCardRepository.findCreditCardByUserAndCardId(userId, cardId);
            if(creditCardOp.isPresent()){
                CreditCard creditCard = creditCardOp.get();
                creditCard.setDeletedAt(LocalDateTime.now());
                creditCard.setStatus(CreditCardStatusEnum.DELETED);
                creditCardRepository.persist(creditCard);
                return DeletedCreditCardDTO.fromModel(creditCard);
            }else{
                throw new MessageExceptions("Não foi possível encontrar o cartão de crédito", 404);
            }
            
        } catch (Exception e) {
            throw new MessageExceptions(e.getMessage(), 500);
        }
    }
}
