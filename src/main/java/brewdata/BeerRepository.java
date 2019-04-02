package brewdata;

import org.springframework.data.repository.CrudRepository;

import brewdata.Beer;

import java.util.Optional;

import java.util.*;


// This will be AUTO IMPLEMENTED by Spring into a Bean called BeerRepository
public interface BeerRepository extends CrudRepository<Beer, Integer> {

    Optional<Beer> findByNameIn(String name);

    List<Beer> findByTypeIn(String type);

    List<Beer> findByBreweryIn(String brewery);

}



