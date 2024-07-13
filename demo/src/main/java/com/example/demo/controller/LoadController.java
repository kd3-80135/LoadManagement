package com.example.demo.controller;

import com.example.demo.entity.Loading;
import com.example.demo.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Loading loading) {
        loadService.addLoad(loading);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Loading>> getLoadsByShipperId(@RequestParam UUID shipperId) {
        List<Loading> loadings = loadService.getLoadsByShipperId(shipperId);
        return ResponseEntity.ok(loadings);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Loading> getLoadById(@PathVariable Long loadId) {
        Loading loading = loadService.getLoadById(loadId);
        return loading != null ? ResponseEntity.ok(loading) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody Loading updatedLoad) {
        Loading loading = loadService.updateLoad(loadId, updatedLoad);
        return loading != null ? ResponseEntity.ok("Load updated successfully") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}
