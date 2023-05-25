
package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class Head extends User implements Serializable{

    public Head(String name, String user_type, String email, String password, int id) {
        super(name, user_type, email, password, id);
    }
    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("User.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void createMeeting(LocalDate date, String time, String topic, String meetingRoomNo, String aboutTheMeeting, int meetingNo){
        Meeting c = new Meeting(
            date,
            time,
            topic,
            meetingRoomNo,
            aboutTheMeeting,
            meetingNo
        );
        c.addMeetingSchedule();
    }
    
    public ArrayList<Meeting> viewMeetingSchedule(){
        return Meeting.listOfMeeting();
    }
    
    public static ArrayList<User> viewEmployeeList(){
        ArrayList<User>u = UserList.listOfUser();
        ArrayList<User>r = new ArrayList<User>();
        for(User i: u){
            if(!(i instanceof Customer)){
                r.add(i);
            }
        }
        return r;
    }
    
    public void approvedLeaveApplication(LeaveApplication p, boolean approve, boolean check){
        ArrayList<LeaveApplication>pList = LeaveApplication.listOLeaveApplication();
        File f = null;
        f = new File("Leave Application.bin");
        if(f.exists()){
            f.delete();
        }
        for(LeaveApplication i: pList){
            if(i.getApplicationNo() == p.getApplicationNo()){
                i.setIsApproved(approve);
                i.setIsCheck(check);
            }
            i.addLeaveApplication(true);
          
        }
    }
    public void giveNoticeToWorker(String body,String subj,LocalDate date)
    {
        Notice n=new Notice(subj,body,date);
        n.addNotice();
    }

    public ArrayList<Notice> viewNotice(){
        return Notice.listOfNotice();
    }
    
    public void approvedDistributorCandidateApplication(DistributorApplication p, boolean approve, boolean check){
        ArrayList<DistributorApplication>pList = DistributorApplication.listOfDistributorApplication();
        File f = null;
        f = new File("Distributor List.bin");
        if(f.exists()){
            f.delete();
        }
        for(DistributorApplication i: pList){
            if(i.getApplicationID() == p.getApplicationID()){
                i.setIsApproved(approve);
                i.setIsChecked(check);
                
            }
            i.addDistributor(true);
        }
    }
}
