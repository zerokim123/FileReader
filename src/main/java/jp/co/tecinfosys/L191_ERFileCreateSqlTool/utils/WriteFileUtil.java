package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFileUtil {

    public static boolean existenceCheck(String fullPath) {

        File file = new File(fullPath);

        return file.exists();

    }

    public static boolean writeFile(String fullPath, String body) {

        boolean writeFile = false;

        try {
            // FileWriterクラスのオブジェクトを生成する
            FileWriter file = new FileWriter(fullPath, existenceCheck(fullPath));
            // PrintWriterクラスのオブジェクトを生成する
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));

            // ファイルに書き込む
            pw.println(body);

            // ファイルを閉じる
            pw.close();

            writeFile = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writeFile;

    }

}
