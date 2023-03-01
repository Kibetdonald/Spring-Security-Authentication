package com.springauthentication.Implementing.Spring.Security.Repository;

import com.springauthentication.Implementing.Spring.Security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetUsersRepository extends JpaRepository<User, Integer> {

}
