package br.quarkusspending.com.usecase.users.listUserByEmail;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;

@ApplicationScoped
public class UsersListByEmailUseCase implements IUsersListByEmailUseCase {

    @Inject UsersRepository usersRepository;

    @Override
    @Transactional
    public Users findByEmail(String email) {
        Optional<Users> usersOp = usersRepository.findByEmail(email);
        if(usersOp.isPresent()){
            return usersOp.get();
        }
        throw new MessageExceptions("Usuário não encontrado!", 400);
    }
}
