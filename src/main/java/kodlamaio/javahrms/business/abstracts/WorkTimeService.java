package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    DataResult<List<WorkTime>> findByAll();
}
