package learning.builder;

interface RobotBuilder {
    void buildHead();
    void buildArms();
    void buildLegs();
    Robot getRobot();
}