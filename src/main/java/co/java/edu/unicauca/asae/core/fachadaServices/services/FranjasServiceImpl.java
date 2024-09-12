package co.java.edu.unicauca.asae.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.java.edu.unicauca.asae.core.capaAccesoADatos.models.FranjasEntity;
import co.java.edu.unicauca.asae.core.capaAccesoADatos.repositories.FranjasRepository;
import co.java.edu.unicauca.asae.core.fachadaServices.DTO.FranjasDTO;

@Service
public class FranjasServiceImpl implements IFranjasService {

    private FranjasRepository servicioAccesoBaseDatos;

    private ModelMapper modelMapper;

    public FranjasServiceImpl(FranjasRepository servicioAccesoBaseDatos, ModelMapper modelMapper){
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;   
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FranjasDTO> findAll() {
        List<FranjasEntity> franjasEntitys = this.servicioAccesoBaseDatos.findAll();
        List<FranjasDTO> franjasDTOs = this.modelMapper.map(franjasEntitys, new TypeToken<List<FranjasDTO>>(){}.getType());
        return franjasDTOs;
    }

    @Override
    public FranjasDTO findById(Integer id) {
        FranjasEntity objFranjasEntity = this.servicioAccesoBaseDatos.findById(id);
        FranjasDTO franjasDTO = this.modelMapper.map(objFranjasEntity, FranjasDTO.class);
        return franjasDTO;
    }

    @Override
    public FranjasDTO findByCurso(String curso) {
        FranjasEntity objFranjasEntity = this.servicioAccesoBaseDatos.findByCurso(curso);
        FranjasDTO franjasDTO = this.modelMapper.map(objFranjasEntity, FranjasDTO.class);
        return franjasDTO;
    }


    @Override
    public FranjasDTO save(FranjasDTO franja) {
        FranjasEntity franjasEntity = this.modelMapper.map(franja, FranjasEntity.class);
        FranjasEntity objFranjasEntity = this.servicioAccesoBaseDatos.save(franjasEntity);
        FranjasDTO franjasDTO = this.modelMapper.map(objFranjasEntity, FranjasDTO.class);
        return franjasDTO;
    }

    @Override
    public FranjasDTO update(Integer id, FranjasDTO franja) {
        FranjasEntity franjasEntity = this.modelMapper.map(franja, FranjasEntity.class);
        FranjasEntity objFranjasEntity = this.servicioAccesoBaseDatos.update(id,franjasEntity);
        FranjasDTO franjasDTO = this.modelMapper.map(objFranjasEntity, FranjasDTO.class);
        return franjasDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public boolean deleteCurso(String curso) {
        return this.servicioAccesoBaseDatos.deleteCurso(curso);
    }

}
