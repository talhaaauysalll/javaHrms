package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.WorkTypeService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.javahrms.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeManager implements WorkTypeService {


    private WorkTypeDao workTypeDao;

    @Autowired
    public WorkTypeManager(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }


    @Override
    public DataResult<List<WorkType>> findByAll() {
        return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll());
    }
}
