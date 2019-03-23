package brewdata;

import org.springframework.data.repository.CrudRepository;

import brewdata.Beer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called BeerRepository
public interface BeerRepository extends CrudRepository<Beer, Integer> {

}

