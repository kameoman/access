import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    String[] access_base_data = null;
    try{
      BufferedReader basic_data_read = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
      List<String> access_base_data_list = new ArrayList<String>();
      String access_data_line;
      while((access_data_line = basic_data_read.readLine()) != null){
        access_base_data_list.add(access_data_line.substring(45,90));
      }
      access_base_data = access_base_data_list.toArray(new String[access_base_data_list.size()]);
      List<String> list1 = new ArrayList<>();
      // // 文字列の分割（各行ごとに分割）
      String regex = "/";
      int line_count = access_base_data.length;
      String[] access_path_after_split = new String[line_count];
      // 各行ごとに必要な項目を取り出してくる
      for (int i=0; i<line_count; i++){
        String[] access_path_split= access_base_data[i].split(regex,0);
        Collections.addAll(list1, access_path_split);
          access_path_after_split[i] = access_path_split[1]+"/"+access_path_split[2] ;
      }
      String[] access_path_count = new String[line_count];
      // 要素ごとに個数を出力
      for (int i = 0; i < line_count; i++){
        int count = 0;
        String x = (access_path_after_split[i]);
        for (var y: access_path_after_split){
            if (y.equals(x)){
                count++;
            }
        }
        access_path_count[i] = count +":"+ x;
      }
      ArrayList<String> list_count = new ArrayList<>();
      for (int i = 0; i < 20; i++) {
        list_count.add(access_path_count[i]);
      }
      Collections.sort(list_count, Comparator.comparingLong(str -> -1 * Long.parseLong(str.split(":")[0])));
      String[] array = list_count.toArray(new String[list_count.size()]);
      
      // 配列から重複を削除する
      Set<String> access_path_total = new LinkedHashSet<String>();
      for (int i = 0; i < array.length; i++) {
        access_path_total.add(array[i]);
      }
      Object[] access_path_rank = access_path_total.toArray();
      // 必要数表示する(上位20位)
      System.out.println("最もアクセスの多かった上位20件のURL（パス）とそのアクセス回数");
      System.out.println("順位:回数:URL（パス）");
      if (access_path_rank.length < 20){
        for (int i = 0; i < access_path_rank.length; i++) {
          System.out.print(i+1+"位:");
          System.out.println(access_path_rank[i]);
        }
        for (int i = 0; i < 20-access_path_rank.length; i++) {
          System.out.println("コンテンツがありません");
        }
      }else{
        for (int i = 0; i < 20; i++) {
          System.out.print(i+1+"位:");
          System.out.println(access_path_rank[i]);
        }
      }
      basic_data_read.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}