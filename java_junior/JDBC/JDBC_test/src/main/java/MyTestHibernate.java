import javax.persistence.*;

@Entity
@Table(name = "testTable")
public class MyTestHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testID;
    @Column(name = "fistColumn")
    private String fistColumn;
    @Column(name = "secondColumn")
    private String secondColumn;
    @Column(name = "thirdColumn")
    private String thirdColumn;

    public MyTestHibernate(String fistColumn, String secondColumn, String thirdColumn) {
        this.fistColumn = fistColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }
}
