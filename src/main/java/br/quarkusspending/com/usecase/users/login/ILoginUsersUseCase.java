package br.quarkusspending.com.usecase.users.login;

import br.quarkusspending.com.dto.login.RequestLoginDTO;
import br.quarkusspending.com.dto.login.ResponseLoginDTO;

public interface ILoginUsersUseCase {
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO);
}
