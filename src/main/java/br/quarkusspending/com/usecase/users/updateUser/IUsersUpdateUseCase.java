package br.quarkusspending.com.usecase.users.updateUser;

import br.quarkusspending.com.dto.RequestUserDTO;
import br.quarkusspending.com.dto.ResponseUserDTO;

public interface IUsersUpdateUseCase {
    public ResponseUserDTO update(int id, RequestUserDTO requestUserDTO);
}
