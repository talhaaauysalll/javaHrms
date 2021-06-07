package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.SystemPersonnelService;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.SystemPersonnelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        this.systemPersonnelDao = systemPersonnelDao;
    }


}
