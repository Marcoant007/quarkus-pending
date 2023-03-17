package br.quarkusspending.com.usecase;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;
import br.quarkusspending.com.model.Users;
import br.quarkusspending.com.repository.UsersRepository;

@ApplicationScoped
public class UsersCreateUseCase implements IUsersCreateUseCase{

    @Inject UsersRepository usersRepository;

    @Override
    @Transactional
    public ResponseUserDTO create(RequestUserDTO requestUserDTO) {
        Optional<Users> usersOp = usersRepository.findByEmail(requestUserDTO.getEmail());
        if(usersOp.isPresent()){
            throw new Error("Usuário já existe");
        }
        Users users = new Users();
        users.setCpf(requestUserDTO.getCpf());
        users.setEmail(requestUserDTO.getEmail());
        users.setIncome(requestUserDTO.getIncome());
        users.setName(requestUserDTO.getName());
        users.setPassword(requestUserDTO.getPassword());
        users.setYear(requestUserDTO.getYear());
        usersRepository.persist(users);
        return ResponseUserDTO.fromModel(users);
    }
}
