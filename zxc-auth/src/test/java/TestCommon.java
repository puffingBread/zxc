import com.puffingBread.zxc.common.email.EmailUtil;
import com.puffingBread.zxc.server.AuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/1.
 */

@SpringBootTest(classes = AuthApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCommon {

    @Test
    public void testUtils() throws Exception {
//     * @param sender 发送者邮件地址
//     * @param senderPwd 发送者密码
//     * @param emailSubject 邮件主题
//     * @param htmlMailContent html格式的邮件内容
//     * @param receiverAddressSet 接收者地址集合
        String sender = "xuzeng@smartconns.com";
        String senderPwd = "Xz15919672519.";
        String emailSubject = "上上下下左右左右BABA";
        String htmlMailContent = "<html>我们要怎样进行这令人愉悦的折磨呢 </br> -- 锤石</html>";
        Set<String> receiverAddressSet = new HashSet<>();
        receiverAddressSet.add("778521003@qq.com");
        EmailUtil.sendHtmlMail(sender, senderPwd, emailSubject, htmlMailContent, receiverAddressSet);
    }
}
