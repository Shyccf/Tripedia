package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tours.tripedia.tripedia.dao.SpotDao;
import tours.tripedia.tripedia.model.Spot;

import java.util.List;
import java.util.Optional;

@Service
public class SpotService {
    private SpotDao spotDao;

    @Autowired
    public SpotService(SpotDao spotDao) {
        this.spotDao = spotDao;
    }

    public Spot addSpot(Spot spot) {
        if (spot.getSpotName().isEmpty() || spot.getSpotName() == null) {
            throw new RuntimeException("Spot name can not be empty!");
        }

        if (spot.getIntroduction().isEmpty() || spot.getIntroduction() == null) {
            throw new RuntimeException("Spot introduction can not be empty!");
        }

        if (spot.getAddress().isEmpty() || spot.getAddress() == null) {
            throw new RuntimeException("Spot address can not be empty!");
        }

        return spotDao.save(spot);
    }

    public List<Spot> getAllSpot() {
        return (List<Spot>) spotDao.findAll();
    }

    public Optional<Spot> getSpotById(Long spotId) {
        return spotDao.findById(spotId);
    }

    public void deleteSpot(Spot spot) {
        if (!spotDao.existsById(spot.getSpotId())) {
            throw new RuntimeException("Spot does not exist!");
        }

        spotDao.delete(spot);
    }

    public void deleteSpotById(Long spotId) {
        if (!spotDao.existsById(spotId)) {
            throw new RuntimeException("Spot does not exist!");
        }

        spotDao.deleteById(spotId);
    }

    public Spot updateSpot(Spot spot) {
        if (spot.getSpotId() == null) {
            throw new RuntimeException("Spot can not be found");
        }

        return spotDao.save(spot);
    }
}
