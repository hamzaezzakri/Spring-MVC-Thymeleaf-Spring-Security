package net.ezzakri.hospitalapp;

import net.ezzakri.hospitalapp.entities.Patient;
import net.ezzakri.hospitalapp.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(PatientRepository patientRepository){
        return args -> {

            Patient p1 = new Patient();
            p1.setNom("Mourad");
            p1.setPrenom("Lah");
            p1.setDateNaissance(new Date());
            p1.setMalade(false);
            p1.setScore(1);

            Patient p2 = new Patient(null, "Jamal", "Med", new Date(), 1, false);

            Patient p3 = Patient.builder()
                    .nom("Yassine")
                    .prenom("Med")
                    .dateNaissance(new Date())
                    .malade(true)
                    .score(1)
                    .build();
            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
