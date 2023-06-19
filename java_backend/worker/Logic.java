import java.util.ArrayList;

public class Logic {
    public static void main(String[] args) {
        int workerCount = 50;
        ArrayList<Worker> crew = new ArrayList<Worker>();
        for (int i = 0; i < workerCount; i++) {
            crew.add(new Worker()); 
        }
        
        Manager manager = new Manager();
        Manager manager2 = new Manager();

        crew.add(manager);
        crew.add(manager2);
        manager.setAddInfo("Менеджер 1");
        manager2.setAddInfo("Менеджер 2");

        for (Worker worker : crew) {
            System.out.println(worker.getInfo());     
        }

        for (Worker worker : crew) {
            Manager.salaryIncrease(worker, worker.getSalary() + 10000.0);     
        }

        for (Worker worker : crew) {
            System.out.println(worker.getInfo());     
        }

        System.out.println(manager.compareTo(manager2));
    }

}