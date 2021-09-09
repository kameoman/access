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
    String[] tempInside = null;
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
      List<String> lineList = new ArrayList<String>();
      String line;
      while((line = br.readLine()) != null){
        lineList.add(line);

        // リスト作成
        List<String> list1 = new ArrayList<>();
        // 文字列の分割
        String regex = "/";
        String strtry = line;

        String[] result = line.split(regex,0);
        Collections.addAll(list1, result);
        for (String a : list1){
          System.out.println("["+a+"]");
          System.out.println("-- --");
        }

        // for (int i= 0; i < result.length; i++){
        //   // System.out.println("["+result[i]+"]");
        //   String path = "["+result[i]+"]";
        //   System.out.println(path);
        // }

        // System.out.println(result.length);
        String url_path = result[3]+"/"+result[4];
        String[] ab = new String[] {url_path};
        System.out.println(Arrays.toString(ab));
        System.out.println("-- --");

        // result = line.split(regex, -1);
        // for (int i = 0 ; i < result.length; i++){
        //   System.out.println("[" + result[i] + "]");
        // }

        // System.out.println("-- --");

        // result = line.split(regex, 2);
        // for (int i = 0 ; i < result.length; i++){
        //   System.out.println("[" + result[i] + "]");
        // }



        // String[]target = new String[5];
        // target[0] = line.substring(53,72);
        // System.out.println(target[0]);
        // // System.out.println(target[1]);
        // System.out.println(line);
      }
      tempInside = lineList.toArray(new String[lineList.size()]);
      System.out.println(tempInside[0]);
      System.out.println("--next--");
      System.out.println(tempInside[1]);
      System.out.println("--next--");
      System.out.println(tempInside[2]);
      System.out.println("--next--");
      System.out.println(tempInside[3]);
      System.out.println("--next--");
      System.out.println(tempInside[4]);
      br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
