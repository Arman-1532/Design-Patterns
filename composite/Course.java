package composite;

import java.util.ArrayList;
import java.util.List;

class Course extends CourseComponent {
    private List<CourseComponent> components = new ArrayList<>();

    public void addComponent(CourseComponent component) {
        components.add(component);
    }

    @Override
    public int computeDuration() {
        int total = 0;
        for (CourseComponent c : components) {
            total += c.computeDuration();
        }
        return total;
    }
}