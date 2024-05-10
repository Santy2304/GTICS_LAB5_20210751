package com.example.gticslab5_20210751.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Technicianid", nullable = false)
    private int id;

    @Size(min = 3, max = 100, message = "El nombre debe estar entre 3 y 100 caractéres")
    @NotBlank
    @Column(name = "Firstname", nullable = false)
    private String firstName;

    @Size(min = 3, max = 100, message = "El apellido debe estar entre 3 y 100 caractéres")
    @NotBlank
    @Column(name = "Lastname", nullable = false)
    private String lastName;

    @Size(min=8, message = "No debe ser inferior a 8 dígitos")
    @Digits(integer = 8,fraction = 0, message = "Debe ingresar números y 8 dígitos exactos")
    @NotBlank
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @Size(min=9, message = "No debe ser inferior a 9 dígitos")
    @Digits(integer = 9,fraction = 0, message = "Debe ingresar números y 9 dígitos exactos")
    @NotBlank
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;

    @NotNull
    @Positive
    @Column(name = "Age", nullable = false)
    private Integer age;

}
