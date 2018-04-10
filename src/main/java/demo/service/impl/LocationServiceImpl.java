package demo.service.impl;

import demo.domain.Location;
import demo.domain.LocationRespository;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hectorlueng on 4/9/18.
 */

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRespository locationRespository;

    @Autowired
    public LocationServiceImpl(LocationRespository locationRespository) {
        this.locationRespository = locationRespository;
    }

    @Override
    public List<Location> saveRunningLocation(List<Location> runningLocations) {
        return locationRespository.save(runningLocations);
    }

    @Override
    public void deleteAll() {
        locationRespository.deleteAll();
    }

    @Override
    public Page<Location> findByRunnerMovementType(String movementType, Pageable pageable) {
        return locationRespository.findByRunnerMovementType(
                // Enum.valueOf(String)
                Location.RunnerMovementType.valueOf(movementType), pageable);
    }

    @Override
    public Page<Location> findByUnitInfoRunningId(String runningId, Pageable pageable) {
        return locationRespository.findByUnitInfoRunningId(runningId, pageable);
    }
}
