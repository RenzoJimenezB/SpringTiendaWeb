package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Category category;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private Double price;

    private Integer stock;

    @Column(name = "estado")
    private Integer state;

    @Column(name = "creado", insertable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
}
