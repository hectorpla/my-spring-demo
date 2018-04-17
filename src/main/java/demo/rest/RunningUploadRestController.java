package demo.rest;

import demo.domain.Location;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hectorlueng on 4/9/18.
 */

@RestController
public class RunningUploadRestController {
    private LocationService locationService;

    @Autowired
    public RunningUploadRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Location> locations) {
        this.locationService.saveRunningLocation(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    void purge() {
        this.locationService.deleteAll();
    }

    @RequestMapping(value = "/running/{movementType}", method = RequestMethod.GET)
    public Page<Location> findByMovementType(@PathVariable String movementType,
                                             @RequestParam(name = "page") int page,
                                             @RequestParam(name = "size") int size) {
        return this.locationService.findByRunnerMovementType(movementType, new PageRequest(page, size));
    }

    @RequestMapping(value = "/running/runningId/{runningId}", method = RequestMethod.GET)
    public Page<Location> findByRunningId(@PathVariable String runningId,
                                          @RequestParam(name = "page") int page,
                                          @RequestParam(name = "size") int size) {
        return this.locationService.findByUnitInfoRunningId(runningId, new PageRequest(page, size));
    }

}
