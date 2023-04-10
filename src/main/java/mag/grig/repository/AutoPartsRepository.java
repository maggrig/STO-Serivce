package mag.grig.repository;

import mag.grig.entity.AutoParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AutoPartsRepository extends JpaRepository<AutoParts, Long> {
    long deleteByIdAllIgnoreCase(Long id);

    @Query("select count(distinct a) from AutoParts a where a.id = :id")
    long countDistinctById(@Param("id") Long id);

}