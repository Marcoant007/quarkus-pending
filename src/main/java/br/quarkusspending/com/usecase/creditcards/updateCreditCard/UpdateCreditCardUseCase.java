package br.quarkusspending.com.usecase.creditcards.updateCreditCard;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.dto.creditcard.RequestCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.ResponseCreditCardDTO;
import br.quarkusspending.com.enums.CreditCardStatusEnum;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.repository.CreditCardRepository;

@ApplicationScoped
public class UpdateCreditCardUseCase implements IUpdateCreditCardUseCase{

    @Inject CreditCardRepository creditCardRepository;

    @Override
    @Transactional
    public ResponseCreditCardDTO updateCreditCard(Integer userId, Integer cardId, RequestCreditCardDTO requestCreditCardDTO) {
        try {
            Optional<CreditCard> creditCardOp = creditCardRepository.findCreditCardByUserAndCardId(userId, cardId);
            if(creditCardOp.isPresent()){
                CreditCard creditCard =  creditCardOp.get();
                creditCard.setAccount(requestCreditCardDTO.getAccount());
                creditCard.setAgency(requestCreditCardDTO.getAgency());
                creditCard.setCardNumber(requestCreditCardDTO.getCardNumber());
                creditCard.setCvv(requestCreditCardDTO.getCvv());
                creditCard.setLimit(requestCreditCardDTO.getLimit());
                creditCard.setName(requestCreditCardDTO.getName());
                creditCard.setNameCard(requestCreditCardDTO.getNameCard());
                creditCard.setValidity(requestCreditCardDTO.getValidity());
                creditCard.setStatus(CreditCardStatusEnum.ACTIVE);
                creditCardRepository.persist(creditCard);
                return ResponseCreditCardDTO.fromModel(creditCard);
            }else{
                throw new MessageExceptions("Não foi possível localizar o cartão", 404);
            }

        } catch (Exception e) {
           throw new MessageExceptions(e.getMessage(), 500);
        }
    }
}
