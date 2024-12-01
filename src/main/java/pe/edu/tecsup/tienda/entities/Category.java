package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categorias")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "orden")
    private Integer order;

    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
