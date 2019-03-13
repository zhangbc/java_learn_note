package com.instance;

import java.io.*;
import java.util.Date;

/**
 * Java文件操作实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:36
 */
public class FileOperation {
    public static void main(String[] args) {
        System.out.println("Java文件操作实例！");
    }
}


/**
 * 文件写入
 */
class FileWriting {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
            out.write("菜鸟教程\n");
            out.write("www.runoob.com");
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 读取文件内容
 */
class FileReading {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("runoob.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 删除文件
 */
class FileDeleting {
    public static void main(String[] args) {
        try {
            File file = new File("runoob.txt");
            if (file.delete()) {
                System.out.println(file.getName() + " 文件已被删除！");
            } else {
                System.out.println("文件删除失败！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 将文件内容复制到另一个文件
 */
class FileContentCopy {
    public static void main(String[] args) throws Exception {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("runoob_src.txt"));
            out.write("String to be copied.\n");
            out.close();

            InputStream in = new FileInputStream(new File("runoob_src.txt"));
            OutputStream outputStream = new FileOutputStream(new File("runoob_dest.txt"));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            in.close();
            outputStream.close();

            BufferedReader inReader = new BufferedReader(new FileReader("runoob_dest.txt"));
            String str;
            while ((str = inReader.readLine()) != null) {
                System.out.println(str);
            }
            inReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 向文件中追加数据
 */
class FileAddContent {
    public static void main(String[] args) throws Exception {
        try {
            BufferedWriter out;
            out = new BufferedWriter(new FileWriter("runoob.txt"));
            out.write("\nAdd content into file.");
            out.close();

            out = new BufferedWriter(new FileWriter("runoob.txt", true));
            out.write("\nAdd content data into file.");
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("runoob.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 创建临时文件
 */
class FileTempCreating {
    public static void main(String[] args) throws Exception {
        creatingTempFile();
        creatingTmpFile();
    }

    /**
     * 使用File类的createTempFile(String prefix, String suffix);方法在默认临时目录来创建临时文件，
     * 参数 prefix 为前缀，suffix 为后缀.
     * @throws Exception
     */
    private static void creatingTempFile() throws Exception {
        File temp = File.createTempFile("tmp_runoob", ".txt");
        System.out.println("文件路径：" + temp.getAbsolutePath());
        temp.deleteOnExit();
        BufferedWriter out = new BufferedWriter(new FileWriter(temp));
        out.write("Temp file.");
        System.out.println("临时文件已创建。");
        out.close();
    }

    /**
     * 使用createTempFile(String prefix, String suffix, File directory)中的directory参数来指定临时文件的目录.
     * @throws Exception
     */
    private static void creatingTmpFile() throws Exception {
        File file;
        file = File.createTempFile("tmp", ".txt", new File("."));
        System.out.println("File path: " + file.getAbsolutePath());
        file.deleteOnExit();

        file = File.createTempFile("tmp", null, new File("."));
        System.out.println("File path: " + file.getAbsolutePath());
        file.deleteOnExit();
    }
}


/**
 * 修改文件最后的修改日期：
 * 使用File类的fileToChange.lastModified()和fileToChange.setLastModified()方法来修改文件最后的修改日期。
 */
class FileLastTime {
    public static void main(String[] args) throws Exception {
        File fileToChange = new File("runoob.txt");
        fileToChange.createNewFile();
        Date fileTime = new Date(fileToChange.lastModified());
        System.out.println(fileTime.toString());
        System.out.println("文件是否修改？：" + fileToChange.setLastModified(System.currentTimeMillis()));
        fileTime = new Date(fileToChange.lastModified());
        System.out.println(fileTime.toString());
    }
}


/**
 * 获取文件大小：
 * 使用File类的file.exists()和file.length()方法来获取文件大小，以字节计算（1KB=1024字节）.
 */
class FileSize {
    public static void main(String[] args) {
        long size = getFileSize("runoob.txt");
        System.out.println("runoob.txt文件大小为：" + size + "byte.");
    }

    private static long getFileSize(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.out.println(fileName + "文件不存在！");
            return -1;
        }

        return file.length();
    }
}


/**
 * 文件重命名：
 * 使用File类的oldName.renameTo(newName)方法来重命名文件。
 */
class FileRename {
    public static void main(String[] args) {
        File oldName = new File("runoobN.txt");
        File newName = new File("runoob.txt");
        if (oldName.renameTo(newName)) {
            System.out.println("文件已重名.");
        } else {
            System.out.println("重命名失败，Error.");
        }
    }
}


/**
 * 设置文件只读：
 * 使用File类的file.setReadOnly()和file.canWrite()方法来设置文件只读.
 */
class FileReadOnly {
    public static void main(String[] args) {
        File file = new File("runoob.txt");
        System.out.println("文件是否只读？：" + file.setReadOnly());
        System.out.println("文件是否可写？：" + file.canWrite());
    }
}


/**
 * 检测文件是否存在：
 * 使用File类的file.exists()方法来检测文件是否存在。
 */
class FileExists {
    public static void main(String[] args) {
        File file = new File("runoob.txt");
        System.out.println("文件是否存在？：" + file.exists());
    }
}


/**
 * 在指定目录中创建文件：
 * 使用File类的file.createTempFile()方法在指定目录中创建文件.
 */
class FileDirCreating {
    public static void main(String[] args) throws Exception {
        File file;
        File dir = new File(".");
        file = File.createTempFile("javaTemp", ".temp", dir);
        System.out.println("文件当前路径为：" + file.getPath());
    }
}


/**
 * 获取文件修改时间：
 * 使用File类的file.lastModified()方法来获取文件最后的修改时间.
 */
class FileModifyTime {
    public static void main(String[] args) {
        File file = new File("runoob.txt");
        long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        System.out.println("文件的修改时间为：" + date);
    }
}


/**
 * 创建文件：
 * 使用File类的File()构造函数和file.createNewFile()方法来创建一个新的文件.
 */
class FileCreating {
    public static void main(String[] args) {
        try {
            File file = new File("myfile.txt");
            if (file.createNewFile()) {
                System.out.println("文件创建成功！");
            } else {
                System.out.println("出错了，该文件已存在。");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/**
 * 文件路径比较：
 * 使用File类的filename.compareTo(another filename)方法来比较两个文件路径是否在同一个目录下.
 */
class FilePathCompare {
    public static void main(String[] args) {
        File file1 = new File("runoob.txt");
        File file2 = new File("./runoob.txt");
        if (file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }
}