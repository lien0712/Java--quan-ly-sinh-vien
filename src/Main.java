import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class Main {
    static List<Student> studentList= new ArrayList<>();
    static Scanner in= new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do{
            showMenu();
            choose=Integer.parseInt(in.nextLine());
            switch (choose){
                case 1:
                    inputStudent();
                    break;
                case 2:
                    editStudentByID();
                    break;
                case 3:
                    deleteStudentByID();
                    break;
                case 4:
                    sortStudentByGpa();
                    break;
                case 5:
                    sortStudentByName();
                    break;
                case 6:
                    displayStudent();
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                    readFile();
                    break;
                case 9:
                    break;

            }
        }while(choose!=9);

    }
    private static void inputStudent() {
        System.out.println("Nhap sinh vien can them: ");
        int n=Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            Student std=new Student();
            std.input();
            studentList.add(std);
        }
    }

    private static void editStudentByID() {
        System.out.println("Nhap id sinh vien can sua: ");
        int id = Integer.parseInt(in.nextLine());
        for (Student student:studentList) {
            if (student.id == id) {
                student.input();
                break;
            }
        }
    }

    private static void deleteStudentByID() {
        System.out.println("Nhap id sinh vien can xoa: ");
        int id = Integer.parseInt(in.nextLine());
        for (Student student:studentList) {
            if (student.id == id) {
                studentList.remove(student);
                break;
            }
        }
    }


    private static void sortStudentByGpa() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGpa()> o2.getGpa()){
                    return -1;
                }
                return 1;
            }
        });
    }


    private static void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getName().compareToIgnoreCase(o2.getName());//them - a->z
            }
        });
    }


    private static void displayStudent() {
        for (Student student:
             studentList) {
            student.display();
        }
    }


    private static void saveFile() {
        System.out.println(" Bat dau luu");
        FileOutputStream fos=null;
        try {
            fos= new FileOutputStream("student.txt");
            for (Student student:
                 studentList) {
                String line= student.getFileLine();
                byte[] b= line.getBytes(StandardCharsets.UTF_8);
                fos.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private static void readFile() {
        FileInputStream fis=null;
        InputStreamReader reader= null;
        BufferedReader bufferedReader=null;
        try {
            fis= new FileInputStream("student.txt");
            reader= new InputStreamReader(fis,StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(reader);
            String line= null;
            while ((line= bufferedReader.readLine())!=null){
                if(line.isEmpty()){
                    continue;
                }
                Student std = new Student();
                std.parse(line);
                studentList.add(std);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    static void showMenu(){
        System.out.println("1. Them sinh vien");
        System.out.println("2. Sua sinh vien theo id");
        System.out.println("3. Xoa sinh vien theo id");
        System.out.println("4. Sap xep theo GPA");
        System.out.println("5. Sap xep theo ten");
        System.out.println("6. Hien thi thong tin sinh vien ");
        System.out.println("7. Luu vao file student.txt");
        System.out.println("8. Doc noi dung sinh vien tu student.txt");
        System.out.println("9. Thoat");
        System.out.println(" Chon: ");

    }
}


