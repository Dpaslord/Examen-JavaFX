package org.example.examenfx.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private  String correo;
    private String plataforma;
    private Boolean administrador;
}
