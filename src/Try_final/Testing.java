package Try_final;

import java.util.Scanner;

public class Testing {
    public static void main(String[] args)throws Exception{

        Course[] C = new Course[5];

        Teacher t1 = new Teacher(1,"赵老师","男");
        Teacher t2 = new Teacher(2,"钱老师","男");
        Teacher t3 = new Teacher(3,"孙老师","女");
        Teacher t4 = new Teacher(4,"李老师","男");

        Course c1 = new Course(202101,"C语言","教103",1,"15:30-17:100",120);
        C[0] = c1;
        Course c2 = new Course(202102,"线性代数","教302",2,"13:30-15:10",90);
        C[1] = c2;
        Course c3 = new Course(202103,"大学化学","教300",3,"19:00-20:35",60);
        C[2] = c3;
        Course c4 = new Course(202104,"Java","1710",4,"8:00-9:40",60);
        C[3] = c4;

        //给每门课程分配老师
        c1.setTeacher(t1);
        c2.setTeacher(t2);
        c3.setTeacher(t3);
        c4.setTeacher(t4);


        Scanner in = new Scanner(System.in);

        System.out.println("\n********************北京石油化工学院教务处********************\n"+
                "                      请选择您的身份:\n"+
                "                教师系统请按1  学生系统请按2");

        int iddd = in.nextInt();

        if (iddd == 1) {
            System.out.println("请输入ID：");
            int id = in.nextInt();
            System.out.println("请输入姓名：");
            String name = in.next();
            System.out.println("请输入性别：");
            String sex = in.next();
            Teacher tea = new Teacher(id, name, sex);
            for (int j = 0; j <= C.length; j++) {
                if (C[j] == null) {
                    break;
                }
                else {
                    if (tea.getName().equals(C[j].getTeacher())) {
                        tea.add_course(C[j]);
                    }
                    else {
                        continue;
                    }
                }
            }
            tea.show();
        }

        if (iddd == 2) {
            System.out.println("请输入ID：");
            int id = in.nextInt();
            System.out.println("请输入姓名：");
            String name = in.next();
            System.out.println("请输入性别：");
            String sex = in.next();
            System.out.println("请输入年龄：");
            int age = in.nextInt();
            Student stu = new Student(id,name,sex,age);
            System.out.println("你的专业可以选择以下选课程：\n");
            int k = 1;
            for (int i=0;i<=C.length;i++){
                if(C[i] == null){
                    break;
                }
                else {
                    System.out.print("课程"+ k);
                    System.out.print(" 课程编号："+C[i].getId());
                    System.out.print(" 授课教师："+C[i].getTeacher());
                    System.out.print(" 上课时间："+C[i].getName());
                    System.out.print(" 上课地点："+C[i].getPlace());
                    System.out.print(" 课程人数："+C[i].getStu_num());
                    System.out.println(" 上课时间：周"+C[i].getWeek() +" "+ C[i].getTime());
                    k++;
                }
            }
            System.out.println("请输入课程编号选择课程");
            int class_id = in.nextInt();

            stu.add_course(class_id,C);

            for (int i=0; ;i++){
                System.out.println("继续选课输入“1”，退课输入“2”，查看课表输入“3”,退出“4”");
                int choose = in.nextInt();
                if (choose == 1){
                    System.out.println("请输入课程号选课：");
                    int class_idd = in.nextInt();
                    stu.add_course(class_idd,C);
                }
                if (choose == 2){
                    System.out.println("请输入课程号退课");
                    int class_idd = in.nextInt();
                    stu.drop_course(class_idd);
                }
                if (choose == 3) {
                    stu.show();
                }
                if (choose == 4) {
                    break;
                }
            }
        }
    }
}

