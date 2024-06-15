package container;

public class Container {






























     private List<Patient> patients = new Arraylist<>();

     // Phương thức thêm bệnh nhân

     public void addPatient(Patient patient) {
          patients.add(patient);
          System.out.println("Patient " + patient.getIDNumber() + " add patient completed ");

     }

     // Phương thức lấy danh sách bệnh nhân
     public List<Patient> getListPatients() {
          return patients;
     }

     // Phương thức tìm kiếm ID theo bệnh nhân

     public Patient findPatientByID(String id){

          for(int i = 0 ; i < patients.size() ; i++){
               if(patients.get(i).geIDNumber().equals(id)){  // kểm tra bệnh nhân rồi equals xem co trung voi id  nhap voi tim kiem khong
                    return patients.get(i);
               }
          }
          return null;


     }





}
