package voronov;

public class Main {

    public static void main(String[] args)
    {

        Student student = new Student("Назаров Н. Г.", "ИКС","4","12345");
        Student student1 = new Student("Субботин Ю. В.", "ИКС","4","12132");
        Student student2 = new Student("Сивин М. Б.", "ИКС","3","1234241");
        Student student3 = new Student("Чернов Р. С.", "ИКС","4","1241242");
        Student student4 = new Student("Пахомов Г. М.", "ИКС","3","12245335");

        student.addSubject(new Subject("История","Жуков С. В."));
        student.addSubject(new Subject("Математика","Булат В. Г."));
        student.addSubject(new Subject("Физика","Новаков Г. О."));
        student.addSubject(new Subject("Химия","Сербенюк И. В."));
        student.addSubject(new Subject("Информатика","Фарионов А. А."));
        student.setSubjectMark(1,60);
        student.setSubjectMark(2, 75);
        student.setSubjectMark(3,80);
        student.setSubjectMark(4,59);
        student.setSubjectMark(5,44);


        student1.addSubject(new Subject("История","Жуков С. В."));
        student1.addSubject(new Subject("Математика","Булат В. Г."));
        student1.addSubject(new Subject("Физика","Новаков Г. О."));
        student1.addSubject(new Subject("Химия","Сербенюк И. В."));
        student1.addSubject(new Subject("Информатика","Фарионов А. А."));
        student1.setSubjectMark(1, 90);
        student1.setSubjectMark(2, 85);
        student1.setSubjectMark(3, 64);
        student1.setSubjectMark(4, 79);
        student1.setSubjectMark(5, 87);

        student2.addSubject(new Subject("История","Жуков С. В."));
        student2.addSubject(new Subject("Математика","Булат В. Г."));
        student2.addSubject(new Subject("Физика","Новаков Г. О."));
        student2.addSubject(new Subject("Химия","Сербенюк И. В."));
        student2.addSubject(new Subject("Информатика","Фарионов А. А."));
        student2.setSubjectMark(1, 90);
        student2.setSubjectMark(2, 100);
        student2.setSubjectMark(3, 85);
        student2.setSubjectMark(4, 93);
        student2.setSubjectMark(5, 95);

        student3.addSubject(new Subject("История","Жуков С. В."));
        student3.addSubject(new Subject("Математика","Булат В. Г."));
        student3.addSubject(new Subject("Физика","Новаков Г. О."));
        student3.addSubject(new Subject("Химия","Сербенюк И. В."));
        student3.addSubject(new Subject("Информатика","Фарионов А. А."));
        student3.setSubjectMark(1, 68);
        student3.setSubjectMark(2, 59);
        student3.setSubjectMark(3, 64);
        student3.setSubjectMark(4, 70);
        student3.setSubjectMark(5, 83);

        Students students = new Students(0);

        students.addStudent(student);
        students.addStudent(student1);
        students.addStudent(student2);
        students.addStudent(student3);
        students.addStudent(student4);

        students.getInfo();

        students.getExcellentStudents();

        students.getDStudents();

        students.removeIfD();

        students.getInfo();
    }
}
