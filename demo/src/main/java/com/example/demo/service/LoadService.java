package com.example.demo.service;

import com.example.demo.entity.Loading;

import java.util.List;
import java.util.UUID;

public interface LoadService {
    Loading addLoad(Loading loading);
    List<Loading> getLoadsByShipperId(UUID shipperId);
    Loading getLoadById(Long loadId);
    Loading updateLoad(Long loadId, Loading loading);
    void deleteLoad(Long loadId);
}
