import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Comparator;

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
        // 保存量を減らす
        lineList.add(line.substring(45,90));
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
                  access_path[i] = result[1]+"/"+result[2] ;
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
                access_count_list[i] = count +":"+ x;
              }
              ArrayList<String> list_count = new ArrayList<>();
              for (int i = 0; i < 20; i++) {
                list_count.add(access_count_list[i]);
              }
              Collections.sort(list_count, Comparator.comparingLong(str -> -1 * Long.parseLong(str.split(":")[0])));
              String[] array = list_count.toArray(new String[list_count.size()]);
              
              // 配列から重複を削除する
              Set<String> linkedHashSet = new LinkedHashSet<String>();
              for (int i = 0; i < array.length; i++) {
                linkedHashSet.add(array[i]);
              }
              Object[] strings_after = linkedHashSet.toArray();
              // 必要数表示する(上位20位)
              System.out.println("最もアクセスの多かった上位20件のURL（パス）とそのアクセス回数");
              System.out.println("回数:URL（パス）");
              if (strings_after.length < 20){
                for (int i = 0; i < strings_after.length; i++) {
                  System.out.println(strings_after[i]);
                }
                for (int i = 0; i < 20-strings_after.length; i++) {
                  System.out.println("コンテンツがありません");
                }
              }else{
                for (int i = 0; i < 20; i++) {
                  System.out.println(strings_after[i]);
                }
              }
              br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}