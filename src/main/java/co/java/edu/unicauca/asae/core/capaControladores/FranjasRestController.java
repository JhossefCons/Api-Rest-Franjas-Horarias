package co.java.edu.unicauca.asae.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.java.edu.unicauca.asae.core.fachadaServices.DTO.FranjasDTO;
import co.java.edu.unicauca.asae.core.fachadaServices.services.IFranjasService;

@RestController
@RequestMapping("/api")
public class FranjasRestController {

    @Autowired
    private IFranjasService franjasService;

    @GetMapping("/franjas")
    public List<FranjasDTO>  listarFranjas() {
    return franjasService.findAll();
    }

    @GetMapping("/franjas/{id}")
    public FranjasDTO consultarFranja(@PathVariable Integer id){
        FranjasDTO objFranjasDTO = null;
        objFranjasDTO = franjasService.findById(id);
        return objFranjasDTO;
    }

    @PostMapping("/franjas")
	public FranjasDTO crearFranja(@RequestBody FranjasDTO franja) {
		FranjasDTO objFranja = null;
		objFranja = franjasService.save(franja);
		return objFranja;
	}

    @PutMapping("/franjas/{id}")
	public FranjasDTO actualizarFranja(@RequestBody FranjasDTO FranjaDTO, @PathVariable Integer id) {
		FranjasDTO objFranjaDTO = null;
		FranjasDTO FranjaActual = franjasService.findById(id);
		if (FranjaActual != null) {
			objFranjaDTO = franjasService.update(id, FranjaDTO);
		}
		return objFranjaDTO;
	}

	@DeleteMapping("/franjas/{id}")
	public Boolean eliminarFranja(@PathVariable Integer id) {
		Boolean bandera = false;
		FranjasDTO FranjaActual = franjasService.findById(id);
		if (FranjaActual != null) {
			bandera = franjasService.delete(id);
		}
		return bandera;
	}

	@DeleteMapping("/franjas")
	public Boolean eliminarCurso(@RequestParam String curso) {
		Boolean bandera = false;
		FranjasDTO FranjaActual = franjasService.findByCurso(curso);
		if (FranjaActual != null) {
			bandera = franjasService.deleteCurso(curso);
		}
		return bandera;
	}
}
