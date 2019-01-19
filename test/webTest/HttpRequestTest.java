package webTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HttpRequestTest {
    private CloseableHttpClient client;
    private String url;     //http请求的url地址

    @Before
    public void setUp() throws Exception {
        url = "http://localhost:8080/ssmDemo/redis/redisTest?paperID=3";
        HttpClientBuilder builder = HttpClientBuilder.create();
        client = builder.build();
    }

    /**
     * HttpClient模拟请求测试，同步Get方式的请求
     * @throws ClientProtocolException 请求协议异常
     * @throws IOException IO异常
     */
    @Test
    public void doGetHttpRequest() throws ClientProtocolException, IOException {
        HttpUriRequest httpGet = new HttpGet(url);
        /* 服务器返回的响应 */
        CloseableHttpResponse chr = client.execute(httpGet);
        /* 请求响应中的内容，一般为html文件 */
        HttpEntity httpEntity = chr.getEntity();
        if(httpEntity!=null){
            String entityStr = EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(entityStr);
        }
    }
}
