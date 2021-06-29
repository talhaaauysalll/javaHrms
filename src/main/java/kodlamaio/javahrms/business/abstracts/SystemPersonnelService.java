package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.Result;

public interface SystemPersonnelService {
    Result confirmJobAdvertisement(boolean advertisementIsConfirm,int id);
}
