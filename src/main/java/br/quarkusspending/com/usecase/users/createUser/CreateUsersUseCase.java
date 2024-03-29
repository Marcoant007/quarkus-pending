package br.quarkusspending.com.usecase.users.createUser;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import br.quarkusspending.com.dto.user.RequestUserDTO;
import br.quarkusspending.com.dto.user.ResponseUserDTO;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;
import br.quarkusspending.com.utils.ValidatorUtil;

@ApplicationScoped
public class CreateUsersUseCase implements ICreateUsersUseCase {

    @Inject UsersRepository usersRepository;
    @Inject ValidatorUtil validatorUtil;

    @Override
    @Transactional
    public ResponseUserDTO create(RequestUserDTO requestUserDTO) {
        validatorUtil.validate(requestUserDTO);
        try {
            Optional<Users> usersOp = usersRepository.findByEmail(requestUserDTO.getEmail());
            if (usersOp.isPresent()) {
                throw new MessageExceptions("Usuário já existe", 400);
            }
            Users users = new Users();
            String password = requestUserDTO.getPassword();
            users.setCpf(requestUserDTO.getCpf());
            users.setEmail(requestUserDTO.getEmail());
            users.setIncome(requestUserDTO.getIncome());
            users.setName(requestUserDTO.getName());
            users.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            users.setYear(requestUserDTO.getYear());
            users.setProfile(requestUserDTO.getProfile());

            usersRepository.persist(users);
            return ResponseUserDTO.fromModel(users);
        } catch (Exception e) {
            throw new MessageExceptions(e, 500);
        }
    }
}
