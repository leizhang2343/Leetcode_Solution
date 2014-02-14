package LeetCode;

import java.util.regex.Matcher;     
import java.util.regex.Pattern;     
/**     
 * java中运用正则表达式的两个重要类:Pattern与Matcher     
 * @author fhd001     
 */     
public class PatternAndMatcherTest1 {     
     public static void main(String[] args) {     
        /*     
         * 常用的调用     
         */     
        Pattern p1 = Pattern.compile("a*b");     
        String str1 = "aaaab";     
        Matcher m1 = p1.matcher(str1);     
        boolean b1 = m1.matches();     
        System.out.println(b1);     
             
        String str2 = "b";     
        Matcher m2 = p1.matcher(str2);     
        boolean b2 = m2.matches();     
        System.out.println(b2);     
         /*     
         * 另一种调用     
         * 等效于上面的语句，尽管对于重复的匹配而言它效率不高，因为它不允许重用已编译的模式。      
         * 但它可供多个并发线程安全使用,而上面的调用则就不是安全的.     
         */     
        boolean b3 = Pattern.matches("a*b", "aaab");     
        System.out.println(b3);     
             
        //Pattern类的pattern方法:从pattern类的实例中返回匹配模式的字符串表示     
        String pattern1 = p1.pattern();     
        System.out.println(pattern1);     
             
        //Pattern类的split方法     
        String[]arr1 = p1.split("rrrrraaabccccaaaaab");     
        for (String string : arr1) {     
            System.out.println(string+">>>>");     
        }     
        /*     
         * Matcher类     
         *      
         * matches方法:       方法尝试将整个输入序列与该模式匹配     
         * lookingAt方法: 尝试将输入序列从头开始与该模式匹配,与 matches 方法类似，     
         *                  此方法始终从区域的开头开始；与之不同的是，它不需要匹配整个区域。      
         * find方法:          方法扫描输入序列以查找与该模式匹配的下一个子序列     
         */     
        String str3 = "aabbcccaaaaaeeeaaaaaaaaagggga";     
        Pattern p3 = Pattern.compile("a+");     
        Matcher m3 = p3.matcher(str3);     
        boolean bo4 = m3.matches();     
        System.out.println("matches方法:  "+bo4);     
        /*     
         * lookingAt方法,从开头第一个字符进行匹配,匹配成功了不再继续匹配,     
         * 从第一个字符开始,匹配失败了,也不继续匹配.不需要匹配整个序列     
         */     
        boolean bo5 = m3.lookingAt();     
        if(bo5){     
            //group方法(不带参数)返回的就是匹配的子字符串.     
            System.out.println("lookingAt方法:  "+m3.group());     
        }     
     //find方法:找到一个匹配的子串,还会继续找下一个子串.     
        while(m3.find()){     
            System.out.println("find方法:  "+m3.group());     
        }     
     /*     
         * 带参数的group方法与不带参数的group方法区别     
         * 不带参数的group方法:find方法与lookingAt方法匹配出来的子序列(上面有演示)     
         * 带参数的group方法: 返回在以前匹配操作期间由给定组捕获的输入子序列。     
         */     
        String str6 = "aaabbbccc";     
        Pattern p5 = Pattern.compile("(a+)(b+)(c+)");     
        Matcher m5 = p5.matcher(str6);     
        boolean boo = m5.matches();     
        if(boo){     
            int k = m5.groupCount()+1;//加1就是把0下标的整个字符序列加上,它也作为一组放在0下标的位置.     
            if(k>0){     
                for(int i=0;i<4;i++){
                	System.out.println(m5.group(i));     
                }     
            }     
        }     
    }     
}    