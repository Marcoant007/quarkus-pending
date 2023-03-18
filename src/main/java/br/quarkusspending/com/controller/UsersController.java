package br.quarkusspending.com.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.usecase.users.createUser.UsersCreateUseCase;
import br.quarkusspending.com.usecase.users.listUser.UsersListUseCase;
import br.quarkusspending.com.usecase.users.listUserByEmail.UsersListByEmailUseCase;
import br.quarkusspending.com.usecase.users.updateUser.UsersUpdateUseCase;

@Path("users")
public class UsersController {
    
    @Inject UsersCreateUseCase usersCreateUseCase;
    @Inject UsersListUseCase usersListUseCase;
    @Inject UsersListByEmailUseCase usersListByEmailUseCase;
    @Inject UsersUpdateUseCase usersUpdateUseCase;

    @POST
    public ResponseUserDTO create(RequestUserDTO requestUserDTO){
        return usersCreateUseCase.create(requestUserDTO);
    }

    @GET
    public List<Users> listAll(){
        return usersListUseCase.list();
    }

    @GET
    @Path("/{email}")
    public Users findByEmail(@PathParam("email") String email){
        return usersListByEmailUseCase.findByEmail(email);
    }

    @PUT
    @Path("/{id}")
    public ResponseUserDTO update(@PathParam("id") int id, RequestUserDTO requestUserDTO){
        return usersUpdateUseCase.update(id, requestUserDTO);
    }
}
