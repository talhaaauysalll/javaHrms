package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> findByAll();
}
