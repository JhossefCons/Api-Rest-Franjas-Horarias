package co.java.edu.unicauca.asae.core.fachadaServices.DTO;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FranjasDTO {
	private Integer id;
    private String curso;
    private String asignatura;
    private int  periodo;
    private String salon;
    private String dia;
    private LocalTime diaInicio;
    private LocalTime diaFin;

    public FranjasDTO(){
        
    }
}