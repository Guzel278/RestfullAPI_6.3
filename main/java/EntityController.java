import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class EntityController {
    private final EntityRepository entityRepository;

    public EntityController(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @GetMapping
    public List<Entity> getAllEntities() {
        return entityRepository.getAllEntities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getEntityById(@PathVariable Long id) {
        return entityRepository.getEntityById(id)
                .map(entity -> ResponseEntity.ok().body(entity))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entity> saveEntity(@RequestBody Entity entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityRepository.saveEntity(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        entityRepository.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}
