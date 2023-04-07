package br.quarkusspending.com.auth;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.quarkusspending.com.dto.login.RequestLoginDTO;
import br.quarkusspending.com.dto.login.ResponseLoginDTO;
import br.quarkusspending.com.usecase.login.LoginUseCase;

@Path("secured")
public class LoginController {
   
    @Inject LoginUseCase loginUsersUseCase;

    @PermitAll
    @POST
    @Path("login")
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO){
        return loginUsersUseCase.login(requestLoginDTO);
    }
}
