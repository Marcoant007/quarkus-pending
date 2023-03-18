package br.quarkusspending.com.usecase.users.listUser;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;

@ApplicationScoped
public class UsersListUseCase implements IUsersListUseCase {

    @Inject UsersRepository usersRepository;

    @Override
    @Transactional
    public List<Users> list() {
        return usersRepository.findAll().list();
    }
    
}
