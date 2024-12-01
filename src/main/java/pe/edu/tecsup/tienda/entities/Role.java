package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
