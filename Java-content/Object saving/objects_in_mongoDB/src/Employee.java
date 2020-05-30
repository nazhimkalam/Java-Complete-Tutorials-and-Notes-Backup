
import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private long no;
    private String name;

    public Employee() {
    }
    public void setNo(long no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}