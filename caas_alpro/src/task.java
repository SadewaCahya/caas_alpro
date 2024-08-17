import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class task {
    private String name;
    private Date duedate;
    private ArrayList<String> members;
    private String status;

    public task(String name, Date duedate) {
        this.name = name;
        this.duedate = duedate;
        this.members = new ArrayList<>();
        this.status = " Pending";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tambah_member(String member) {
        members.add(member);
    }

    public void hapus_member(String member) {
        members.remove(member);
    }

    public void check_status_task(Date duedate) {
        Date currenDate = new Date();
        if(currenDate.after(duedate)) {
            status = " Overdue";
        } else {
            status = " Pending";
        }
    }
    
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        return "Task: " + name + ", Due date: " + dateFormat.format(duedate) + ", Status:" + status + ", Members: " + members;
    }

}
