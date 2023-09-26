import java.util.List;
import java.util.Map;

public interface PatientService {
    List<Patient> addHospital(List<Patient> patients);
    Patient getPatientByFirstName(String name);
    List<Patient> getAllPatients();
    Map<String, List<Patient>> groupingByGender();
    List<Patient> filterByAge();
}
