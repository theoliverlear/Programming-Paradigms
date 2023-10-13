public class Crewmember {
    private String name;
    private String color;
    private String task;
    private int age;
    private static int numCrewmembers = 0;
    //----------------------------Constructors--------------------------------
    public Crewmember() {
        this.name = "John";
        this.color = "red";
        this.task = "carpenter";
        this.age = 10;
        numCrewmembers++;
    }
    public Crewmember(String name, String color, String task, int age) {
        this.name = name;
        this.color = color;
        this.task = task;
        this.age = age;
        numCrewmembers++;
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
    public static int getNumCrewmembers() {
        return numCrewmembers;
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
    //------------------------------Methods-----------------------------------
    public void details() {
        System.out.printf("Name: %s\nColor: %s\nTask: %s\nAge: %d\n",
                          this.name, this.color, this.task, this.age);
    }
}
