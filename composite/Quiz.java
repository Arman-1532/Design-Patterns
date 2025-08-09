package composite;

class Quiz extends CourseComponent {
    private int duration;

    public Quiz(int duration) {
        this.duration = duration;
    }

    @Override
    public int computeDuration() {
        return duration;
    }
}