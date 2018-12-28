package pengqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pengqi.model.pojo.Paper;
import pengqi.model.service.PaperService;

import java.util.List;

/**
 * paper表的控制器类
 * 用于将关于paper表的url请求映射到处理程序
 */
@Controller
@RequestMapping(value = "/paper")
public class PaperController {
    private PaperService paperService;  //paper表的业务逻辑接口变量

    @Autowired
    public void setPaperService(PaperService paperService){
        this.paperService = paperService;
    }

    @RequestMapping(value = "/queryAllPapers")
    public String queryAllPapers(Model model){
        List<Paper> paperList = paperService.queryAllPaper();
        model.addAttribute("paperList",paperList);
        return "paperListPage";
    }

    @RequestMapping(value = "/toAddPaper")
    public String jumpToAddPaper(){
        return "addPaperPage";
    }

    @RequestMapping(value = "/addPaper")
    public String addPaper(Paper paper){
        paperService.addPaper(paper);
        return "redirect:/paper/queryAllPapers";
    }

    @RequestMapping(value = "/toUpdatePaper")
    public String jumpToUpdatePaper(@RequestParam("paperId") int paperId, Model model){
        model.addAttribute("updatePaper",paperService.queryPaperByID(paperId));
        return "updatePaperPage";
    }

    @RequestMapping(value = "/updatePaper")
    public String updatePaper(Paper paper){
        paperService.updatePaper(paper);
        return "redirect:/paper/queryAllPapers";
    }

    @RequestMapping(value = "/deletePaper/{paperId}")
    public String deletePaper(@PathVariable("paperId") int paperId){
        paperService.deletePaper(paperId);
        return "redirect:/paper/queryAllPapers";
    }

    @RequestMapping("/homePage")
    public String accessIndexPage(){
        return "index";
    }

}
