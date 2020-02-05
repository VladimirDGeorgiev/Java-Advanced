package softuni.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {

    Game findGameById(Integer id);

    Game findByTitle(String title);
}
