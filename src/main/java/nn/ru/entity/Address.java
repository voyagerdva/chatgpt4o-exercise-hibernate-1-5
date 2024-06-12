package nn.ru.entity;

import lombok.AllArgsConstructor; // для генерации конструктора с параметрами для всех полей
import lombok.Data; // для генерации геттеров, сеттеров, toString, equals и hashCode
import lombok.NoArgsConstructor; // для генерации конструктора без параметров
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data // для генерации геттеров, сеттеров, toString, equals и hashCode
@NoArgsConstructor // для генерации конструктора без параметров
@AllArgsConstructor // для генерации конструктора с параметрами для всех полей
public class Address {

    @Column(name = "city") // указывает имя столбца в таблице
    private String city;

    @Column(name = "state") // указывает имя столбца в таблице
    private String state;

    @Column(name = "street") // указывает имя столбца в таблице
    private String street;

    @Column(name = "zipCode") // указывает имя столбца в таблице
    private String zipCode;
}