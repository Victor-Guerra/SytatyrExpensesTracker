package mx.tec.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mx.tec.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("FROM User u WHERE u.username = ?1")
	Optional<User> findByUsername(String username);
	
	@Query("FROM User u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);
}
