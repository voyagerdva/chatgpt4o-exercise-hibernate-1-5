package nn.ru.entity;

import lombok.AllArgsConstructor; // для генерации конструктора с параметрами для всех полей
import lombok.Data; // для генерации геттеров, сеттеров, toString, equals и hashCode
import lombok.NoArgsConstructor; // для генерации конструктора без параметров
import javax.persistence.*;

@Entity
@Table(name = "products")
@Data // для генерации геттеров, сеттеров, toString, equals и hashCode
@NoArgsConstructor // для генерации конструктора без параметров
@AllArgsConstructor // для генерации конструктора с параметрами для всех полей
public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id") // указывает имя столбца в таблице
//    private Long id;

    @EmbeddedId
    private ProductId productId;

    @Column(name = "name") // указывает имя столбца в таблице
    private String name;

    @Column(name = "price") // указывает имя столбца в таблице
    private Double price;

    @Embedded
    private Address address;
}
