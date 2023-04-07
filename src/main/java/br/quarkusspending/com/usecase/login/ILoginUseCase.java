package br.quarkusspending.com.usecase.login;

import br.quarkusspending.com.dto.login.RequestLoginDTO;
import br.quarkusspending.com.dto.login.ResponseLoginDTO;

public interface ILoginUseCase {
    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO);
}
