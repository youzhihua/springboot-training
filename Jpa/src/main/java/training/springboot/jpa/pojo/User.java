package training.springboot.jpa.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 */
@Entity(name = "user")
public class User {

    //设置id为主键，生成策略是自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;

    //设置数据库列名是create_date，格式为 yyyy-MM-dd
    @Temporal(value = TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    //防止JSON序列化时循环引用
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    //多对多
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_and_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", createDate=" + createDate +
                ", department=" + department +
                ", roles=" + roles +
                '}';
    }
}
