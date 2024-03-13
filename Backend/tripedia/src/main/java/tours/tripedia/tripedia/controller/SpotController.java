package tours.tripedia.tripedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.Spot;
import tours.tripedia.tripedia.service.SpotService;

import java.util.List;
import java.util.Optional;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("api/spot")
@CrossOrigin(origins = crossOriginUrl)
public class SpotController {
    private SpotService spotService;

    @Autowired
    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping
    public List<Spot> getAllSpot() {
        return spotService.getAllSpot();
    }

    @GetMapping(path = "{id}")
    public Optional<Spot> getSpotById(@PathVariable("id") Long id) {
        return spotService.getSpotById(id);
    }

    @GetMapping("/add")
    public ResponseEntity<String> addSpot(@RequestBody Spot spot) {
        try {
            Spot savedSpot = spotService.addSpot(spot);

            return ResponseEntity.ok("Added Spot: " + spot.toString());
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete")
    public void deleteSpot(@RequestBody Spot spot) {
        spotService.deleteSpot(spot);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteSpotById(@PathVariable("id") Long id) {
        spotService.deleteSpotById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateSpot(@RequestBody Spot spot) {
        try {
            Spot savedSpot = spotService.updateSpot(spot);

            return ResponseEntity.ok("Updated Spot: " + spot.toString());
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
