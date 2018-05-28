package xyz.shuttle.filebox.frontend.persistence;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import xyz.shuttle.filebox.frontend.domain.User;
import xyz.shuttle.filebox.frontend.domain.UserField;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<User> findByUserName(@NonNull String username) {
        return Optional.ofNullable(
                mongoTemplate.findOne(
                        query(
                                where(UserField.USER_NAME.field()).is(username))

                        , User.class));
    }

    public List<User> findAllUsers(){
        return mongoTemplate.findAll(User.class);
    }

    public void updateUser(@NonNull String username, boolean enabled){
        mongoTemplate.updateFirst(
                query(
                        where(UserField.USER_NAME.field()).is(username)
                ),
                new Update().set("enabled", enabled),
                User.class
        );
    }

    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}
