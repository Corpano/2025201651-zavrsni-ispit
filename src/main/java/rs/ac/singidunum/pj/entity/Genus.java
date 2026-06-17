package rs.ac.singidunum.pj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "genus")
@NoArgsConstructor
@Getter
@Setter
public class Genus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genusId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String latinName;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
