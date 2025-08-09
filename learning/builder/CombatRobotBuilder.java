package learning.builder;

class CombatRobotBuilder implements RobotBuilder {
    private Robot robot = new Robot();

    public void buildHead() {
        robot.head = "Combat Head";
    }

    public void buildArms() {
        robot.arms = "Combat Arms";
    }

    public void buildLegs() {
        robot.legs = "Combat Legs";
    }

    public Robot getRobot() {
        return robot;
    }
}
