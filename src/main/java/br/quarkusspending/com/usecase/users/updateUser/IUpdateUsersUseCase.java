package br.quarkusspending.com.usecase.users.updateUser;

import br.quarkusspending.com.dto.user.RequestUserDTO;
import br.quarkusspending.com.dto.user.ResponseUserDTO;

public interface IUpdateUsersUseCase {
    public ResponseUserDTO update(int id, RequestUserDTO requestUserDTO);
}
