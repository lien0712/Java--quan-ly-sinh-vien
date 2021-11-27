import java.util.Scanner;

public class Student {
    static int count=0;
    int id=0, age;
    String name, address;
    float gpa;

    public Student() {
        id=++count;
    }

    public Student( int age, String name, String address, float gpa) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.gpa = gpa;
        id=++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public void input() {
        Scanner in = new Scanner(System.in);
//        System.out.println("Nhap ID: ");
//        id = Integer.parseInt(in.nextLine());
        System.out.println("Nhap ten: ");
        name = in.nextLine();
        System.out.println("Nhap dia chi: ");
        address = in.nextLine();
        System.out.println("Nhap tuoi: ");
        age = Integer.parseInt(in.nextLine());
        System.out.println("Nhap gpa: ");
        gpa = Float.parseFloat(in.nextLine());

    }
    public void display(){
        System.out.println(this);
    }
    public String getFileLine(){
        return id+","+name+","+age+","+address+","+gpa+"\n";
    }
    public void parse(String line){
        String[] params= line.split(",");
        id=Integer.parseInt(params[0]);
        name=params[1];
        age=Integer.parseInt(params[2]);
        address=params[3];
        gpa=Float.parseFloat(params[4]);
    }
}
