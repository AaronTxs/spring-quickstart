package aaron.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aaron.spring.boot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}