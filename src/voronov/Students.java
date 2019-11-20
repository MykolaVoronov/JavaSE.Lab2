package voronov;

public class Students {

    private Student students[];

    public Students(int count) {
        this.students = new Student[count];
    }

    public void addStudent(Student student, int position) {
        try {
            students[position] = student;
        } catch (Exception e) {
            Student tempStudents[] = new Student[position];
            for (int i = 0; i < students.length; i++) {
                tempStudents[i] = students[i];
            }
            tempStudents[position - 1] = student;
            students = tempStudents;
        }
    }

    public void addStudent(Student student) {
        Student tempStudents[] = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            tempStudents[i] = students[i];
        }
        tempStudents[tempStudents.length - 1] = student;
        students = tempStudents;
    }

    public void removeStudent(int position) {
        try {
            Student tempStudents[] = new Student[students.length - 1];
            for (int i = 0; i < position - 1; i++)
                tempStudents[i] = students[i];
            for (int i = position - 1; i < students.length - 1; i++)
                tempStudents[i] = students[i + 1];
            students = tempStudents;
        } catch (Exception e) {
            System.out.println("Ошибка удаления!");
        }
    }

    public boolean isStudentsEmpty() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void getExcellentStudents()
    {
        int excellentCounter = 0;
        for(int i = 0; i < students.length; i++)
        {
            if (students[i].isExcellent())
            excellentCounter += 1;
        }
        if(excellentCounter == 0)
            System.out.println("Отличников нету");
    }

    public void  getDStudents()
    {
        int DCounter = 0;
        for(int i = 0; i < students.length; i++)
        {
            try {
                if (students[i].isHaveD()) {
                    DCounter += 1;
                    System.out.println(students[i].getName() + " | " + students[i].getClassNum() + " курс | Факультет: " +
                            students[i].getFaculty() + " | Имеет двойки!");
                    students[i].showD();
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
        for(int i = 0; i < students.length; i++)
            if(students[i].isHaveD())
            {
                deletedCounter += 1;
                removeStudent(i + 1);
            }
        System.out.println("Удалено студентов: " + deletedCounter);
    }

    public void getInfo() {
        if (!isStudentsEmpty())
        {
            for (int i = 0; i < students.length; i++) {
                try {
                    System.out.print("(" + (i+1) + ") ");
                    students[i].getInfo();
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