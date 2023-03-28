package br.quarkusspending.com.auth;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.quarkusspending.com.dto.RequestLoginDTO;
import br.quarkusspending.com.dto.ResponseLoginDTO;
import br.quarkusspending.com.usecase.users.login.LoginUsersUseCase;

@Path("secured")
public class LoginController {
   
    @Inject LoginUsersUseCase loginUsersUseCase;

    @PermitAll
    @POST
    @Path("login")
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO){
        return loginUsersUseCase.login(requestLoginDTO);
    }
}
