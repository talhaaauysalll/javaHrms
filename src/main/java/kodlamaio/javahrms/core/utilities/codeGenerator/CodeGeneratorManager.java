package kodlamaio.javahrms.core.utilities.codeGenerator;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CodeGeneratorManager implements CodeGeneratorService{
    @Override
    public int deriveCode() {
        Random random=new Random();
        int code=100000+random.nextInt(999999);
        return code;
    }
}
