package org.example.ontapck2.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long canId;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    private String phone;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Experience> experiences;

    public Candidate(String email, String fullName, String phone, List<Experience> experiences) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.experiences = experiences;
    }
}
