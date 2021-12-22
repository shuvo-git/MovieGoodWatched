package jobayed.moviecatalogservice.resources;

import jobayed.moviecatalogservice.dto.CatalogItem;
import jobayed.moviecatalogservice.dto.Movie;
import jobayed.moviecatalogservice.dto.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog/")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        UserRating ratings = restTemplate.getForObject(
            "http://localhost:9093/ratingsData/users/"+userId,
            UserRating.class
        );
        return ratings.getRating().stream()
            .map(rating -> {
                // For each movie ID, call movie info service and get details
                Movie movie = restTemplate.getForObject("http://localhost:9092/movies/"+rating.getMovieId(), Movie.class);

                //Put them altogether
                return new CatalogItem(movie.getName(), "TEst",rating.getRating());

            })
            .collect(Collectors.toList());
    }
}
