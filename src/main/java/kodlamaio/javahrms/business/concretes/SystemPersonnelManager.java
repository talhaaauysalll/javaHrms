package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.business.abstracts.SystemPersonnelService;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.SystemPersonnelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, JobAdvertisementService jobAdvertisementService) {
        this.systemPersonnelDao = systemPersonnelDao;
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @Override
    public Result confirmJobAdvertisement(boolean advertisementIsConfirm,int id) {
        this.jobAdvertisementService.setJobAdvertisementIsActive(advertisementIsConfirm,id);
        return new SuccessResult(true,"İş İlanı Onaylandı...");
    }
}
