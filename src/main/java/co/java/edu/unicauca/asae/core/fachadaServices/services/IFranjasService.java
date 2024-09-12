package co.java.edu.unicauca.asae.core.fachadaServices.services;

import java.util.List;

import co.java.edu.unicauca.asae.core.fachadaServices.DTO.FranjasDTO;


public interface  IFranjasService {

    public List<FranjasDTO> findAll();
    public FranjasDTO findById(Integer id);
    public FranjasDTO findByCurso(String curso);
    public FranjasDTO save (FranjasDTO franja);
    public FranjasDTO update(Integer id, FranjasDTO franja);
    public boolean delete(Integer id);
    public boolean deleteCurso(String curso);
    
}
