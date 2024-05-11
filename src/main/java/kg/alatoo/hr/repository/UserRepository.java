package kg.alatoo.hr.repository;

import kg.alatoo.hr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getEmployeeById(Long id);
    Optional<User> getEmployeeByUsername(String lastName);

    void update(User user);

    void create(User user);
    void delete(Long id);

}
