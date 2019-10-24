package training.springboot.jpa.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * 部门实体类
 */
@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    //设置一对多的映射表
    @OneToMany(mappedBy="department",cascade = CascadeType.ALL)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
