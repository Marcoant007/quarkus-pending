package br.quarkusspending.com.usecase.users.createUser;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;

@ApplicationScoped
public interface ICreateUsersUseCase {
   public ResponseUserDTO create(RequestUserDTO users);
}