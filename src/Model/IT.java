package Model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IT extends Student{
    private Departments department;
    private float javaScore, cssScore, tbScore;
    public IT() {}
    public IT(String id, String fullName, String address, float javaScore, float cssScore) {
        super(id, fullName, address);
        this.department = Departments.IT;
        this.javaScore = javaScore;
        this.cssScore = cssScore;
        this.tbScore = ((3 * this.getJavaScore()) + this.getCssScore()) / 4; //Can't Figure out how to update this.
    }
    public float getTbScore(){
        return (((3 * this.getJavaScore()) + this.getCssScore()) / 4);
    }
    @Override
    public String toString() {
        return super.toString() + "Java Score: " + getJavaScore() + " - CSS Score: " + getCssScore() +
                " - TB Score: " + getTbScore();
    }
}
