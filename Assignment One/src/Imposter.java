public class Imposter extends Crewmember {
    public Imposter() {
        super();
    }
    public Imposter(String name, String color, String task, int age,
                    boolean isAlive) {
        super(name, color, task, age, isAlive);
    }
    public void kill(Crewmember crewmember) {
        if (crewmember.getIsAlive() && this.getIsAlive()) {
            crewmember.setIsAlive(false);
        }
    }
}
