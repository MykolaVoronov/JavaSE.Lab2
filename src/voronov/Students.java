package voronov;

import java.io.Serializable;
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
                i--;
            }
        System.out.println("Удалено студентов: " + deletedCounter);
    }

    public void searchSubjectMoreD()
    {
        try {
            ArrayList<Subject> checkerList = new ArrayList<>();
            int subjectIndex = 0, maxCountOfRepeat = 0;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).isHaveD())
                    for (int j = 0; j < 5; j++)
                        checkerList.add(students.get(i).getSubject(j));
            }
            for (int i = 0; i < checkerList.size(); i++) {
                if (checkerList.get(i).getMark() > 60 || checkerList.get(i).getName() == "") {
                    checkerList.remove(i);
                    if (checkerList.size() != 0) i--;
                }
            }
            ArrayList<Subject> tempCheckerList = checkerList;
            for (int i = 0; i < checkerList.size(); i++) {
                int countOfRepeat = 0;
                for (int j = 0; j < checkerList.size(); j++) {
                    if (checkerList.get(i).getName() == tempCheckerList.get(j).getName())
                        countOfRepeat += 1;
                    if (countOfRepeat > maxCountOfRepeat)
                        maxCountOfRepeat = countOfRepeat;
                    subjectIndex = i;
                }
            }
            System.out.println("Наибольшее число студентов получили двойки по предмету: " + checkerList.get(subjectIndex).getName());
        }
        catch (Exception e)
        {
            System.out.println("Двоек нету");
        }
    }

    public void getInfo() {
        if (!isStudentsEmpty())
        {
            System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"
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