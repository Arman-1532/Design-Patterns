package learning.builder;

class CleaningRobotBuilder implements RobotBuilder {
    private Robot robot = new Robot();

    public void buildHead() {
        robot.head = "Cleaning Head";
    }

    public void buildArms() {
        robot.arms = "Cleaning Arms";
    }

    public void buildLegs() {
        robot.legs = "Cleaning Legs";
    }

    public Robot getRobot() {
        return robot;
    }
}

