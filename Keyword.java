import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.Collections;
// 3.このサイト内で最も検索されているキーワード上位10件とそれらの検索回数

public class Keyword {
  public static void main(String[] args){
    if(args.length != 1){
      System.out.println("ファイル名を指定してください");
      System.exit(1);
    }
    // 読み込むファイルで/search/がある行を絞り込む
    String[] search_line_data = null;
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
      List<String> lineList = new ArrayList<String>();
      String line;
      while((line = br.readLine()) != null){
        if (line.contains("/search/")){
          lineList.add(line);
        }
      }
      search_line_data = lineList.toArray(new String[lineList.size()]);
      // // 文字列の分割（各行ごとに分割）
      int line_count = search_line_data.length;
      String[] search_split = new String[line_count];
      int search_word_count = 0;
      for (int i=0; i<line_count; i++){
      if (search_line_data[i].contains("/search/")){
                search_word_count++;
              }
      }
      // 各行ごとに必要な（大まかな）箇所を抽出
      for (int i=0; i<search_word_count; i++){
        String beginStr = "=";
        int beginIndex = search_line_data[i].indexOf(beginStr);
        String endStr = "M";
        int endIndex = search_line_data[i].indexOf(endStr) + endStr.length();
        search_split[i] = search_line_data[i].substring(beginIndex, endIndex);
      }
      // // 検索ワードをより的確に抽出
      String[] search_word = new String[search_word_count];
      for (int i=0; i<search_word_count; i++){
        String[] split_search =  search_split[i].split(" ");
        search_word[i] = split_search[0].replace("=", "");
      }
        // 分割した文字列に"が入っていたため削除
      for (int i=0; i<search_word.length; i++){
        if (search_word[i].contains("\"")){
          search_word[i] = search_word[i].substring(0,search_word[i].length()-1);
        }else{
          search_word[i] = search_word[i];
        }
      }
      // リストで不要な記述を削除する
      List<String> search_word_list = new ArrayList<String>(Arrays.asList(search_word));
      System.out.println(search_word_list.size());
      for (int i=0; i<search_word_list.size(); i++){
        if (search_word_list.get(i).length()<4){
          search_word_list.remove(search_word_list.get(i));
        }
      }
      // 配列にして次で要素ごとに個数を出力する（前準備）
      String[] search_word_arrangement = (String[]) search_word_list.toArray(new String[search_word_list.size()]);
      String[] search_word_calculation = new String[search_word_count];
        // 要素ごとに個数を出力
      for (int i = 0; i < search_word_arrangement.length; i++){
      int count = 0;
      String x = (search_word_arrangement[i]);
      for (var y: search_word_arrangement){
          if (y.equals(x)){
              count++;
          }
      }
        search_word_calculation[i] = count + ":" + x ;
      }
      // 項目ごとに並び替えを行う準備
      ArrayList<String> search_word_total_list = new ArrayList<>();
      for (int i = 0; i < search_word_arrangement.length; i++) {
        search_word_total_list.add(search_word_calculation[i]);
      }
      // 降順にソートします
      Collections.sort(search_word_total_list, Comparator.comparingLong(str -> -1 * Long.parseLong(str.split(":")[0])));
      String[] array = search_word_total_list.toArray(new String[search_word_total_list.size()]);
      // 配列から重複を削除する
      Set<String> search_word_list_after_counting = new LinkedHashSet<String>();
      for (int i = 0; i < array.length; i++) {
        search_word_list_after_counting.add(array[i]);
      }
      Object[] search_rank = search_word_list_after_counting.toArray();

        // 必要数表示する(上位10位)
      System.out.println("3.このサイト内で最も検索されているキーワード上位10件とそれらの検索回数");
      System.out.println("回数:URL（パス）");
      for (int i = 0; i <=10-1; i++){
        System.out.print(i+1+"位:");
        System.out.println(search_rank[i]);
      }
      br.close();
    }
    catch(IOException e){
      System.out.println("入出力エラーです。");
    }
  }


}
