package learning.composite;

class Lesson extends CourseComponent {
    private int duration;

    public Lesson(int duration) {
        this.duration = duration;
    }

    @Override
    public int computeDuration() {
        return duration;
    }
}