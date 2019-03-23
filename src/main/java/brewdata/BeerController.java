package brewdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import brewdata.Beer;
import brewdata.BeerRepository;

@Controller
@RequestMapping(path="/brewdata") //setting up routes
public class BeerController {
    @Autowired
    private BeerRepository beerRepository;

    //will return all instances of beer
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Beer> getAllBeers() {
        return beerRepository.findAll();
    }


//    @PostMapping("/addbeer")
//    Beer newBeer(@RequestBody Beer newBeer) {
//        return beerRepository.save(newBeer);
//    }
}