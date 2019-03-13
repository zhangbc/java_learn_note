package com.instance;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

/**
 * Java文件目录操作实例
 * @author zhangbocheng
 * @version v1.0
 * @date 2019/3/14 00:39
 */
public class FileDirectoryOperation {
    public static void main(String[] args) {
        System.out.println("Java文件目录操作实例！");
    }
}


/**
 * 递归创建目录：
 * 使用File类的mkdirs()实现递归创建目录.
 */
class FileDirRecurCreating {
    public static void main(String[] args) {
        String dirs = "./dir/dir1/dir2/dir3/dir4";
        File file = new File(dirs);
        boolean result = file.mkdirs();
        System.out.println("Status = " + result);
    }
}


/**
 * 删除目录：
 * 使用File类的dir.isDirectory(),dir.list()和deleteDir()方法在一个个删除文件后删除目录.
 */
class FileDirDeleting {
    public static void main(String[] args) throws Exception {
        deleteDir(new File("./dir"));
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        if (dir.delete()) {
            System.out.println("目录已被删除！");
            return true;
        } else {
            System.out.println("目录删除失败！");
            return false;
        }
    }
}


/**
 * 判断目录是否为空：
 * 使用File类的file.isDirectory()和file.list()方法来判断目录是否为空.
 */
class FileDirEmpty {
    public static void main(String[] args) {
        File file = new File("./src");
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null && fileList.length > 0) {
                System.out.println("目录不为空！");
            } else {
                System.out.println("目录为空！");
            }
        } else {
            System.out.println("这不是一个目录！");
        }
    }
}


/**
 * 判断文件是否隐藏：
 * 使用File类的file.isHidden()方法来判断文件是否隐藏.
 */
class FileConceal {
    public static void main(String[] args) {
        File file = new File("./.gitignore");
        System.out.println("文件是否隐藏？：" + file.isHidden());
    }
}


/**
 * 获取目录大小：
 * 使用File类的FileUtils.sizeofDirectory(File Name)来获取目录的大小.
 */
class FileDirSize {
    public static void main(String[] args) {
        long size = FileUtils.sizeOfDirectory(new File("./src"));
        System.out.println("文件大小(bytes)：" + size);
    }
}


/**
 * 在指定目录中查找文件：
 * 使用File类的dir.list()方法在指定目录中查找所有文件列表.
 */
class FileSearch {
    public static void main(String[] args) {
        File dir = new File("./src");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在！");
        } else {
            System.out.println("该目录下有目录或文件：");
            for (int i = 0; i < children.length; i++) {
                String fileName = children[i];
                System.out.println(fileName);
            }
        }
    }
}


/**
 * 获取文件的上级目录：
 * 使用File类的file.getParent()方法来获取文件的上级目录.
 */
class FileParentDir {
    public static void main(String[] args) {
        File file = new File("home/runoob.txt");
        String strParentDir = file.getParent();
        System.out.println("文件的上级目录是：" + strParentDir);
    }
}


/**
 * 获取目录最后修改时间：
 * 使用File类的file.lastModified()方法来获取目录的最后修改时间.
 */
class FileDirLastModifyTime {
    public static void main(String[] args) {
        File file = new File("./src");
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
    }
}


/**
 * 打印目录结构：
 * 使用File类的file.getName()和file.listFiles()方法来打印目录结构.
 */
class FileUtil {
    public static void main(String[] args) throws IOException {
        showDir(1, new File("./src"));
    }

    static void showDir(int indent, File file) throws IOException {
        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }

        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                showDir(indent + 4, files[i]);
            }
        }
    }
}


/**
 * 遍历指定目录下的所有目录：
 * 使用File类的list方法来遍历指定目录下的所有目录.
 */
class FileDirErgodic {
    public static void main(String[] args) {
        File dir = new File("/home/learning");
        File[] files;
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        files = dir.listFiles(fileFilter);
        if (files == null) {
            System.out.println("目录不存在或者不是一个目录！");
            return;
        }

        System.out.println("目录包含文件或文件夹个数：" + files.length);
        if (files.length == 0) {
            System.out.println("目录不存在或者不是一个目录！");
        } else {
            for (int i = 0; i < files.length; i++) {
                File fileName = files[i];
                System.out.println(fileName.toString());
            }
        }
    }
}


/**
 * 输出指定目录下的所有文件：
 * 使用File类的list方法来输出指定目录下的所有文件.
 */
class FilesDirOutput {
    public static void main(String[] args) {
        File dir = new File("/home/learning");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("目录不存在或不是一个目录！");
        } else {
            for (int i = 0; i < children.length; i++) {
                String fileName = children[i];
                System.out.println(fileName);
            }
        }
    }
}


/**
 * 在指定目录中查找文件：
 * 在/home中查找以字母'l'开头的所有文件。
 */
class FileDirSearch {
    public static void main(String[] args) {
        File dir = new File("/home");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("l");
            }
        };

        String[] children = dir.list(filter);
        if (children == null) {
            System.out.println("目录不存在或不是一个目录!!!");
        } else {
            for (int i = 0; i < children.length; i++) {
                String fileName = children[i];
                System.out.println(fileName);
            }
        }
    }
}


/**
 * 遍历系统根目录：
 * 使用File类的listRoots()方法来输出系统所有根目录.
 */
class RootsList {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        System.out.println("系统所有根目录：");
        for (int i = 0; i < roots.length; i++) {
            System.out.println(roots[i].toString());
        }
    }
}


/**
 * 查看当前工作目录：
 * 使用System的getProperty()方法来获取当前的工作目录.
 */
class CurrentWorkDir {
    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");
        System.out.println("你当前 工作目录为：" + curDir);
    }
}


/**
 * 遍历目录：
 * 使用File类的dir.isDirectory()和dir.list()方法来遍历目录.
 */
class DirErgodic {
    public static void main(String[] args) throws Exception {
        System.out.println("遍历目录：");
        File dir = new File("/home/projects/pythoner");
        visitAllDirsFiles(dir);
    }

    private static void visitAllDirsFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if (children == null) {
                return;
            }

            for (int i = 0; i < children.length; i++) {
                visitAllDirsFiles(new File(dir, children[i]));
            }
        }
    }
}