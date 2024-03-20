package tours.tripedia.tripedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.Spot;
import tours.tripedia.tripedia.service.SearchService;

import java.util.List;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("api/search")
@CrossOrigin(origins = crossOriginUrl)
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/findBySpotNameContaining")
    public List<Spot> findBySpotNameLike(@RequestParam("spotName") String spotName) {
        return searchService.findBySpotNameContaining(spotName);
    }

    @GetMapping("/findByPopularity")
    public List<Spot> findByPopularity() {
        return searchService.findByPopularity();
    }
}
