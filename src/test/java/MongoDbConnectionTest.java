import static org.assertj.core.api.Assertions.assertThat;

import com.devteam45ldm.ldm.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest(classes = Application.class)
public class MongoDbConnectionTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongoDbConnection() {
        // Check if the connection to the MongoDB is successful by performing a simple operation
        boolean collectionExists = mongoTemplate.collectionExists("admin");
        assertThat(collectionExists).isTrue();
    }
}