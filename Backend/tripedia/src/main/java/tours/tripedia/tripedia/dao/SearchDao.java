package tours.tripedia.tripedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tours.tripedia.tripedia.model.Spot;

import java.util.List;

public interface SearchDao extends JpaRepository<Spot, String> {
    List<Spot> findBySpotNameContaining(String spotName);

    @Query(value = "select * from spot A where (select count(*) from spot B where A.popularity < B.popularity) < 8 order by popularity desc", nativeQuery = true)
    List<Spot> findByPopularity();
}
