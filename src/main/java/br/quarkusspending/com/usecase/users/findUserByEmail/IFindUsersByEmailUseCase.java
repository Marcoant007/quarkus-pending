package br.quarkusspending.com.usecase.users.findUserByEmail;

import br.quarkusspending.com.model.Users;

public interface IFindUsersByEmailUseCase {
    public Users findByEmail(String email);
}
