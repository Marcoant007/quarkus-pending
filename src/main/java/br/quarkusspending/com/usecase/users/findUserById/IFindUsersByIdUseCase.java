package br.quarkusspending.com.usecase.users.findUserById;

import br.quarkusspending.com.model.Users;

public interface IFindUsersByIdUseCase {
    public Users findById(int id);
}
