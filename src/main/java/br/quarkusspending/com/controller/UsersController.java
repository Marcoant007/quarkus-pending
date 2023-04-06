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

import br.quarkusspending.com.dto.user.RequestUserDTO;
import br.quarkusspending.com.dto.user.ResponseUserDTO;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.usecase.users.createUser.CreateUsersUseCase;
import br.quarkusspending.com.usecase.users.findUserByEmail.FindUsersByEmailUseCase;
import br.quarkusspending.com.usecase.users.listUser.ListUsersUseCase;
import br.quarkusspending.com.usecase.users.updateUser.UpdateUsersUseCase;

@Tag(name = "Users Controller", description = "Rota responsável pelo controle de usuários")
@Path("users")
public class UsersController {
    
    @Inject CreateUsersUseCase usersCreateUseCase;
    @Inject ListUsersUseCase usersListUseCase;
    @Inject FindUsersByEmailUseCase usersListByEmailUseCase;
    @Inject UpdateUsersUseCase usersUpdateUseCase;

    @POST
    @RolesAllowed("ADMIN")
    public ResponseUserDTO create(@Context SecurityContext securityContext, RequestUserDTO requestUserDTO){
        if (!securityContext.isUserInRole("ADMIN")) {
            throw new NotAuthorizedException("Usuário não autorizado");
        }
        return usersCreateUseCase.create(requestUserDTO);
    }

    @GET
    @RolesAllowed("ADMIN")
    public List<Users> listAll(){
        return usersListUseCase.list();
    }

    @GET
    @Path("/{email}")
    @RolesAllowed("ADMIN")
    public Users findByEmail(@PathParam("email") String email){
        return usersListByEmailUseCase.findByEmail(email);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public ResponseUserDTO update(@PathParam("id") int id, RequestUserDTO requestUserDTO){
        return usersUpdateUseCase.update(id, requestUserDTO);
    }
}
