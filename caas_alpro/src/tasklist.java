import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class tasklist {
    private ArrayList<task> tasks;

    public tasklist() {
        tasks = new ArrayList<>();
    }

    public void tambah_task(String name, Date Duedate) {
        for (task i : tasks) {
            if (i.getName().equals(name)) {
                System.out.println("Task " + name + " sudah ada");
                return;
            }
        }
        task Task = new task(name, Duedate);
        Task.check_status_task(Duedate);
        tasks.add(Task);
        System.out.println("Task " + name + " berhasil ditambah.");
    }

    public void hapus_task(String name) {
        for (task Task : tasks) {
            if (Task.getName().equals(name)) {
                tasks.remove(Task);
                System.out.println("Task " + name + " berhasil dihapus.");
                return;
            } 
        }
        System.out.println("Task " + name + " tidak ada.");
    }

    public void tampilkan_task() {
        if (tasks.isEmpty()) {
            System.out.println("tidak ada task.");
        }
        for (task Task : tasks) {
            System.out.println(Task);
        }
    }

    public void tambah_membertask(String taskName, String memberName) {
        for (task Task : tasks) {
            if (Task.getName().equals(taskName)) {
                Task.tambah_member(memberName);
                System.out.println("Member " + memberName + " ditambahkan ke task " + taskName + ".");
                return;
            }
        }
        System.out.println("Task " + taskName + " tidak ditemukan.");
    }

    public void hapus_membertask(String taskName, String memberName) {
        for (task Task : tasks) {
            if (Task.getName().equals(taskName)) {
                Task.hapus_member(memberName);
                System.out.println("Member " + memberName + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Member tidak ditemukan");
    }

    public void editTask(String name, String newname, String Duedate) {
        for (task Task : tasks) {
            if (Task.getName().equals(name)) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
                    Date newDueDate = dateFormat.parse(Duedate);
                    Task.setName(newname);
                    Task.setDuedate(newDueDate);
                    System.out.println("Task " + name + " berhasil diupdate.");
                } catch (Exception e) {
                    System.out.println("format date tidak sesuai.");
                }
                return;
            }
        }
        System.out.println("Task " + name + "tidak ada.");
    }

    public void updateTaskStatus(String taskName, String status) {
        for (task Task : tasks) {
            if (Task.getName().equals(taskName)) {
                Task.setStatus(status);
                System.out.println("Task " + taskName + " status update to " + status + ".");
                return;
            } 
        }
        System.out.println("Task " + taskName + " tidak ada.");
    }
}