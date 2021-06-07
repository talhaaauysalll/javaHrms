package kodlamaio.javahrms.adapters;

import kodlamaio.javahrms.business.abstracts.FakeCheckService;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisCheckAdapter implements FakeCheckService {
    @Override
    public boolean check(String firstName, String lastName, String nationalityId, int year) {
        if((nationalityId.length() != 11) || (nationalityId.startsWith("0"))){
            return false;
        }
        if((firstName.length()<2)){
            return false;
        }
        return true;
    }
}
