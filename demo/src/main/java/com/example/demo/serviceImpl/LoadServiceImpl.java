package com.example.demo.serviceImpl;

import com.example.demo.entity.Loading;
import com.example.demo.repository.LoadRepository;
import com.example.demo.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Loading addLoad(Loading loading) {
        return loadRepository.save(loading);
    }

    @Override
    public List<Loading> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    @Override
    public Loading getLoadById(Long loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }

    @Override
    public Loading updateLoad(Long loadId, Loading loading) {
        return loadRepository.findById(loadId).map(existingLoad -> {
            existingLoad.setLoadingPoint(loading.getLoadingPoint());
            existingLoad.setUnloadingPoint(loading.getUnloadingPoint());
            existingLoad.setProductType(loading.getProductType());
            existingLoad.setTruckType(loading.getTruckType());
            existingLoad.setNoOfTrucks(loading.getNoOfTrucks());
            existingLoad.setWeight(loading.getWeight());
            existingLoad.setComment(loading.getComment());
            existingLoad.setDate(loading.getDate());
            return loadRepository.save(existingLoad);
        }).orElse(null);
    }

    @Override
    public void deleteLoad(Long loadId) {
        loadRepository.findById(loadId).ifPresent(loadRepository::delete);
    }
}
