import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// 3.このサイト内で最も検索されているキーワード上位10件とそれらの検索回数

public class Keyword {
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
        if (line.contains("/search/")){
          lineList.add(line);
        }
      }

      line_by_line_data = lineList.toArray(new String[lineList.size()]);
              // // 文字列の分割（各行ごとに分割）
              int line_count = line_by_line_data.length;
              String[] search_split = new String[line_count];
              int search_word_count = 0;
              for (int i=0; i<line_count; i++){
              if (line_by_line_data[i].contains("/search/")){
                        search_word_count++;
                      }
              }
              // 各行ごとに必要な（大まかな）箇所を抽出
              for (int i=0; i<search_word_count; i++){
                String beginStr = "/search/";
                int beginIndex = line_by_line_data[i].indexOf(beginStr);
                String endStr = "M";
                int endIndex = line_by_line_data[i].indexOf(endStr) + endStr.length();
                search_split[i] = line_by_line_data[i].substring(beginIndex-1, endIndex);
              }
              // 検索ワードをより的確に抽出
                String[] search_word = new String[search_word_count];
                for (int i=0; i<search_word_count; i++){
                  String[] split_search =  search_split[i].split(" ");
                  search_word[i] = split_search[0] ;
                }
                System.out.println(search_word[0]);
                System.out.println(search_word.length);

              String[] search_word_total = new String[search_word_count];
               // 要素ごとに個数を出力
               for (int i = 0; i < search_word.length; i++){
                int count = 0;
                String x = (search_word[i]);
                for (var y: search_word){
                    if (y.equals(x)){
                        count++;
                    }
                }
                search_word_total[i] = count + ":" + x ;
              }
              
              System.out.println(search_word_total[0]);
              br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }


}
