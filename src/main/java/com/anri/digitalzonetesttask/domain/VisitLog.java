package com.anri.digitalzonetesttask.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name="visits")
public class VisitLog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="username")
    private String username;

    @NotNull
    @Column(name="web_site")
    private String webSite;

    @Column(name="action_date")
    private LocalDate actionDate = LocalDate.now();
}
