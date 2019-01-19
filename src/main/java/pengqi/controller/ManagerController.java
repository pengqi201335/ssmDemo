package pengqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pengqi.model.pojo.Manager;
import pengqi.model.pojo.Papermanager;
import pengqi.model.service.ManagerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * paperManager表的控制器类
 * 用于将关于paperManager表的url请求映射到处理程序
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/checkManagerExist/{managerName}")
    public String checkManagerExist(@PathVariable("managerName") String managerName, Model model){
        Manager queryManager = managerService.queryManagerByID(managerName);
        String checkResult;
        if(queryManager!=null){
            checkResult="正确的账号名";
        }
        else{
            checkResult="账号名不存在";
        }
        //向model中加入查询结果的检查信息
        model.addAttribute("checkResult",checkResult);
        return "checkManagerName";
    }

//    @RequestMapping(value = "/managerLogin",method = {RequestMethod.POST})
//    @ResponseBody
//    public String managerLogin(@RequestParam("managerName") String managerName, @RequestParam("password") String password, Model model){
//        Manager manager = managerService.queryManagerByID(managerName);
//        String res;     //验证信息
//        if(manager==null){
//            //账号名不存在
//            res = "error1";
//        }
//        else if(!manager.getPassword().equals(password)){
//            //密码错误
//            res = "error2";
//        }
//        else{
//            //输入正确
//            res = "ok";
//        }
//        System.out.println(res);
//        return res;
//    }

    @RequestMapping(value = "/managerLogin",method = {RequestMethod.POST})
    public void managerLogin(@RequestParam("managerName") String managerName,
                               @RequestParam("password") String password,
                               HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Manager manager = managerService.queryManagerByID(managerName);
        if(manager==null){
            //账号名不存在
            out.print("<script language=\"javascript\">alert('账号不存在！');window.location.href='/ssmDemo/paper/homePage'</script>");
        }
        else if(!manager.getPassword().equals(password)){
            //密码错误
            out.print("<script language=\"javascript\">alert('密码错误！');window.location.href='/ssmDemo/paper/homePage'</script>");
        }
        else{
            //输入正确
            out.print("<script language=\"javascript\">alert('登录成功！');window.location.href='/ssmDemo/paper/queryAllPapers'</script>");
        }
    }

    @RequestMapping(value = "/WebSocketConn")
    public String jumpToSocketConn(){
        return "webSocketManagerPage";
    }

    /**
     * 测试mybatis逆向工程的控制器
     * @return 返回信息
     */
    @RequestMapping(value = "/generator")
    @ResponseBody
    public String generatorTest(){
        List<Papermanager> papermanagerList = managerService.fuzzyQuery("%ng%");
        return papermanagerList.get(0).getPassword();
    }
}
