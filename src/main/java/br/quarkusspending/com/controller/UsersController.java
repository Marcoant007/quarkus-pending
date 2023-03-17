package br.quarkusspending.com.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;
import br.quarkusspending.com.usecase.UsersCreateUseCase;

@Path("users")
public class UsersController {
    
    @Inject UsersCreateUseCase usersCreateUseCase;

    @POST
    public ResponseUserDTO create(RequestUserDTO requestUserDTO){
        return usersCreateUseCase.create(requestUserDTO);
    }
}
