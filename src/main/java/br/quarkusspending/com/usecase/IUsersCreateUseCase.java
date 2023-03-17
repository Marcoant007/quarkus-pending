package br.quarkusspending.com.usecase;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;

@ApplicationScoped
public interface IUsersCreateUseCase {
   public ResponseUserDTO create(RequestUserDTO users);
}
