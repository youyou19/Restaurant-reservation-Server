package reservation_server.service;

//import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.domain.User;
import reservation_server.repository.LoginRepository;

import java.util.Optional;

@Service
@Transactional
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Optional<User> sign(String username, String password){
        return loginRepository.findByPasswordAndAndUsername(password,username);
    }

}
