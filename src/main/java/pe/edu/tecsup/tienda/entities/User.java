package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

    private String email;
    private String password;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "sexo")
    private String sex;

    @Column(name = "fecnacimiento")
    private Date birthdate;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "estado")
    private Integer state;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> authorities = new ArrayList<>();
        authorities.add(role);
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // false: User account has expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // false: User account is locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // false: User credentials have expired
    }

    @Override
    public boolean isEnabled() {
        return this.state != null && this.state == 1;
    }
}
