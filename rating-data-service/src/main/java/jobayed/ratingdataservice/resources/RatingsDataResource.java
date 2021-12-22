package jobayed.ratingdataservice.resources;

import jobayed.ratingdataservice.dto.Rating;
import jobayed.ratingdataservice.dto.UserRating;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratingsData/")
public class RatingsDataResource
{

    @RequestMapping(value = "/{movieId}",method = RequestMethod.GET)
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId,4);
    }

    @RequestMapping(value = "/users/{userId}",method = RequestMethod.GET)
    public UserRating getUserRating(@PathVariable("userId") String userId)
    {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4),
                new Rating("1235",5),
                new Rating("1236",6)
        );

        UserRating userRating = new UserRating();
        userRating.setRating(ratings);

        return userRating;
    }
}
