package jobayed.ratingdataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserRating {
    private List<Rating> rating;
}
