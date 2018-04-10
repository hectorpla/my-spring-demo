package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by hectorlueng on 4/9/18.
 */
public interface LocationRespository extends JpaRepository<Location, Long> {
    Page<Location> findByRunnerMovementType(@Param("momentType") Location.RunnerMovementType movementType, Pageable pageable);
    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId, Pageable pageable);
}
