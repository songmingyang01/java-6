# java-6
实验六 文件输入输出 计202 宋明扬 2020310606
# 一、实验目的
1.掌握文件输入输出；
<br>2.掌握对象序列化方法。
# 二、业务要求
在实验三（学生选课模拟系统）的基础上，利用文件保存选课结果，过程如下：
<br>1.采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；
<br>2.采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作。
<br>3.打印课程对象信息，采用覆盖定义toString（）方法的方式。
# 三、实验要求
提交源程序到gitee或github，代码仓库命名为“实验六 文件输入输出”
<br>写实验报告文件（readme.md），
# 四、解题思路
&emsp;&emsp;**对类“Student”重新进行编辑，实现采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作；采用覆盖定义toString（）方法的方式打印课程对象信息。**
# 五、关键代码
1. Studengt类里面，采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；
```java 
    public void write() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f)); 
        out.writeObject(c);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        out.close();

    }
```
2. Student类里面，采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作。
```
    public void drop_course(int id)throws Exception{
        Course[] d = new Course[5];;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Course[] c = (Course[]) in.readObject();
        int j = 0;
        for(int i=0;i<this.i;i++) {
            int a = c[i].getId();
            if (id == a) {
                continue;
            }
            else {
                d[j] = c[i];
                j++;
            }
        }
        c = d;
        this.c = d;
        System.out.println("您已成功退出该课程,现在课表为");
        show(d);
    }
```
3. Studengt类里面，打印课程对象信息，采用覆盖定义toString（）方法的方式；
```java 
   public void show() throws Exception{
        write();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Course[] c = (Course[]) in.readObject();
        System.out.println("学生课表");
        int k = 1;
        for(int i=0;i<=this.i;i++) {
            if (c[i] == null) {
                continue;
            }
            else {
                System.out.print("课程"+ k);
                System.out.print(" 课程编号："+c[i].getId());
                System.out.print(" 课程名称："+c[i].getTime());
                System.out.print(" 授课教师："+c[i].getTeacher());
                System.out.print(" 上课地点："+c[i].getPlace());
                System.out.print(" 课程人数："+c[i].getStu_num());
                System.out.println(" 上课时间：周"+c[i].getWeek() +" "+ c[i].getTime());
                k++;
            }
        }
    }

}
```
# 六、系统运行截图
&emsp;&emsp;下图是本实验主程序TestBanking.java的运行结果。
<br>![avatar](https://github.com/songmingyang01/java-2/blob/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202021-11-22%20092448.png)
<br>![avatar](https://github.com/songmingyang01/java-2/blob/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202021-11-22%20092623.png)
<br>![avatar](https://github.com/songmingyang01/java-2/blob/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202021-11-22%20092634.png)
# 七、感想与体会
&emsp;&emsp;本次实验是基于实验二三进行了修改和优化，实现了采用对象序列化的writeObject方法把选课结果存到硬盘文件系统中；采用对象序列化的readObject方法从文件中恢复对象，并操作学生的选课课表，实现退课操作；打印课程对象信息，采用覆盖定义toString（）方法的方式。对课上所学知识进行了巩固，对后续相关知识的学习有了很大的帮助。
