package demo.service;

import demo.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hectorlueng on 4/9/18.
 */
public interface LocationService {
    List<Location> saveRunningLocation(List<Location> runningLocation);

    void deleteAll();

    Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);

    Page<Location> findByUnitInfoRunningId(String runningId, Pageable pageable);


}
