import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorServiceImp implements DoctorService{

    private List<Doctor> doctors = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Doctor> addDoctor(Doctor doctor) {
        doctor.setId(nextId++);
        doctors.add(doctor);
        return doctors;
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Doctor> filterByGender(String gender) {
        return doctors.stream()
                .filter(doctor -> doctor.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }
}
