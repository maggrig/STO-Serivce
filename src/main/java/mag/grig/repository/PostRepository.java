package mag.grig.repository;

import mag.grig.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<Post> findAll();
}