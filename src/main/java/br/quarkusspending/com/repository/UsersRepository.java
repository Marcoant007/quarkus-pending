package br.quarkusspending.com.repository;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.Users;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


@ApplicationScoped
public class UsersRepository implements PanacheRepositoryBase<Users, Integer>{

}
