package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.entities.concretes.WorkType;

import java.util.List;

public interface WorkTypeService {
    DataResult<List<WorkType>> findByAll();
}
