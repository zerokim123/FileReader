package jp.co.tecinfosys.L191_ERFileCreateSqlTool.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jp.co.tecinfosys.L191_ERFileCreateSqlTool.bean.ReaderFileBean;

public class FileReaderUtil {

    public static ReaderFileBean readerFileBean(String pathStr) {
        ReaderFileBean readerFileBean = new ReaderFileBean();

        if (StringUtils.isNotBlank(pathStr)) {
            Path path = Paths.get(pathStr);
            File file = path.toFile();

            boolean skip = true;

            String readerType = "";

            List<List<String>> entityInfo = new ArrayList<>();

            List<List<String>> relationInfo = new ArrayList<>();

            int rederLine = 0;

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));) {

                String str;

                List<String> entityLines = new ArrayList<>();

                List<String> relationLines = new ArrayList<>();

                while ((str = reader.readLine()) != null) {

                    if (str.equals("[Entity]")) {
                        rederLine = 0;
                        skip = false;

                        readerType = "Entity";

                    } else if (str.equals("[Relation]")) {
                        rederLine = 0;
                        skip = false;
                        readerType = "Relation";

                    } else if (StringUtils.isBlank(str)) {

                        rederLine = 0;

                        if (entityLines.size() != 0) {

                            entityInfo.add(entityLines);

                        } else if (relationLines.size() != 0) {

                            relationInfo.add(relationLines);

                        }

                        entityLines = new ArrayList<>();

                        relationLines = new ArrayList<>();
                    }

                    if (!skip && rederLine != 0) {

                        if (StringUtils.equals(readerType, "Entity")) {

                            entityLines.add(str);

                        } else {

                            relationLines.add(str);
                        }

                    }

                    rederLine = rederLine + 1;

                }
                readerFileBean.setError(false);
                readerFileBean.setEntityInfo(entityInfo);
                readerFileBean.setRelationInfo(relationInfo);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            return readerFileBean;
        }

        return readerFileBean;

    }

}
