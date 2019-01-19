package pengqi.commons.webSocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 此类用来测试WebSocket
 * 注解@ServerEndpoint将该类定义为一个WebSocket服务器端
 * @author pengqi create on 2019/1/14
 */
@ServerEndpoint(value = "/webSocket")
public class WebSocketTest {
    //静态变量，用来记录当前在线人数
    private static int onlineCount = 0;

    //用来存放每个客户端对应的myWebSocket对象
    private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<>();

    //与客户端的连接会话
    private Session session;

    /**
     * 连接建立成功之后调用的方法
     * @param session 服务端和客户端的连接会话session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        WebSocketTest.webSocketSet.add(this);   //将此连接加入WebSocket管理Set中
        addOnlineCount();   //连接成功建立后，在线人数+1
        System.out.println("WebSocket连接成功！当前在线人数 "+getOnlineCount()+" 人");
    }

    /**
     * 连接关闭时调用的方法
     */
    @OnClose
    public void onClose(){
        WebSocketTest.webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("一个WebSocket连接以断开！当前在线人数 "+getOnlineCount()+" 人");
    }

    /**
     * 收到客户端的消息时调用的方法
     * @param message 客户端消息
     * @param session 服务端和客户端的连接会话session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("收到客户端的消息："+message);
        //将此消息发送到所有与此服务器端建立Socket连接的客户端
        for(WebSocketTest webSocketTest:WebSocketTest.webSocketSet){
            try{
                webSocketTest.sendMessage(message);
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用此方法
     * @param session 服务端和客户端的连接会话session
     * @param error 错误类型
     */
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误！");
        error.printStackTrace();
    }

    /**
     * 向一个WebSocket连接的客户端发送消息message
     * @param message 消息
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 获取当前在线人数
     * @return 当前在线人数
     */
    private static synchronized int getOnlineCount(){
        return onlineCount;
    }

    /**
     * 当前在线人数+1
     */
    private static synchronized void addOnlineCount(){
        WebSocketTest.onlineCount++;
    }

    /**
     * 当前在线人数-1
     */
    private static synchronized void subOnlineCount(){
        WebSocketTest.onlineCount--;
    }
}
