package voronov;

public class Subject
{
    private  String name;
    private  String teacherName;
    private int mark;

public Subject (String name, String teacherName)
{
    this.name = name;
    this.teacherName = teacherName;
    this.mark = 0;
}

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getName()
    {
        return name;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public int getMark()
    {
        return mark;
    }

    public void getInfo()
    {
    System.out.println(name + " | Преподаватель: "+ teacherName+ " | Оценка: " + mark);
    }
}