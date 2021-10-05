import java.io.File;

public class App {
    //liệt kê danh sách tập tin có trong thư mục hiện hành, kể cả file trong thư mục con
    private static void listFileInDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else listFileInDir(file);
        }
    }


    //liệt kê cây thư mục của thư mục hiện hành
    private static void treeFile(File dir, int level) {
        if (dir.isDirectory()) {
            System.out.println(getPadding(level) + "-" + dir.getName());
            File[] child = dir.listFiles();
            for (File ch : child) {
                treeFile(ch, level + 1);
            }
        } else {
            System.out.println(getPadding(level) + "+" + dir.getName());
        }
    }
    
    private static String getPadding(int level) {
        String padding = "";
        for (int i = 1; i < level; i++) {
            padding += "    ";
        }
        return padding;
    }

    public static void main(String[] args) {
        String workdirPath = System.getProperty("user.dir");
        System.out.format("Workdir = '%s'\n", workdirPath);

        File workdir = new File(workdirPath);
        treeFile(workdir, 1);
    }

}
