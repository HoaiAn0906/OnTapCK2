package org.example.ontapck2.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long expId;
    private String company;
    private LocalDate fromDate;
    private LocalDate toDate;
    @Column(name = "work_desc")
    private String workDesc;

    @Column(name = "role", columnDefinition = "tinyint")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(String company, LocalDate fromDate, LocalDate toDate, String workDesc, Role role) {
        this.company = company;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.workDesc = workDesc;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expId=" + expId +
                ", company='" + company + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", workDesc='" + workDesc + '\'' +
                ", role=" + role +
                '}';
    }
}
