package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.CityService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.dataAccess.abstracts.CityDao;
import kodlamaio.javahrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> findByAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }
}
