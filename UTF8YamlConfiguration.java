package de.verify.utils;

import com.google.common.base.Charsets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class UTF8YamlConfiguration
  extends YamlConfiguration
{
  public UTF8YamlConfiguration(File file)
  {
    try
    {
      load(file);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  /* Error */
  public void save(File file)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 34
    //   3: invokestatic 36	org/apache/commons/lang/Validate:notNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokestatic 42	com/google/common/io/Files:createParentDirs	(Ljava/io/File;)V
    //   10: aload_0
    //   11: invokevirtual 47	de/verify/utils/UTF8YamlConfiguration:saveToString	()Ljava/lang/String;
    //   14: astore_2
    //   15: new 51	java/io/OutputStreamWriter
    //   18: dup
    //   19: new 53	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: getstatic 57	com/google/common/base/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   30: invokespecial 63	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_2
    //   36: invokevirtual 66	java/io/Writer:write	(Ljava/lang/String;)V
    //   39: goto +12 -> 51
    //   42: astore 4
    //   44: aload_3
    //   45: invokevirtual 72	java/io/Writer:close	()V
    //   48: aload 4
    //   50: athrow
    //   51: aload_3
    //   52: invokevirtual 72	java/io/Writer:close	()V
    //   55: return
    // Line number table:
    //   Java source line #31	-> byte code offset #0
    //   Java source line #32	-> byte code offset #6
    //   Java source line #33	-> byte code offset #10
    //   Java source line #34	-> byte code offset #15
    //   Java source line #36	-> byte code offset #34
    //   Java source line #37	-> byte code offset #39
    //   Java source line #38	-> byte code offset #44
    //   Java source line #39	-> byte code offset #48
    //   Java source line #38	-> byte code offset #51
    //   Java source line #40	-> byte code offset #55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	UTF8YamlConfiguration
    //   0	56	1	file	File
    //   14	22	2	data	String
    //   33	19	3	writer	java.io.Writer
    //   42	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	42	finally
  }
  
  public void load(File file)
    throws FileNotFoundException, IOException, InvalidConfigurationException
  {
    Validate.notNull(file, "File cannot be null");
    load(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8));
  }
}