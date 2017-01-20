package io.khasang.helpdesk.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_role")
    private String title;

    @OneToMany(mappedBy = "role")
    private Set<Users> users = new HashSet<Users>();

    public Role() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getId() != role.getId()) return false;
        if (getTitle() != null ? !getTitle().equals(role.getTitle()) : role.getTitle() != null) return false;
        return getUsers() != null ? getUsers().equals(role.getUsers()) : role.getUsers() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", users=" + users +
                '}';
    }
}
