package nn.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data // для генерации геттеров, сеттеров, toString, equals и hashCode
@NoArgsConstructor // для генерации конструктора без параметров
@AllArgsConstructor // для генерации конструктора с параметрами для всех полей
public class ProductId implements Serializable {

    @Column(name = "productCode") // указывает имя столбца в таблице
    private String productCode;

    @Column(name = "supplierCode") // указывает имя столбца в таблице
    private String supplierCode;

}
