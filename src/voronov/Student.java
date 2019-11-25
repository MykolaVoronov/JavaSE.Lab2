package voronov;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name, faculty, classNum, recordID;
    private ArrayList<Subject> subjects;
    private static final int SUBJECTS_SIZE = 5;

    public Student(String name, String faculty, String classNum, String recordID)
    {
        this.name = name;
        this.recordID = recordID;
        this.faculty = faculty;
        this.classNum = classNum;
        this.subjects = new ArrayList<>(SUBJECTS_SIZE);
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getClassNum() {
        return classNum;
    }

    public void addSubject(Subject subject)
    {
        try {
            subjects.add(subject);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка добавления предмета!");
        }
    }

    public Subject getSubject(int position)
    {
        try {
            return subjects.get(position);
        }
        catch (Exception e)
        {
            return new Subject("","");
        }
    }

    public void removeSubject(int position)
    {
        try {
            subjects.remove(position);
        }
        catch (Exception e) {
            System.out.println("Ошибка удаления предмета!");
        }
    }

    public boolean isSubjectsEmpty()
    {
        for(int i = 0; i < subjects.size(); i++)
        {
            if(subjects.get(i) != null)
            {
                return false;
            }
        }
        return true;
    }

    public void  fillAllSubjectsManually()
    {
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Введите название предмета");
            subjects.get(i).setName(read.next());
            System.out.println("Введите ФИО преподавателя по предмету <" + subjects.get(i).getName() + ">");
            subjects.get(i).setTeacherName(read.next());
            System.out.println("Введите оценку по предмету <" + subjects.get(i).getName() + ">");
            subjects.get(i).setMark(Integer.parseInt(read.next()));
            read.close();
        }
    }

    public void setSubjectName(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите название предмета");
        subjects.get(position-1).setName(read.next());
        read.close();
    }

    public void setSubjectName(int position, String name)
    {
        subjects.get(position-1).setName(name);
    }

    public void setSubjectTeacherName(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите ФИО преподавателя по предмету <" + subjects.get(position-1).getName() + ">");
        subjects.get(position-1).setTeacherName(read.next());
        read.close();
    }

    public void setSubjectTeacherName(int position, String name)
    {
        subjects.get(position-1).setTeacherName(name);
    }

    public void setSubjectMark(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите оценку по предмету <" + subjects.get(position-1).getName() + ">" );
        subjects.get(position-1).setMark(read.nextInt());
        read.close();
    }

    public void setSubjectMark(int position, int mark)
    {
        try {
            subjects.get(position-1).setMark(mark);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка при попытке установить значение оценки");
        }
    }

    public int getAverageMark()
    {
        if(!isSubjectsEmpty())
        {
            int sum = 0;
            for (int i = 0; i < 5; i++)
            {
                try {
                    sum += subjects.get(i).getMark();
                }
                catch (Exception e)
                {
                    sum += 0;
                }
            }
            return sum / 5;
        }
        else return 0;
    }

    public boolean isExcellent()
    {
        if(getAverageMark() > 89)
        {
            System.out.println(getName() + " | " + getClassNum() + " курс | Факультет: " +
                    getFaculty() + " | ОТЛИЧНИК! Средний балл = " + getAverageMark());
            System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"
            return true;
        }
        return false;
    }

    public void showD()
    {
        for (int i = 0; i < 5; i++)
        {
            if (subjects.get(i).getMark() < 60)
                subjects.get(i).getInfo();
        }
    }

    public boolean isHaveD()
    {
        for (int i = 0; i < 5; i++)
        {
            try {
                if (subjects.get(i).getMark() < 60)
                    return true;
            }
            catch (Exception e){}
        }
        return false;
    }

    public void getInfo()
    {
        System.out.println("Имя: " + name + " | Номер зачетки: " + recordID + " | Факультет: " + faculty + " | Курс: " + classNum + " |");
        System.out.println();
            for (int i = 0; i < 5; i++) {
                try{
                System.out.println((i+1) + ". Предмет: " + subjects.get(i).getName() + " | Преподаватель: " + subjects.get(i).getTeacherName() + " | Оценка: " + subjects.get(i).getMark() + " |");
                }
                catch (Exception e)
                {
                    System.out.println((i+1) +". Предмет не указан");
                }
            }
        System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"
    }
}