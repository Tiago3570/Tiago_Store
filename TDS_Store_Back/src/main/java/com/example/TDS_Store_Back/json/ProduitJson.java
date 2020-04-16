package com.example.TDS_Store_Back.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitJson {

    private Long id;


    @Length(min=3,max=20, message="la longueur du nom être comprise entre 3 et 20 caractères message facultatif")
    @Valid
    private String nom;

    @NotNull(message = "Le prix ne peut pas être null")
    @DecimalMin("1.00")
    private Float prix;

    private Date creationDate;

    private Date modificationDate;
}
