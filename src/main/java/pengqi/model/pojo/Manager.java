package pengqi.model.pojo;

/**
 * 管理员实体
 */
public class Manager {
    private int managerID;          //管理员编号
    private String managerName;     //管理员账号名
    private String password;        //登录密码

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "name: "+managerName;
    }
}
