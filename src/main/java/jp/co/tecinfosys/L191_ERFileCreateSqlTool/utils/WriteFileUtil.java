package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.Const.ConstantCls;

public class WriteFileUtil {

    public static boolean existenceCheck(String fullPath) {

        File file = new File(fullPath);

        return file.exists();

    }

    public static boolean writeFile(String fullPath, String body) {

        boolean writeFile = false;

        try {

            boolean fileCheck = existenceCheck(fullPath);

            if (!fileCheck) {
                body =  StringUtils.join(ConstantCls.STR_SQL_HEADER , body);
            }

            // FileWriterクラスのオブジェクトを生成する
            FileWriter file = new FileWriter(fullPath, fileCheck);
            // PrintWriterクラスのオブジェクトを生成する
            PrintWriter pw = new PrintWriter(new BufferedWriter(file));

//            byte[] b = body.getBytes();
//
//            //文字コードをShift-JISに変換する
//            body = new String(b, "Shift-JIS");

            //ファイルに書き込む
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
