package training.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.springboot.jpa.pojo.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
