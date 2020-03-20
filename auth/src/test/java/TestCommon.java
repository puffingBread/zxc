import com.bread.zxc.auth.server.AuthApplication;
import com.bread.zxc.auth.service.OAuthAgentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/8/1.
 */

@SpringBootTest(classes = AuthApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local")
public class TestCommon {

    @Autowired
    OAuthAgentService oAuthAgentService;

    @Test
    public void testUtils() throws Exception {

    }
}
