package br.quarkusspending.com.usecase.login;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import br.quarkusspending.com.auth.JwtGenerateToken;
import br.quarkusspending.com.dto.login.RequestLoginDTO;
import br.quarkusspending.com.dto.login.ResponseLoginDTO;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.usecase.users.findUserByEmail.FindUsersByEmailUseCase;

@ApplicationScoped
public class LoginUseCase  implements ILoginUseCase {

    @Inject JwtGenerateToken jwtGenerateToken;
    @Inject FindUsersByEmailUseCase findUsersByEmailUseCase;
    private final int EXPIRES_IN = 3600;

    @Override
    @Transactional
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        try {
            ResponseLoginDTO loginDTO = new ResponseLoginDTO();
            Users users = findUsersByEmailUseCase.findByEmail(requestLoginDTO.getEmail());
            
            if(!BCrypt.checkpw(requestLoginDTO.getPassword(), users.getPassword())){
                throw new MessageExceptions("Email ou senha inválido", 400);
            }
           
            String token = jwtGenerateToken.generateToken(users, EXPIRES_IN);
            loginDTO.setToken(token);
            loginDTO.setEmail(users.getEmail());
            loginDTO.setExpiresIn(EXPIRES_IN);
            loginDTO.setProfile(users.getProfile());

            return loginDTO;
        } catch (Exception e) {
            throw new MessageExceptions("Usuário não encontrado!", 400);
        }
    }
}
