import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

// 2.Googlebot を除くOS毎のアクセス割合
public class OsAccess {
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
        lineList.add(line.substring(45,90));
      }
      // System.out.print(line);
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
              // 配列から重複を削除する
              Set<String> linkedHashSet = new LinkedHashSet<String>();
              for (int i = 0; i < access_count_list.length; i++) {
                linkedHashSet.add(access_count_list[i]);
              }
              Object[] access_count_total = linkedHashSet.toArray();
              // 降順にソートします
              Arrays.sort(access_count_total);
              for (int f = 0, l = access_count_total.length - 1; f < l; f++, l--){
                Object temp = access_count_total[f];
                access_count_total[f]  = access_count_total[l];
                access_count_total[l] = temp;
              }
              // 必要数表示する(上位20位)
              // System.out.println("最もアクセスの多かった上位20件のURL（パス）とそのアクセス回数");
              // System.out.println("回数:URL（パス）");
              // for (int i = 0; i <=20-1; i++){
              //   System.out.println(access_count_total[i]);
              // }
              br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
