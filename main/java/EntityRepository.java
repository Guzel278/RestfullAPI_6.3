import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntityRepository {
    private final List<Entity> entities = new ArrayList<>();

    public List<Entity> getAllEntities() {
        return entities;
    }

    public Optional<Entity> getEntityById(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    public Entity saveEntity(Entity entity) {
        entity.setId(System.currentTimeMillis());
        entities.add(entity);
        return entity;
    }

    public void deleteEntity(Long id) {
        entities.removeIf(entity -> entity.getId().equals(id));
    }
}

