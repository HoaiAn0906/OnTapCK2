//package org.example.ontapck2.config;
//
//import lombok.AllArgsConstructor;
//import net.datafaker.Faker;
//import org.example.ontapck2.models.Candidate;
//import org.example.ontapck2.models.Experience;
//import org.example.ontapck2.models.Role;
//import org.example.ontapck2.repositories.CandidateRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@AllArgsConstructor
//public class DataFake {
//    private final CandidateRepository candidateRepository;
//
//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            Faker faker = new Faker();
//
//            for (int i = 0; i < 10; i++) {
//                Candidate candidate = new Candidate();
//                candidate.setEmail(faker.internet().emailAddress());
//                candidate.setFullName(faker.name().fullName());
//                candidate.setPhone(faker.phoneNumber().cellPhone());
//
//                List<Experience> experiences = new ArrayList<>();
//                Experience experience = new Experience();
//                experience.setCompany(faker.company().name());
//                String fromDate = faker.date().past(1000, TimeUnit.DAYS, String.valueOf(LocalDate.now()));
//                LocalDate localDate = LocalDate.parse(fromDate);
//                experience.setFromDate(localDate);
//                String toDate = faker.date().future(1, TimeUnit.DAYS, String.valueOf(LocalDate.now()));
//                LocalDate localDate1 = LocalDate.parse(toDate);
//                experience.setToDate(localDate1);
//                experience.setWorkDesc(faker.lorem().sentence());
//
//                Role[] roles = Role.values();
//                Role randomRole = roles[faker.random().nextInt(roles.length)];
//                experience.setRole(randomRole);
//                experience.setCandidate(candidate);
//
//                experiences.add(experience);
//
//                candidate.setExperiences(experiences);
//
//                candidateRepository.save(candidate);
//            }
//        };
//    }
//}
