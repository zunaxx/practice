import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DoctorService doctorService = new DoctorServiceImp();
        PatientService patientService = new PatientServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить доктора");
            System.out.println("2. Найти доктора по ID");
            System.out.println("3. Фильтровать докторов по полу");
            System.out.println("4. Показать всех докторов");
            System.out.println("5. Добавить пациента");
            System.out.println("6. Найти пациента по имени");
            System.out.println("7. Показать всех пациентов");
            System.out.println("8. Группировать пациентов по полу");
            System.out.println("9. Фильтровать пациентов по возрасту");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("Введите имя доктора:");
                    String doctorName = scanner.nextLine();
                    System.out.println("Введите пол доктора:");
                    String doctorGender = scanner.nextLine();
                    Doctor newDoctor = new Doctor(null, doctorName, doctorGender);
                    doctorService.addDoctor(newDoctor);
                    System.out.println("Доктор добавлен.");
                    break;

                case 2:
                    System.out.println("Введите ID доктора:");
                    Long doctorId = scanner.nextLong();
                    Doctor foundDoctor = doctorService.getDoctorById(doctorId);
                    if (foundDoctor != null) {
                        System.out.println("Найден доктор: " + foundDoctor.getName());
                    } else {
                        System.out.println("Доктор с указанным ID не найден.");
                    }
                    break;

                case 3:
                    System.out.println("Введите пол для фильтрации (Male/Female):");
                    String filterDoctorGender = scanner.nextLine();
                    List<Doctor> filteredDoctors = doctorService.filterByGender(filterDoctorGender);
                    if (!filteredDoctors.isEmpty()) {
                        System.out.println("Фильтрованные докторы:");
                        for (Doctor doctor : filteredDoctors) {
                            System.out.println(doctor.getName());
                        }
                    } else {
                        System.out.println("Докторы с указанным полом не найдены.");
                    }
                    break;

                case 4:
                    List<Doctor> allDoctors = doctorService.getAllDoctors();
                    if (!allDoctors.isEmpty()) {
                        System.out.println("Все докторы:");
                        for (Doctor doctor : allDoctors) {
                            System.out.println(doctor.getName());
                        }
                    } else {
                        System.out.println("Докторы не найдены.");
                    }
                    break;

                case 5:
                    System.out.println("Введите имя пациента:");
                    String patientName = scanner.nextLine();
                    System.out.println("Введите пол пациента:");
                    String patientGender = scanner.nextLine();
                    System.out.println("Введите возраст пациента:");
                    int patientAge = scanner.nextInt();
                    Patient newPatient = new Patient(patientName, patientGender, patientAge);
                    List<Patient> patientsToAdd = new ArrayList<>();
                    patientsToAdd.add(newPatient);
                    patientService.addHospital(patientsToAdd);
                    System.out.println("Пациент добавлен.");
                    break;

                case 6:
                    System.out.println("Введите имя пациента:");
                    String patientFirstName = scanner.nextLine();
                    Patient foundPatient = patientService.getPatientByFirstName(patientFirstName);
                    if (foundPatient != null) {
                        System.out.println("Найден пациент: " + foundPatient.getFirstName());
                    } else {
                        System.out.println("Пациент с указанным именем не найден.");
                    }
                    break;

                case 7:
                    List<Patient> allPatients = patientService.getAllPatients();
                    if (!allPatients.isEmpty()) {
                        System.out.println("Все пациенты:");
                        for (Patient patient : allPatients) {
                            System.out.println(patient.getFirstName());
                        }
                    } else {
                        System.out.println("Пациенты не найдены.");
                    }
                    break;

                case 8:
                    Map<String, List<Patient>> groupedPatients = patientService.groupingByGender();
                    System.out.println("Пациенты, сгруппированные по полу:");
                    for (Map.Entry<String, List<Patient>> entry : groupedPatients.entrySet()) {
                        System.out.println("Пол: " + entry.getKey());
                        for (Patient patient : entry.getValue()) {
                            System.out.println(patient.getFirstName());
                        }
                    }
                    break;

                case 9:
                    List<Patient> filteredPatients = patientService.filterByAge();
                    if (!filteredPatients.isEmpty()) {
                        System.out.println("Фильтрованные пациенты:");
                        for (Patient patient : filteredPatients) {
                            System.out.println(patient.getFirstName() + " (Возраст: " + patient.getAge() + ")");
                        }
                    } else {
                        System.out.println("Пациенты старше 30 лет не найдены.");
                    }
                    break;

                case 0:
                exit = true;
                break;

                default:
                    System.out.println("Некорректная команда.");
            }
        }

        scanner.close();
            }
        }