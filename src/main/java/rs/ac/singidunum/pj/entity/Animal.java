package rs.ac.singidunum.pj.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animal")
@NoArgsConstructor
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer animalId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "genus_id", nullable = false)
    private Genus genus;

    @Column(nullable = false)
    private String commonName;

    @Column(nullable = false)
    private String latinName;

    @Column(nullable = false)
    private String habitat;

    @Column(nullable = false)
    private String diet;

    @Column(nullable = false)
    private String conservationStatus;

    private String imageUrl;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
