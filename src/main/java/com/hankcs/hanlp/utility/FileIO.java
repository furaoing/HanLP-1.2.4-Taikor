package com.hankcs.hanlp.utility;
/**
 * Created by Roy on 10/22/2015.
 */

import java.io.*;

public class FileIO {

    public static String f_read(String file) {
        try {
            File fileDir = new File(file);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));
            String text = "";
            String text_buffer;
            while ((text_buffer = br.readLine()) != null) {
                text = text + text_buffer + "\n";
            }
            br.close();
            return text;
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public static int f_write(String file, String content){
        try {
            File fileDir = new File(file);

            BufferedWriter br = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileDir), "UTF8"));

            br.write(content);
            br.close();
            return 0;
        }

        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}