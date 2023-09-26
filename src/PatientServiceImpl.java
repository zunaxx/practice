import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {
    private List<Patient> patients = new ArrayList<>();

    @Override
    public List<Patient> addHospital(List<Patient> patientsToAdd) {
        patients.addAll(patientsToAdd);
        return patients;
    }

    @Override
    public Patient getPatientByFirstName(String name) {
        return patients.stream()
                .filter(patient -> patient.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public Map<String, List<Patient>> groupingByGender() {
        return patients.stream()
                .collect(Collectors.groupingBy(Patient::getGender));
    }

    @Override
    public List<Patient> filterByAge() {
        return patients.stream()
                .filter(patient -> patient.getAge() > 30)
                .collect(Collectors.toList());
    }
}
