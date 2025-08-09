package composite;

class Project extends CourseComponent {
    private int duration;

    public Project(int duration) {
        this.duration = duration;
    }

    @Override
    public int computeDuration() {
        return duration;
    }
}