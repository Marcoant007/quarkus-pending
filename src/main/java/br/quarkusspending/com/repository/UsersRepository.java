package br.quarkusspending.com.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.Users;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


@ApplicationScoped
public class UsersRepository implements PanacheRepositoryBase<Users, Integer>{
    
    public Optional<Users> findByEmail(String email){
        return find("email", email).singleResultOptional();
    }

    public Optional<Users> findById(int id){
        return find("id", id).singleResultOptional();
    }
}
