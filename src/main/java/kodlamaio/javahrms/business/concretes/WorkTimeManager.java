package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.WorkTimeService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.javahrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeManager implements WorkTimeService {

    private WorkTimeDao workTimeDao;

    @Autowired
    public WorkTimeManager(WorkTimeDao workTimeDao) {
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> findByAll() {
        return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll());
    }
}
