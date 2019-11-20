package voronov;

import java.util.ArrayList;

public class Students {

    private ArrayList<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student)
    {
        try {
            students.add(student);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка добавления студента");
        }
    }

    public void removeStudent(int position) {
        try {
            students.remove(position);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка добавления студента");
        }
    }

    public boolean isStudentsEmpty() {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                return false;
            }
        }
        return true;
    }

    public void getExcellentStudents()
    {
        int excellentCounter = 0;
        for(int i = 0; i < students.size(); i++)
        {
            if (students.get(i).isExcellent())
            excellentCounter += 1;
        }
        if(excellentCounter == 0)
            System.out.println("Отличников нету");
    }

    public void  getDStudents()
    {
        int DCounter = 0;
        for(int i = 0; i < students.size(); i++)
        {
            try {
                if (students.get(i).isHaveD()) {
                    DCounter += 1;
                    System.out.println(students.get(i).getName() + " | " + students.get(i).getClassNum() + " курс | Факультет: " +
                            students.get(i).getFaculty() + " | Имеет двойки!");
                    students.get(i).showD();
                    System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"
                }
            }
            catch (Exception e) {}
        }
        if(DCounter == 0)
            System.out.println("Двоек нету");
    }

    public void removeIfD()
    {
        int deletedCounter = 0;
        for(int i = 0; i < students.size(); i++)
            if(students.get(i).isHaveD())
            {
                deletedCounter += 1;
                students.remove(i);
            }
        System.out.println("Удалено студентов: " + deletedCounter);
    }

    public void getInfo() {
        if (!isStudentsEmpty())
        {
            for (int i = 0; i < students.size(); i++) {
                try {
                    System.out.print("(" + (i+1) + ") ");
                    students.get(i).getInfo();
                }
                catch (Exception e) {
                    System.out.println("Students: Слот " + (i + 1) + " пуст!");
                    System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"
                }
            }
        }
        else System.out.println("Список студентов пуст!");
    }
}