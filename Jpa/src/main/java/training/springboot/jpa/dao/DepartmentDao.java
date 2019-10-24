package training.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.springboot.jpa.pojo.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Long> {
}
