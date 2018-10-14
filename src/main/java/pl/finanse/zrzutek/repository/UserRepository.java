package pl.finanse.zrzutek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.finanse.zrzutek.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
