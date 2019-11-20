package voronov;

import java.util.Scanner;

public class Student {

    private String name, faculty, classNum, recordID;
    private Subject subjects[];

    public Student(String name, String faculty, String classNum, String recordID)
    {
        this.name = name;
        this.recordID = recordID;
        this.faculty = faculty;
        this.classNum = classNum;
        this.subjects = new  Subject[5];
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
        for(int i = 0; i < 5; i++)
        {
            if(subjects[i]==null)
            {
                subjects[i] = subject;
                break;
            }
            if(i == 4 && subjects[i] != null)
                System.out.println("Список предметов полон!");
        }
    }

    public void removeSubject(int position)
    {
        try {
            subjects[position - 1] = null;
        }
        catch (Exception e) {
            System.out.println("Ошибка удаления предмета!");
        }
    }
    public boolean isSubjectsEmpty()
    {
        for(int i = 0; i < subjects.length; i++)
        {
            if(subjects[i] != null)
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
            subjects[i].setName(read.next());
            System.out.println("Введите ФИО преподавателя по предмету <" + subjects[i].getName() + ">");
            subjects[i].setTeacherName(read.next());
            System.out.println("Введите оценку по предмету <" + subjects[i].getName() + ">");
            subjects[i].setMark(Integer.parseInt(read.next()));
            read.close();
        }
    }
    public void setSubjectName(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите название предмета");
        subjects[position-1].setName(read.next());
        read.close();
    }

    public void setSubjectName(int position, String name)
    {
        subjects[position-1].setName(name);
    }

    public void setSubjectTeacherName(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите ФИО преподавателя по предмету <" + subjects[position-1].getName() + ">");
        subjects[position-1].setTeacherName(read.next());
        read.close();
    }

    public void setSubjectTeacherName(int position, String name)
    {
        subjects[position-1].setTeacherName(name);
    }

    public void setSubjectMark(int position)
    {
        Scanner read = new Scanner(System.in);
        System.out.println("Введите оценку по предмету <" + subjects[position-1].getName() + ">" );
        subjects[position-1].setMark(read.nextInt());
        read.close();
    }

    public void setSubjectMark(int position, int mark)
    {
        try {
            subjects[position - 1].setMark(mark);
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
                    sum += subjects[i].getMark();
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
            if (subjects[i].getMark() < 60)
                subjects[i].getInfo();
        }
    }

    public boolean isHaveD()
    {
        for (int i = 0; i < 5; i++)
        {
            try {
                if (subjects[i].getMark() < 60)
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
                System.out.println((i+1) + ". Предмет: " + subjects[i].getName() + " | Преподаватель: " + subjects[i].getTeacherName() + " | Оценка: " + subjects[i].getMark() + " |");
                }
                catch (Exception e)
                {
                    System.out.println((i+1) +". Предмет не указан");
                }
            }
        System.out.println("----------------------------------------------------------------------------------------------------"); //x100 "-"

    }
}