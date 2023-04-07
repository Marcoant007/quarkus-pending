package br.quarkusspending.com.usecase.creditcards.createCreditCard;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.dto.creditcard.RequestCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.ResponseCreditCardDTO;
import br.quarkusspending.com.enums.CreditCardStatusEnum;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.CreditCardRepository;
import br.quarkusspending.com.usecase.users.findUserById.FindUsersByIdUseCase;
import br.quarkusspending.com.utils.ValidatorUtil;

@ApplicationScoped
public class CreateCreditCardUseCase implements ICreateCreditCardUseCase {

    @Inject CreditCardRepository creditCardRepository;
    @Inject FindUsersByIdUseCase findUsersByIdUseCase;
    @Inject ValidatorUtil validatorUtil;

    @Override
    @Transactional
    public ResponseCreditCardDTO createCreditCardByUser(int userId, RequestCreditCardDTO requestCreditCardDTO) {
        validatorUtil.validate(requestCreditCardDTO);
        try {
            Users user = findUsersByIdUseCase.findById(userId);
            CreditCard creditCard = new CreditCard();
            creditCard.setName(requestCreditCardDTO.getName());
            creditCard.setNameCard(requestCreditCardDTO.getNameCard());
            creditCard.setAccount(requestCreditCardDTO.getAccount());
            creditCard.setAgency(requestCreditCardDTO.getAgency());
            creditCard.setCardNumber(requestCreditCardDTO.getCardNumber());
            creditCard.setCvv(requestCreditCardDTO.getCvv());
            creditCard.setLimit(requestCreditCardDTO.getLimit());
            creditCard.setValidity(requestCreditCardDTO.getValidity());
            creditCard.setStatus(CreditCardStatusEnum.ACTIVE);
            creditCard.setUsers(user);
            creditCardRepository.persist(creditCard);
            return ResponseCreditCardDTO.fromModel(creditCard);
        } catch (Exception e) {
            throw new MessageExceptions(e, 500);
        }
    }
    
}
