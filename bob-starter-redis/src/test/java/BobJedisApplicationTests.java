import com.bob.jediscluster.autoconfigure.JedisAutoConfiguration;
import com.bob.jediscluster.client.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JedisAutoConfiguration.class})
public class BobJedisApplicationTests {

    @Autowired
    private RedisClient redisClient;

    @Test
    public void test() throws Exception {
        redisClient.set("name", "bob");
        System.out.println("res=========" + redisClient.get("name"));
    }

}
