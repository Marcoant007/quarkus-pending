package br.quarkusspending.com.usecase.users.findUserById;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.exceptions.MessageExceptions;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;

@ApplicationScoped
public class FindUsersByIdUseCase implements IFindUsersByIdUseCase {

    @Inject UsersRepository usersRepository;

    @Override
    @Transactional
    public Users findById(int id) {
        Optional<Users> usersOp = usersRepository.findById(id);
        if(usersOp.isPresent()){
            return usersOp.get();
        }
        throw new MessageExceptions("Usuário não encontrado!", 400);
    }
    
}
