package co.java.edu.unicauca.asae.core.capaAccesoADatos.repositories;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.java.edu.unicauca.asae.core.capaAccesoADatos.models.FranjasEntity;

@Repository
public class FranjasRepository {
    
    private ArrayList<FranjasEntity> listaDeFranjas;

    public FranjasRepository(){
        this.listaDeFranjas = new ArrayList<FranjasEntity>();
        cargarFranjas();
    }

    public List<FranjasEntity> findAll(){
        System.out.println("invocando a listar todas las franjas");
        return this.listaDeFranjas;
    }

    public FranjasEntity findById(Integer id){
        System.out.println("invocando a buscar franja por id");
        FranjasEntity objetoFranjas = null;

        for (FranjasEntity franjas : listaDeFranjas) {
            if(franjas.getId() == id){
                objetoFranjas = franjas;
                break;
            }
        }
        return objetoFranjas;
    }

    public FranjasEntity findByCurso(String curso){
        System.out.println("invocando a buscar curso por id");
        FranjasEntity objetoFranjas = null;

        for (FranjasEntity franjas : listaDeFranjas) {
            if(franjas.getCurso().equals(curso)){
                objetoFranjas = franjas;
                break;
            }
        }
        return objetoFranjas;
    }

    public FranjasEntity save (FranjasEntity franjas){
        System.out.println("invocando a guardar franja");

        FranjasEntity objetoFranjas = null;
        if(this.listaDeFranjas.add(franjas)){
            objetoFranjas = franjas;
        }
        return objetoFranjas;
    }

    public FranjasEntity update(Integer id, FranjasEntity franja){
        System.out.println("invocando a actualizar franja");
        FranjasEntity objetoFranjas = null;

        for (int i = 0; i < this.listaDeFranjas.size(); i++) {
            if(this.listaDeFranjas.get(i).getId() == id){
                this.listaDeFranjas.set(i, franja);
                objetoFranjas = franja;
                break;
            }   
        }
        return objetoFranjas;
    }

    public boolean delete(Integer id){
        System.out.println("invocando a eliminar franja");
        boolean respuesta = false;

        for (int i = 0; i < this.listaDeFranjas.size(); i++) {
            if(this.listaDeFranjas.get(i).getId() == id){
                this.listaDeFranjas.remove(i);
                respuesta = true;
                break;
            }
        }
        return respuesta;
    }

    public boolean deleteCurso(String curso){
        System.out.println("invocando a eliminar franja");
        boolean respuesta = false;

        for (int i = 0; i < this.listaDeFranjas.size(); i++) {
            if(this.listaDeFranjas.get(i).getCurso().equals(curso)){
                this.listaDeFranjas.remove(i);
                respuesta = true;
            }
        }
        return respuesta;
    }

    private void cargarFranjas() {
		FranjasEntity objCliente1 = new FranjasEntity(1, "sistemas","calculo 1",2, "sala 1", "lunes",LocalTime.of(9,30),LocalTime.of(10,30));
		this.listaDeFranjas.add(objCliente1);
        FranjasEntity objCliente2 = new FranjasEntity(2, "electronica","circuitos",2, "sala 2", "martes",LocalTime.of(9,30),LocalTime.of(10,30));
		this.listaDeFranjas.add(objCliente2);
        FranjasEntity objCliente3 = new FranjasEntity(3, "civil","suelos",1, "sala 3", "miercoles",LocalTime.of(9,30),LocalTime.of(10,30));
		this.listaDeFranjas.add(objCliente3);
        FranjasEntity objCliente4 = new FranjasEntity(4, "mecanica","Lab mecanica 1",1,"sala 4", "jueves",LocalTime.of(9,30),LocalTime.of(10,30));
		this.listaDeFranjas.add(objCliente4);
        FranjasEntity objCliente5 = new FranjasEntity(5, "sistemas","calculo 2",2, "sala 1", "lunes",LocalTime.of(9,30),LocalTime.of(10,30));
		this.listaDeFranjas.add(objCliente5);
	}
}