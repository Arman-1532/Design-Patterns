package learning.builder;


class RobotDirector {
    private RobotBuilder builder;

    public RobotDirector(RobotBuilder builder) {
        this.builder = builder;
    }

    public Robot constructRobot() {
        builder.buildHead();
        builder.buildArms();
        builder.buildLegs();
        return builder.getRobot();
    }
}