package jobayed.moviecatalogservice.resources;

import jobayed.moviecatalogservice.dto.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("catalog/")
public class MOvieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        return Collections.singletonList(
                new CatalogItem("Transformers","TEst",4)
//                new CatalogItem("Shawshank REdemption","",9),
//                new CatalogItem("The Hobbit","Thriller",8),
//                new CatalogItem("Lord of the Rings","TEst",8)
        );
    }
}
