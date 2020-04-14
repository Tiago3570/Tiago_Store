package com.example.TDS_Store_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Commande")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_CLIENT")
    private String idClient;

    @CreatedDate
    @Column(name = "CREATION_DATE", updatable = false, nullable = false)
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;
}
