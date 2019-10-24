package training.springboot.jpa.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * 角色实体类
 */
@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "user_and_role",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")})
    @JsonBackReference
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
