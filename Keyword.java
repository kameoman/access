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
                String beginStr = "=";
                int beginIndex = line_by_line_data[i].indexOf(beginStr);
                String endStr = "M";
                int endIndex = line_by_line_data[i].indexOf(endStr) + endStr.length();
                search_split[i] = line_by_line_data[i].substring(beginIndex, endIndex);
              }
              // // 検索ワードをより的確に抽出
                String[] search_word = new String[search_word_count];
                for (int i=0; i<search_word_count; i++){
                  String[] split_search =  search_split[i].split(" ");
                  search_word[i] = split_search[0].replace("=", "");
                }
                // System.out.println(search_split[7]);
                // System.out.println(search_word[7]);
                // System.out.println(search_split[8]);
                // System.out.println(Arrays.toString(search_word));
                // System.out.println(search_word.length);
                // 分割した文字列に"が入っていたため削除
                for (int i=0; i<search_word.length; i++){
                  if (search_word[i].contains("\"")){
                    search_word[i] = search_word[i].substring(0,search_word[i].length()-1);
                  }else{
                    search_word[i] = search_word[i];
                  }
                }

                // リスト内の0,10,20などを削除する
                List<String> list = new ArrayList<String>(Arrays.asList(search_word));
                System.out.println(list.size());
                // list.remove(0);
                // int ddcount = 0;
                for (int i=0; i<list.size(); i++){
                  if (list.get(i).length()<4){
                    list.remove(list.get(i));
                    // System.out.println(list.get(i));
                    // ddcount ++;
                  }
                }
                // System.out.println(list.size());
                // System.out.println(ddcount);
                // System.out.println(list.get(1747).length());
                    // list.remove(list.get(0));
                // System.out.println(list.get(2));
                String[] arr_2 = (String[]) list.toArray(new String[list.size()]);
                // for (String str : arr_2) {
                //   System.out.println(str);
                // }

                // search_word[2] = search_word[2].trim();
                // System.out.println(Arrays.toString(search_word));
                // System.out.println(search_word[2].length());
                // System.out.println(search_word[0].length());
                // System.out.println(search_word[2]);
              String[] search_word_total = new String[search_word_count];
               // 要素ごとに個数を出力
              for (int i = 0; i < arr_2.length; i++){
              int count = 0;
              String x = (arr_2[i]);
              for (var y: arr_2){
                  if (y.equals(x)){
                      count++;
                  }
              }
              search_word_total[i] = count + ":" + x ;
            }
            ArrayList<String> list_count = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
              list_count.add(search_word_total[i]);
            }
            // 降順にソートします
            Collections.sort(list_count, Comparator.comparingLong(str -> -1 * Long.parseLong(str.split(":")[0])));
            String[] array = list_count.toArray(new String[list_count.size()]);
            // 配列から重複を削除する
            Set<String> linkedHashSet = new LinkedHashSet<String>();
            for (int i = 0; i < array.length; i++) {
              linkedHashSet.add(array[i]);
            }
            Object[] search_rank = linkedHashSet.toArray();

              // 必要数表示する(上位10位)
              // System.out.println("3.このサイト内で最も検索されているキーワード上位10件とそれらの検索回数");
              // System.out.println("回数:URL（パス）");
              for (int i = 0; i <=30-1; i++){
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
