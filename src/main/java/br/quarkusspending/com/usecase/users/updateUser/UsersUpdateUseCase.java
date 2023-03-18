package br.quarkusspending.com.usecase.users.updateUser;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;
import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;

@ApplicationScoped
public class UsersUpdateUseCase implements IUsersUpdateUseCase {

    @Inject
    UsersRepository usersRepository;

    @Override
    @Transactional
    public ResponseUserDTO update(int id, RequestUserDTO requestUserDTO) {
        try {
            Optional<Users> usersOp = usersRepository.findById(id);
            if (!usersOp.isPresent()) {
                throw new MessageExceptions("Usuário não existe", 400);
            }

            Optional<Users> findUserEmail = usersRepository.findByEmail(requestUserDTO.getEmail());
            if(findUserEmail.isPresent()){
                throw new MessageExceptions("Esse email já existe", 400);
            }

            Users user = usersOp.get();
            user.setCpf(requestUserDTO.getCpf());
            user.setEmail(requestUserDTO.getEmail());
            user.setIncome(requestUserDTO.getIncome());
            user.setName(requestUserDTO.getName());
            user.setPassword(requestUserDTO.getPassword());
            user.setYear(requestUserDTO.getYear());
            usersRepository.persist(user);
            return ResponseUserDTO.fromModel(user);
        } catch (Exception e) {
            throw new MessageExceptions(e, 500);
        }
    }
}
