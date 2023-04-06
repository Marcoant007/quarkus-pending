package br.quarkusspending.com.usecase.users.createUser;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.user.RequestUserDTO;
import br.quarkusspending.com.dto.user.ResponseUserDTO;

@ApplicationScoped
public interface ICreateUsersUseCase {
   public ResponseUserDTO create(RequestUserDTO users);
}
