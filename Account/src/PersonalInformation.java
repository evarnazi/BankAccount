import java.io.Serializable;

public class PersonalInformation implements Serializable {
	private static final long serialVersionUID = 1L;
private String name;
  private int age;
  private float salary;
  private String adress;
  private String job;

public PersonalInformation(String name, int age, float salary, String address, String job){
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.adress = address;
    this.job = job;
    }   
public void setName(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public void setAge(int age) {
    this.age = age;
}

public int getAge() {
    return age;
}

public void setSalary(float salary) {
    this.salary = salary;
}

public float getSalary() {
    return salary;
}

public void setAdress(String adress) {
    this.adress = adress;
}

public String getAdress() {
    return adress;
}
      
public void setJob(String job) {
    this.job = job;
}

public String getJob() {
    return job;
}
}
