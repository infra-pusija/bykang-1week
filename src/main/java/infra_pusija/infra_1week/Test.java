package infra_pusija.infra_1week;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    public Test(String col1) {
        this.col1 = col1;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String col1;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", col1='" + col1 + '\'' +
                '}';
    }
}
