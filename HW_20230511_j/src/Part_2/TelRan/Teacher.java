package Part_2.TelRan;

public class Teacher extends Human{

    private String qualification;

    public Teacher(int age,String name, String qualification) {
        super(age, name, "teacher");
        this.qualification = qualification;
    }

    @Override
    public void doWork(String str) {
        System.out.println(super.getStatus() + " " + super.getName() + " " + str);
    }

    public String getQualification() {
        return qualification;
    }

    /*
    https://github.com/Shonmikl/_070223-m-be
     */
}
