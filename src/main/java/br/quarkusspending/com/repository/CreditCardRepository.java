package br.quarkusspending.com.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.CreditCard;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CreditCardRepository implements PanacheRepositoryBase<CreditCard, Integer> {
    
    public List<CreditCard> findCreditCardByUser(int user_id){
        return find("user_id", user_id).list();
    }
}
