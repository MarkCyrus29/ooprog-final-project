package com.roomease.backend.controller;

import com.roomease.backend.model.Tenant;
import com.roomease.backend.repository.TenantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "http://localhost:3000") // allow Next.js frontend
public class TenantController {

  private final TenantRepository repo;

  public TenantController(TenantRepository repo) {
    this.repo = repo;
  }

  // GET /api/tenants -> list all tenants
  @GetMapping
  public List<Tenant> list() {
    return repo.findAll();
  }

  // POST /api/tenants -> create new tenant
  @PostMapping
  public ResponseEntity<Tenant> create(@RequestBody Tenant tenant) {
    Tenant saved = repo.save(tenant);
    return ResponseEntity.created(URI.create("/api/tenants/" + saved.getId())).body(saved);
  }

  // GET /api/tenants/{id} -> get a tenant by id
  @GetMapping("/{id}")
  public ResponseEntity<Tenant> get(@PathVariable String id) {
    Optional<Tenant> t = repo.findById(id);
    return t.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  // PUT /api/tenants/{id} -> update tenant
  @PutMapping("/{id}")
  public ResponseEntity<Tenant> update(@PathVariable String id, @RequestBody Tenant updated) {
    Optional<Tenant> existing = repo.findById(id);

    if (existing.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Tenant tenant = existing.get();
    tenant.setName(updated.getName());
    tenant.setRent(updated.getRent());
    tenant.setRoomName(updated.getRoomName());

    Tenant saved = repo.save(tenant);
    return ResponseEntity.ok(saved);
  }

  // PATCH /api/tenants/{id} -> partial update
  @PatchMapping("/{id}")
  public ResponseEntity<Tenant> patch(@PathVariable String id, @RequestBody Tenant updated) {
    Optional<Tenant> existingOpt = repo.findById(id);

    if (existingOpt.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Tenant tenant = existingOpt.get();

    if (updated.getName() != null) {
      tenant.setName(updated.getName());
    }
    if (updated.getRent() != 0) { // 0 = unchanged
      tenant.setRent(updated.getRent());
    }
    if (updated.getRoomName() != null) {
      tenant.setRoomName(updated.getRoomName());
    }

    Tenant saved = repo.save(tenant);
    return ResponseEntity.ok(saved);
  }

  // DELETE /api/tenants/{id} -> delete tenant
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    if (!repo.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
