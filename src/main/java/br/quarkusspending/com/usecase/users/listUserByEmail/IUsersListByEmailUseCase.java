package br.quarkusspending.com.usecase.users.listUserByEmail;

import br.quarkusspending.com.model.Users;

public interface IUsersListByEmailUseCase {
    public Users findByEmail(String email);
}
