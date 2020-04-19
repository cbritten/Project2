package dev.group.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.group.beans.P2user;

@Repository
public interface P2userRepository extends CrudRepository<P2user, Integer>{
	P2user findByUsernameAndPword (String username, String pword);
	List<P2user> findByEmailAndPword (String email, String pword);

}