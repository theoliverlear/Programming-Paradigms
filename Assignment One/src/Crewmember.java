import java.util.ArrayList;

public class Crewmember {
    private String name;
    private String color;
    private String task;
    private int age;
    private boolean isAlive;
    private static int numCrewmembers = 0;
    private static ArrayList<Crewmember> crewmembers = new ArrayList<>();
    //----------------------------Constructors--------------------------------
    public Crewmember() {
        this("John", "red", "carpenter", 10, true);
    }
    public Crewmember(String name, String color, String task, int age,
                      boolean isAlive) {
        this.name = name;
        this.color = color;
        this.task = task;
        this.age = age;
        this.isAlive = isAlive;
        numCrewmembers++;
        crewmembers.add(this);
    }
    //------------------------------Getters-----------------------------------
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public String getTask() {
        return this.task;
    }
    public int getAge() {
        return this.age;
    }
    public boolean getIsAlive() {
        return this.isAlive;
    }
    public static int getNumCrewmembers() {
        return numCrewmembers;
    }
    public static ArrayList<Crewmember> getCrewmembers() {
        return crewmembers;
}
    //------------------------------Setters-----------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    //------------------------------Methods-----------------------------------
    public void details() {
        System.out.printf("Name: %s\nColor: %s\nTask: %s\nAge: %d\n",
                          this.name, this.color, this.task, this.age);
    }
}
