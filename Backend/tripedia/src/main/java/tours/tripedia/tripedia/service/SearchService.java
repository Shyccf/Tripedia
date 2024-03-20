package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tours.tripedia.tripedia.dao.SearchDao;
import tours.tripedia.tripedia.model.Spot;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private SearchDao searchDao;

    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public List<Spot> findBySpotNameContaining(String spotName) {
        return searchDao.findBySpotNameContaining(spotName);
    }

    public List<Spot> findByPopularity() {
        return searchDao.findByPopularity();
    }
}
