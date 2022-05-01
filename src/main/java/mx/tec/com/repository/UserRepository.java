package mx.tec.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mx.tec.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
