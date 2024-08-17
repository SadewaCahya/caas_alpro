import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        tasklist taskList = new tasklist();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

        while (true) {
            System.out.println("\nTask List Management");
            System.out.println("1. tambah task");
            System.out.println("2. hapus task");
            System.out.println("3. tampilkan task");
            System.out.println("4. tambah member task");
            System.out.println("5. hapus member task");
            System.out.println("6. edit task");
            System.out.println("7. update status task");
            System.out.println("8. Exit");
            System.out.print("input opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("masukkan nama task: ");
                    String taskName = scanner.nextLine();
                    System.out.print("masukkan due date (yyyy-MM-dd hh:mm a): ");
                    String dueDateStr = scanner.nextLine();
                    try {
                        Date dueDate = dateFormat.parse(dueDateStr);
                        taskList.tambah_task(taskName, dueDate);
                    } catch (Exception e) {
                        System.out.println("format date tidak sesuai.");
                    }
                    break;

                case 2:
                    System.out.print("masukkan nama task yang ingin dihapus: ");
                    String removeTaskName = scanner.nextLine();
                    taskList.hapus_task(removeTaskName);
                    break;

                case 3:
                    taskList.tampilkan_task();
                    break;

                case 4:
                    System.out.print("Masukkan nama task: ");
                    String task_member = scanner.nextLine();
                    System.out.print("Masukkan nama member: ");
                    String nama_member = scanner.nextLine();
                    String[] members = nama_member.split(",");
                    for (String member : members) {
                        taskList.tambah_membertask(task_member, member.trim());
                    }
                    break;

                case 5:
                    System.out.print("Masukkan nama task: ");
                    String name_task = scanner.nextLine();
                    System.out.print("Masukkan nama member: ");
                    String nameMember = scanner.nextLine();
                    taskList.hapus_membertask(name_task, nameMember);
                    break;

                case 6:
                    System.out.print("Masukkan nama task: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nama task (baru): ");
                    String newname = scanner.nextLine();
                    System.out.print("Masukkan due date baru (yyyy-MM-dd hh:mm a): ");
                    String dueDate = scanner.nextLine();
                    taskList.editTask(name, newname, dueDate);
                    break;

                case 7:
                    System.out.print("Masukkan nama task: ");
                    String taskname = scanner.nextLine();
                    System.out.print("Masukkan status task (Completed): ");
                    String taskStatus = scanner.nextLine();
                    if (taskStatus.equalsIgnoreCase("Completed")) {
                        taskList.updateTaskStatus(taskname, "Completed");
                    } else {
                        System.out.println("Invalid, hanya status 'completed' yang bisa di set secara manual");
                    }
                    break;

                case 8:
                    System.out.println("....");
                    scanner.close();
                    return;

                default:
                    System.out.println("opsi tidak tersedia, silahkan masukkan opsi yang tersedia");
            }
        }
    }
}