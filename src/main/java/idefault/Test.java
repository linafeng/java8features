package idefault;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/4/29 15:09
 * @Version: 1.0
 */
public class Test {

    //p1为初始盘，p3为目标盘
    public static void solve(int n,char p1,char p2,char p3){
        if(n==1) {
            System.out.println(p1 + "->" + p3);
        }else{
            solve(n-1,p1,p3,p2);
            System.out.println(p1+"->"+p3);
            solve(n-1,p2,p1,p3);
        }
    }

    public static void main(String[] args) {

        solve(3,'A','B','C');
    }

}
