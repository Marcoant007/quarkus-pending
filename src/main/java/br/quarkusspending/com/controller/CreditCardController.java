package br.quarkusspending.com.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.quarkusspending.com.dto.creditcard.DeletedCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.RequestCreditCardDTO;
import br.quarkusspending.com.dto.creditcard.ResponseCreditCardDTO;
import br.quarkusspending.com.model.CreditCard;
import br.quarkusspending.com.usecase.creditcards.createCreditCard.CreateCreditCardUseCase;
import br.quarkusspending.com.usecase.creditcards.deleteCreditCard.DeleteCreditCardUseCase;
import br.quarkusspending.com.usecase.creditcards.findCreditCard.FindCreditCardByUserUseCase;
import br.quarkusspending.com.usecase.creditcards.updateCreditCard.UpdateCreditCardUseCase;

@Tag(name = "Credit Card Controller", description = "Rota responsável pelo controle de cartão de crédito do usuário")
@Path("credit-card")
public class CreditCardController {
    
    @Inject CreateCreditCardUseCase createCreditCardUseCase;
    @Inject FindCreditCardByUserUseCase findCreditCardByUserUseCase;
    @Inject UpdateCreditCardUseCase updateCreditCard;
    @Inject DeleteCreditCardUseCase deleteCreditCard;

    @POST
    @RolesAllowed("ADMIN")
    public ResponseCreditCardDTO create(@Context SecurityContext securityContext, RequestCreditCardDTO requestCreditCardDTO){
        if (!securityContext.isUserInRole("ADMIN")) {
            throw new NotAuthorizedException("Usuário não autorizado");
        }
        Integer userId = Integer.parseInt(securityContext.getUserPrincipal().getName());
        return createCreditCardUseCase.createCreditCardByUser(userId, requestCreditCardDTO);
    }

    @GET
    @Path("/user-card/{userId}")
    public List<CreditCard> listCreditCardsByUser(@PathParam("userId") int id){
        return findCreditCardByUserUseCase.findCreditCardByUser(id);
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Path("/{userId}/{cardId}")
    public ResponseCreditCardDTO update(@PathParam("userId") int id, @PathParam("cardId") int cardId, @Context SecurityContext securityContext, RequestCreditCardDTO requestCreditCardDTO){
        Integer userId = Integer.parseInt(securityContext.getUserPrincipal().getName());
        return updateCreditCard.updateCreditCard(userId, cardId, requestCreditCardDTO);
    }

    @PUT
    @RolesAllowed("ADMIN")
    @Path("delete-card/{userId}/{cardId}")
    public DeletedCreditCardDTO delete(@PathParam("userId") int id, @PathParam("cardId") int cardId, @Context SecurityContext securityContext){
        Integer userId = Integer.parseInt(securityContext.getUserPrincipal().getName());
        return deleteCreditCard.deleteCreditCard(userId, cardId);
    }

}
