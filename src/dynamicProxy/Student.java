package dynamicProxy;

public class Student implements StudentInterface {
    private String name;
    private int grade;
    Student(String name, int grade){
        setName(name);
        setGrade(grade);
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public int viewGrade() {
        return grade;
    }

    @Override
    public  void setGrade(int newGrade){
        grade = newGrade;
    }
}
