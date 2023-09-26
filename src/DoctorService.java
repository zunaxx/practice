import java.util.List;

public interface DoctorService {
    List<Doctor> addDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> filterByGender(String gender);
    List<Doctor> getAllDoctors();
}
