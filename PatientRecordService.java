import java.util.HashMap;
import java.util.Map;

// Singleton Pattern
public class PatientRecordService {
    private static final PatientRecordService instance = new 
PatientRecordService();
    private static final Map<String, PatientRecordFactory> 
departmentFactories = new HashMap<>();

    static {
        departmentFactories.put("cardiology", new 
CardiologyRecordFactory());
        departmentFactories.put("neurology", new 
NeurologyRecordFactory());
        departmentFactories.put("orthopedics", 
new OrthopedicsRecordFactory());
    }

    private PatientRecordService() {} // Private constructor for singleton

    public static PatientRecordService getInstance() {
        return instance;
    }

    public PatientRecord generateRecord(String department, String 
patientName) {
        PatientRecordFactory factory = 
departmentFactories.get(department);
        if (factory != null) {
            return factory.createRecord(patientName);
        } else {
            throw new IllegalArgumentException("Unsupported department: " 
+ department);
        }
    }
}

// Prototype Pattern
abstract class PatientRecord {
    String patientName;
    public PatientRecord(String patientName) {
        this.patientName = patientName;
    }
}

class CardiologyRecord extends PatientRecord {
    CardiologyRecord(String patientName) {
        super(patientName);
    }
}

class NeurologyRecord extends PatientRecord {
    NeurologyRecord(String patientName) {
        super(patientName);
    }
}

class OrthopedicsRecord extends PatientRecord {
    OrthopedicsRecord(String patientName) {
        super(patientName);
    }
}

// Factory Pattern
class CardiologyRecordFactory implements PatientRecordFactory {
    @Override
    public PatientRecord createRecord(String patientName) {
        return new CardiologyRecord(patientName);
    }
}

class NeurologyRecordFactory implements PatientRecordFactory {
    @Override
    public PatientRecord createRecord(String patientName) {
        return new NeurologyRecord(patientName);
    }
}

class OrthopedicsRecordFactory implements PatientRecordFactory {
    @Override
    public PatientRecord createRecord(String patientName) {
        return new OrthopedicsRecord(patientName);
    }
}

interface PatientRecordFactory {
    PatientRecord createRecord(String patientName);
}

// Builder Pattern
class PatientRecordBuilder {
    private PatientRecord record = new PatientRecord("Unknown"); // Default Record
    private final String diagnosis;
    private final String test;
    private final String note;

    public PatientRecordBuilder withDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public PatientRecordBuilder withTest(String test) {
        this.test = test;
        return this;
    }

    public PatientRecordBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public PatientRecord build() {
        record.setDiagnosis(diagnosis);
        record.addTest(test);
        record.setNotes(note);
        return record;
    }
}

// Main Function
public class Main {
    public static void main(String[] args) {
        PatientRecordService service = PatientRecordService.getInstance();

        // Create a cardiology record using the builder
        PatientRecord record1 = service.generateRecord("cardiology", 
"Rahim");
        System.out.println("Cardiology Record for " + 
record1.patientName);
        System.out.println("Diagnosis: " + 
record1.getDiagnosis());
        System.out.println("Test: " + record1.getTest());
        System.out.println("Notes: " + record1.getNotes());

        // Create a neurology record using the builder
        PatientRecord record2 = service.generateRecord("neurology", 
"Karim");
        System.out.println("\nNeurology Record for " + 
record2.patientName);
        System.out.println("Diagnosis: " + record2.getDiagnosis());
        System.out.println("Test: " + record2.getTest());
        System.out.println("Notes: " + record2.getNotes());
    }
}
