package tools.io;

import java.io.File;
import java.nio.charset.Charset;

import com.google.common.io.Files;

public class FileUtil {
  private static final String UTF8_BOM = "\uFEFF";

  public static String readFromFile(String filePath, String charset) {
    String content = "";
    try {
      content = Files.toString(new File(filePath), Charset.forName(charset));
      content = FileUtil.removeUTF8BOM(content);
      if (content.toString().length() == 0) {
        return "";
      }
      return content;
    } catch (Exception e) {
      return "";
    }
  }

  private static String removeUTF8BOM(String s) {
    if (s.startsWith(UTF8_BOM)) {
      s = s.replace(UTF8_BOM, "");
    }
    return s;
  }
}