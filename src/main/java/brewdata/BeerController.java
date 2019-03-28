package brewdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.*;

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

    //will return one instance of beer by id
    @GetMapping(path="/onebeer")
    public @ResponseBody Optional<Beer> getOneBeer(@RequestParam String id) {
        return beerRepository.findById(Integer.parseInt(id));
    }

    @PostMapping(path="/addbeer") // Map ONLY POST Requests
    public @ResponseBody String addNewBeer (@RequestParam String name
            , @RequestParam String type , @RequestParam String abv, @RequestParam String desc, @RequestParam String brewery) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Beer beer = new Beer();
        beer.setName(name);
        beer.setType(type);
        beer.setAbv(abv);
        beer.setDescription(desc);
        beer.setBrewery(brewery);
        beerRepository.save(beer);
        return "successfully added " + name + " to the DB";
    }

    @DeleteMapping(path="/removebeer")
    public @ResponseBody String deleteOneBeer(@RequestParam String id) {
        String msg = "deleted " + beerRepository.findById(Integer.parseInt(id)) + " from the DB" ;
        beerRepository.deleteById(Integer.parseInt(id));
        return msg;
    }

}