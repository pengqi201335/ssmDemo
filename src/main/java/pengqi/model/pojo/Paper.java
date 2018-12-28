package pengqi.model.pojo;

/**
 * 论文实体
 */
public class Paper {
    private int paperId;            //论文编号
    private String paperTitle;      //论文标题
    private int paperRef;           //论文被引次数
    private String paperDetail;     //论文描述

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public int getPaperRef() {
        return paperRef;
    }

    public void setPaperRef(int paperRef) {
        this.paperRef = paperRef;
    }

    public String getPaperDetail() {
        return paperDetail;
    }

    public void setPaperDetail(String paperDetail) {
        this.paperDetail = paperDetail;
    }
}
