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
        lineList.add(line);
      }
      line_by_line_data = lineList.toArray(new String[lineList.size()]);
            List<String> list1 = new ArrayList<>();
              // // 文字列の分割（各行ごとに分割）
              String regex = " ";
              int line_count = line_by_line_data.length;
              String[] access_path = new String[line_count];
              // System.out.println(line_by_line_data.length);

              // 各行ごとに必要な項目を取り出してくる
              for (int i=0; i<line_count; i++){
                // 条件を付けて文字を抽出
                String beginStr = "Mozilla";
                int beginIndex = line_by_line_data[i].indexOf(beginStr);
                String endStr = ")";
                int endIndex = line_by_line_data[i].indexOf(endStr) + endStr.length();
                access_path[i] = line_by_line_data[i].substring(beginIndex-1, endIndex);
                }
                // System.out.println(Arrays.toString(access_path));
              Integer[] access_count_list = new Integer[line_count];
              // 要素ごとに個数を出力
              for (int i = 0; i < line_count; i++){
                int windows_count = 0;
                for (var y: access_path){
                    if (y.contains("Windows")){
                      windows_count++;
                    }
                  }
                  access_count_list[0] = windows_count;
              }
              for (int i = 0; i < line_count; i++){
                int mac_count = 0;
                for (var y: access_path){
                    if (y.contains("Mac")){
                      mac_count++;
                    }
                  }
                  access_count_list[1] = mac_count;
              }
              for (int i = 0; i < line_count; i++){
                int google_count = 0;
                for (var y: access_path){
                    if (y.contains("Googlebot")){
                      google_count++;
                    }
                  }
                  access_count_list[2] = google_count;
              }
              int total_os = access_count_list.length - access_count_list[2];
              double total_mac = access_count_list[1];
              double total_windows = access_count_list[0];
              double windows_rate = (total_windows / total_os) *100;
              System.out.println("2.Googlebot を除くOS毎のアクセス割合");
              System.out.println("Windowsの割合"+Math.round(windows_rate)+"%");
              double mac_rate = (total_mac / total_os) *100;
              System.out.println("MacOSの割合"+Math.round(mac_rate)+"%");


              br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }
}
