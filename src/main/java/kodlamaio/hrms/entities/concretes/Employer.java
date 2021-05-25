package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor

@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id") // amk ben niye burdayım nee bb
public class Employer extends User { // bu lazım @PrimaryKeyJoinColumn(name = "id") bide bu extends User


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;
}