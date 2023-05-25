
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class Notice implements Serializable {
    private String noticeSubj;
    private String noticeText;
    private LocalDate date;

    public Notice(String noticeSubj, String noticeText, LocalDate date) {
        this.noticeSubj = noticeSubj;
        this.noticeText = noticeText;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n"+"Subject: " + noticeSubj + "\n"+"Notice: " + noticeText  +"\n\n";
    }

    public void addNotice ()
    {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Head Notice.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
          
            oos.writeObject(this);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Saved");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static ArrayList<Notice> listOfNotice() {
        ArrayList<Notice> nList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Head Notice.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Notice m;
            try {
                while (true) {
                    m = (Notice) ois.readObject();
                    nList.add(m);
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch                 
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return nList;
    }

    public String getNoticeSubj() {
        return noticeSubj;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public LocalDate getDate() {
        return date;
    }
}
    

