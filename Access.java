import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
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
    String[] line_by_line_data = null;
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
      List<String> lineList = new ArrayList<String>();
      String line;
      while((line = br.readLine()) != null){
        lineList.add(line);
      }
      line_by_line_data = lineList.toArray(new String[lineList.size()]);
            List<String> list1 = new ArrayList<>();
              // // 文字列の分割（各行ごとに分割）
              String regex = "/";
              int line_count = line_by_line_data.length;
              String[] access_path = new String[line_count];
              // 各行ごとに必要な項目を取り出してくる
              for (int i=0; i<line_count; i++){
                String[] result = line_by_line_data[i].split(regex,0);
                Collections.addAll(list1, result);
                  access_path[i] = result[3]+"/"+result[4] ;
              }
              String[] access_count_list = new String[line_count];
              // 要素ごとに個数を出力
              for (int i = 0; i < line_count; i++){
                int count = 0;
                String x = (access_path[i]);
                for (var y: access_path){
                    if (y.equals(x)){
                        count++;
                    }
                }
                access_count_list[i] = x + "=>" + count;
              }
              // 配列から重複を削除する
              Set<String> linkedHashSet = new LinkedHashSet<String>();
              for (int i = 0; i < access_count_list.length; i++) {
                linkedHashSet.add(access_count_list[i]);
              }
              Object[] access_count_total = linkedHashSet.toArray();
              System.out.println(Arrays.toString(access_count_total));
              br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
