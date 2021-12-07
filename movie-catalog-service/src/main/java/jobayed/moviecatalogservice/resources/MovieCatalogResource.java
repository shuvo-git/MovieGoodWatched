package jobayed.moviecatalogservice.resources;

import jobayed.moviecatalogservice.dto.CatalogItem;
import jobayed.moviecatalogservice.dto.Movie;
import jobayed.moviecatalogservice.dto.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
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
        List<Rating> ratings = Arrays.asList(
            new Rating("1234",4),
            new Rating("1235",5),
            new Rating("1236",6)
        );


        return ratings.stream()
            .map(rating -> {
                Movie movie = restTemplate.getForObject("http://localhost:9092/movies/"+rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), "TEst",rating.getRating());

            })
            .collect(Collectors.toList());

        // For each movie IDs call movie info service and get details

        // put them all together

    }
}

//        return Collections.singletonList(
//                new CatalogItem("Transformers","TEst",4)
//                new CatalogItem("Shawshank REdemption","",9),
//                new CatalogItem("The Hobbit","Thriller",8),
//                new CatalogItem("Lord of the Rings","TEst",8)
//        );
