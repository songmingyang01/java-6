package Try_final;

import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private int id;
    private String sex;

    public People(String name, int id, String sex){
        setId(id);
        setName(name);
        setSex(sex);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setSex(String sex){
        this.sex = sex;
    }

}
