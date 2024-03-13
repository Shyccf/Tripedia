package tours.tripedia.tripedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tours.tripedia.tripedia.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("Select userId from User u where u.userName = :name")
    public Long findId(@Param("name") String name);
}
