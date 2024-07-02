package org.exercice05_furniture.service;

import org.exercice05_furniture.dao.FurnitureRepository;
import org.exercice05_furniture.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService implements BaseService<Furniture> {

    private final FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public void save(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void update(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void delete(Furniture furniture) {
        furnitureRepository.delete(furniture);
    }

    @Override
    public Furniture findById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Furniture> findAll() {
        return furnitureRepository.findAll();
    }
}
