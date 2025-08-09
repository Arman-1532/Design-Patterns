package learning.builder;

public class Main {
    public static void main(String[] args) {
        RobotBuilder combatBuilder = new CombatRobotBuilder();
        RobotDirector director = new RobotDirector(combatBuilder);
        Robot combatRobot = director.constructRobot();
        combatRobot.showSpecs();

        RobotBuilder cleaningBuilder = new CleaningRobotBuilder();
        director = new RobotDirector(cleaningBuilder);
        Robot cleaningRobot = director.constructRobot();
        cleaningRobot.showSpecs();
    }
}