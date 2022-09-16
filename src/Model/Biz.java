package Model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Biz extends Student{
    private Departments department;
    private float accScore, marketingScore, avgScore;
    public Biz() {}
    public Biz(String id, String fullName, String address, float accScore, float marketingScore) {
        super(id, fullName, address);
        this.department = Departments.BIZ;
        this.accScore = accScore;
        this.marketingScore = marketingScore;
    }
    public float getAvgScore(){return (((this.getAccScore() * 2) + this.getMarketingScore()) / 3);}
    @Override
    public String toString() {
        return super.toString() + "Accounting Score: " + getAccScore() + " - Marketing Score: " + getMarketingScore()
                + " - Average Score: " + getAvgScore();
    }
}
