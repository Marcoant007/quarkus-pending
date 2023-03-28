package br.quarkusspending.com.usecase.users.login;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import br.quarkusspending.com.auth.JwtGenerateToken;
import br.quarkusspending.com.dto.RequestLoginDTO;
import br.quarkusspending.com.dto.ResponseLoginDTO;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.usecase.users.findUserByEmail.FindUsersByEmailUseCase;

@ApplicationScoped
public class LoginUsersUseCase  implements ILoginUsersUseCase {

    @Inject JwtGenerateToken jwtGenerateToken;
    @Inject FindUsersByEmailUseCase findUsersByEmailUseCase;

    @Override
    @Transactional
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        try {
            ResponseLoginDTO loginDTO = new ResponseLoginDTO();
            Users users = findUsersByEmailUseCase.findByEmail(requestLoginDTO.getEmail());
            
            if(!BCrypt.checkpw(requestLoginDTO.getPassword(), users.getPassword())){
                throw new MessageExceptions("Email ou senha inválido", 400);
            }

            String token = jwtGenerateToken.generateToken(users.getId());
            loginDTO.setToken(token);
            loginDTO.setEmail(users.getEmail());

            return loginDTO;
        } catch (Exception e) {
            throw new MessageExceptions("Usuário não encontrado!", 400);
        }
    }

   
    
}
