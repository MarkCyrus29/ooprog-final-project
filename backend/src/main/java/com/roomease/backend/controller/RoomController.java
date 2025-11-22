package com.roomease.backend.controller;

import com.roomease.backend.model.Room;
import com.roomease.backend.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000") // dev: allow your Next.js
public class RoomController {

    private final RoomRepository repo;

    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }

    // GET /api/rooms -> list all rooms
    @GetMapping
    public List<Room> list() { 
        return repo.findAll();
    }

    // POST /api/rooms -> create new room
    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room room) {
        Room saved = repo.save(room);
        return ResponseEntity.created(URI.create("/api/rooms/" + saved.getId())).body(saved);
    }

    // GET /api/rooms/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Room> get(@PathVariable String id) {
        Optional<Room> r = repo.findById(id);
        return r.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /api/rooms/{id} -> update room
    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable String id, @RequestBody Room updated) {
        Optional<Room> existing = repo.findById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Room room = existing.get();
        room.setName(updated.getName());
        room.setRent(updated.getRent());
        // names match model: isOccupied, tenantNames
        room.setOccupied(updated.isOccupied());
        room.setTenantNames(updated.getTenantNames());

        Room saved = repo.save(room);
        return ResponseEntity.ok(saved);
    }

    // PATCH /api/rooms/{id} -> partial update
    @PatchMapping("/{id}")
    public ResponseEntity<Room> patch(
            @PathVariable String id,
            @RequestBody Room updated) {
        Optional<Room> existingOpt = repo.findById(id);

        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Room room = existingOpt.get();

        // Only update fields that were provided
        if (updated.getName() != null) {
            room.setName(updated.getName());
        }
        if (updated.getRent() != 0) { // 0 means unchanged
            room.setRent(updated.getRent());
        }
        // Boolean check
        room.setOccupied(updated.isOccupied());

        if (updated.getTenantNames() != null) {
            room.setTenantNames(updated.getTenantNames());
        }

        Room saved = repo.save(room);
        return ResponseEntity.ok(saved);
    }

    // DELETE /api/rooms/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
