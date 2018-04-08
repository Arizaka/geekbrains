package xyz.shuttle.filebox.frontend.services.auth;

import org.springframework.stereotype.Service;
import xyz.shuttle.filebox.frontend.dao.LoginDaoData;

@Service
public class Authentication implements AuthenticationService {
    private LoginDaoData loginDaoData = new LoginDaoData();

    @Override
    public boolean login(String login, String password) {
        return loginDaoData.getLoginPassword().get(login) != null &&
                loginDaoData.getLoginPassword().get(login).equals(password);
    }

    @Override
    public void logout() {

    }
}