package br.quarkusspending.com.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.CreditCard;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CreditCardRepository implements PanacheRepositoryBase<CreditCard, Integer> {
    
    public List<CreditCard> findCreditCardByUser(int user_id){
        return find("user_id=?1 AND status='ACTIVE'", user_id).list();
    }

    public Optional<CreditCard> findCreditCardByUserAndCardNumber(int userId, String cardNumber){
        return find("user_id=?1 AND card_number=?2 AND status='ACTIVE'", userId, cardNumber).singleResultOptional();
    }

    public Optional<CreditCard> findCreditCardByUserAndCardId(int userId, int cardId){
        return find("user_id=?1 AND id=?2 AND status='ACTIVE'", userId, cardId).singleResultOptional();
    }
}
