package jobayed.ratingdataservice.resources;

import jobayed.ratingdataservice.dto.Rating;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratingsData/")
public class RatingsDataResource
{
    @RequestMapping("test")
    public String hello(){
        return "hello";
    }
    @RequestMapping(value = "/{movieId}",method = RequestMethod.GET)
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId,4);
    }
}
