package br.quarkusspending.com.usecase.users.login;

import br.quarkusspending.com.dto.RequestLoginDTO;
import br.quarkusspending.com.dto.ResponseLoginDTO;

public interface ILoginUsersUseCase {
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO);
}
