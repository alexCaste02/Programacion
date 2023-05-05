package e_B.e_B11;

import java.util.ArrayList;

public class TaskManager {

    private static ArrayList<Task> tasksList = new ArrayList<>();

    public static Task getTask(int id){
        for (Task task : tasksList) {
            if(task.getId()==id) return task;
        }
        return null;
    }

    public static ArrayList<Task> getTasks(){
        return tasksList;
    }

    public static void saveTasksToFile(String fileName){

    }

    public static void loadTasksToFile(){

    }



}
