import java.io.*;

public class Access {
    public static void main(String[] args){
    if(args.length != 1){
      System.out.println("ファイル名を指定してください");
      System.exit(1);
    }
    try{
      BufferedReader br = new BufferedReader(new FileReader(args[0]));

      String str;
      while((str = br.readLine()) != null){
        // 文字列の分割
        String regex = "/";
        String strtry = str;

        String[] result = str.split(regex,0);
        for (int i= 0; i < result.length; i++){
          // System.out.println("["+result[i]+"]");
          String path = "["+result[i]+"]";
          System.out.println(path);
        }

        System.out.println("-- --");

        // result = str.split(regex, -1);
        // for (int i = 0 ; i < result.length; i++){
        //   System.out.println("[" + result[i] + "]");
        // }

        // System.out.println("-- --");

        // result = str.split(regex, 2);
        // for (int i = 0 ; i < result.length; i++){
        //   System.out.println("[" + result[i] + "]");
        // }



        // String[]target = new String[5];
        // target[0] = str.substring(53,72);
        // System.out.println(target[0]);
        // // System.out.println(target[1]);
        // System.out.println(str);
      }
      br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
