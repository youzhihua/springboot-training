package training.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.springboot.jpa.pojo.Role;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
}
