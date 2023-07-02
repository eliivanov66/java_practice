public class Manager extends Worker {

    public static boolean salaryIncrease(Worker worker, Double salary){
        if (worker.getClass().equals(Worker.class)) {
            worker.setSalary(salary);
            return true;
        }
        return false;
    }

}
