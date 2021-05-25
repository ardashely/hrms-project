package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_positions")
public class JobPostion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Yazsana umut aq

    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;
}