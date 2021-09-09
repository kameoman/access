import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
// import java.io.FileInputStream;
// import java.io.InputStreamReader;

import javax.naming.StringRefAddr;

public class Access {
    public static void main(String[] args){
    if(args.length != 1){
      System.out.println("ファイル名を指定してください");
      System.exit(1);
    }
    // ファイルを1行ずつ配列に入れる
    String[] tempInside = null;
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
      List<String> lineList = new ArrayList<String>();
      String line;
      while((line = br.readLine()) != null){
        lineList.add(line);
      }
      tempInside = lineList.toArray(new String[lineList.size()]);
            List<String> list1 = new ArrayList<>();
              // // 文字列の分割（各行ごとに分割）
              String regex = "/";
              String strtry = tempInside[1];
      
              String[] result = strtry.split(regex,0);
              Collections.addAll(list1, result);
              for (String a : list1){
                System.out.println("["+a+"]");
                System.out.println("-- --");
              }
      // 配列の追加
      // String stringArray=result[3]+"/"+result[4];
      String[] access_path = new String[5];
      access_path[0] = result[3]+"/"+result[4];
      access_path[1] = "add";
      System.out.println(Arrays.toString(access_path));
      System.out.println(access_path[0]);
      System.out.println(access_path[1]);
      br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
