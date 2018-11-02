import com.puffingBread.zxc.common.json.Json;
import com.puffingBread.zxc.server.BlogApplication;
import com.puffingBread.zxc.service.DynamicService;
import com.puffingBread.zxc.vo.DynamicVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDynamic {

    @Autowired
    DynamicService dynamicService;

    @Test
    public void getUserById() {

        List<DynamicVo> dynamicVoList = dynamicService.getByUserId(1001l);
        System.out.println("===================" + Json.toJson(dynamicVoList));
    }
}
