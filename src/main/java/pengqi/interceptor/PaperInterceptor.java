package pengqi.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaperInterceptor extends HandlerInterceptorAdapter {
    /**
     * 拦截器方法，在controller处理请求之前执行，用于预处理
     * @param request 请求
     * @param response 响应
     * @param handler 处理器，即处理请求的controller
     * @return 是否继续执行请求，返回false则后续的interceptor和request都不再执行，返回true则执行下一个interceptor
     * 若为最后一个interceptor，则调用当前请求的controller执行
     * @throws Exception exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("调用拦截器，对查询论文列表请求进行拦截...");
        return true;
    }

    /**
     * 拦截器方法，在controller处理请求之后，视图返回渲染之前执行，用于对ModelAndView进行处理
     * @param request 请求
     * @param response 响应
     * @param handler 处理器，即处理请求的controller
     * @param modelAndView ModelAndView对象
     * @throws Exception exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("论文查询请求处理完成，优化ModelAndView...");
        System.out.println("modelAndView:"+modelAndView);
    }

    /**
     * 拦截器方法，在controller整个请求处理结束之后，主要用于资源的清理工作
     * @param request 请求
     * @param response 响应
     * @param handler 处理器，即处理请求的controller
     * @param ex 异常
     * @throws Exception exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("modelAndView已返回，正在清理资源...");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
