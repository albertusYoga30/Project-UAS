package Model;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 *
 * @author umang_borad
 */
public class Main {

    public static void main(String[] args) throws IOException, Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the Value of K:");
        int K_cardinality = s.nextInt();
        ArrayList<Documents> listOfDocuments = new ArrayList<>();

        JFileChooser j = new JFileChooser();
//        j.setFileSelectioHnMode(JFileChooser.DIRECTORIES_ONLY);
//        j.showOpenDialog(j);
        File dir = new File("D:\\Kuliah\\SEMESTER 6\\Pemerolehan Informasi\\Project UAS\\proyekbgst\\LAGUANAK");
//        File dir = new File(j.getSelectedFile().getAbsolutePath());
        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file : files) {

            listOfDocuments.add(new Documents(file));
        }

        Kmeans k = new Kmeans(listOfDocuments);
        k.createCluster(K_cardinality);

    }

}
