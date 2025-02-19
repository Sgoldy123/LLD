import java.util.*;

enum TaskStatus {
    OPEN, IN_PROGRESS, COMPLETED
}

class Task {
    String id;
    String title;
    TaskStatus status;
    User assignee;
    List<Subtask> subtasks;

    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.status = TaskStatus.OPEN;
        this.subtasks = new ArrayList<>();
    }

    public void changeStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }

    public void changeAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", assignee=" + (assignee != null ? assignee.name : "Unassigned") +
                ", subtasks=" + subtasks +
                '}';
    }
}

class Subtask {
    String id;
    String title;
    TaskStatus status;

    public Subtask(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.status = TaskStatus.OPEN;
    }

    public void changeStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}

class User {
    String name;
    List<Task> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksByType(String type) {
        // Assuming type is part of the task title or can be derived
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.title.contains(type)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}

class Sprint {
    String id;
    String name;
    List<Task> tasks;
    Date startDate;
    Date endDate;

    public Sprint(String name, Date startDate, Date endDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tasks = new ArrayList<>();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void displaySnapshot() {
        System.out.println("Sprint: " + name);
        for (Task task : tasks) {
            String status = task.status == TaskStatus.COMPLETED ? "On Track" : "Delayed";
            System.out.println(task + " - " + status);
        }
    }
}

class TaskPlanner {
    List<User> users;
    List<Sprint> sprints;

    public TaskPlanner() {
        this.users = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void createTask(String title) {
        Task task = new Task(title);
        System.out.println("Task created: " + task);
    }

    public void createSubtask(String taskId, String title) {
        Task task = findTaskById(taskId);
        if (task != null) {
            Subtask subtask = new Subtask(title);
            task.addSubtask(subtask);
            System.out.println("Subtask created: " + subtask);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void changeTaskStatus(String taskId, TaskStatus newStatus) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.changeStatus(newStatus);
            System.out.println("Task status updated: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void changeTaskAssignee(String taskId, User assignee) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.changeAssignee(assignee);
            System.out.println("Task assignee updated: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }

    public void displayUserTasks(String userName, String type) {
        User user = findUserByName(userName);
        if (user != null) {
            List<Task> tasks = user.getTasksByType(type);
            System.out.println("Tasks for " + userName + " of type " + type + ":");
            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void createSprint(String name, Date startDate, Date endDate) {
        Sprint sprint = new Sprint(name, startDate, endDate);
        sprints.add(sprint);
        System.out.println("Sprint created: " + sprint.name);
    }

    public void deleteSprint(String sprintId) {
        Sprint sprint = findSprintById(sprintId);
        if (sprint != null) {
            sprints.remove(sprint);
            System.out.println("Sprint deleted: " + sprint.name);
        } else {
            System.out.println("Sprint not found.");
        }
    }

    public void addTaskToSprint(String sprintId, String taskId) {
        Sprint sprint = findSprintById(sprintId);
        Task task = findTaskById(taskId);
        if (sprint != null && task != null) {
            sprint.addTask(task);
            System.out.println("Task added to sprint: " + sprint.name);
        } else {
            System.out.println("Sprint or Task not found.");
        }
    }

    public void removeTaskFromSprint(String sprintId, String taskId) {
        Sprint sprint = findSprintById(sprintId);
        Task task = findTaskById(taskId);
        if (sprint != null && task != null) {
            sprint.removeTask(task);
            System.out.println("Task removed from sprint: " + sprint.name);
        } else {
            System.out.println("Sprint or Task not found.");
        }
    }

    public void displaySprintSnapshot(String sprintId) {
        Sprint sprint = findSprintById(sprintId);
        if (sprint != null) {
            sprint.displaySnapshot();
        } else {
            System.out.println("Sprint not found.");
        }
    }

    private Task findTaskById(String taskId) {
        for (User user : users) {
            for (Task task : user.tasks) {
                if (task.id.equals(taskId)) {
                    return task;
                }
            }
        }
        return null;
    }

    private User findUserByName(String userName) {
        for (User user : users) {
            if (user.name.equals(userName)) {
                return user;
            }
        }
        return null;
    }

    private Sprint findSprintById(String sprintId) {
        for (Sprint sprint : sprints) {
            if (sprint.id.equals(sprintId)) {
                return sprint;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        TaskPlanner planner = new TaskPlanner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("→ ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "CreateTask":
                    planner.createTask(parts[1]);
                    break;
                case "CreateSubtask":
                    planner.createSubtask(parts[1], parts[2]);
                    break;
                case "ChangeTaskStatus":
                    planner.changeTaskStatus(parts[1], TaskStatus.valueOf(parts[2]));
                    break;
                case "ChangeTaskAssignee":
                    User user = new User(parts[2]);
                    planner.changeTaskAssignee(parts[1], user);
                    break;
                case "DisplayUserTasks":
                    planner.displayUserTasks(parts[1], parts[2]);
                    break;
                case "CreateSprint":
                    planner.createSprint(parts[1], new Date(), new Date());
                    break;
                case "DeleteSprint":
                    planner.deleteSprint(parts[1]);
                    break;
                case "AddTaskToSprint":
                    planner.addTaskToSprint(parts[1], parts[2]);
                    break;
                case "RemoveTaskFromSprint":
                    planner.removeTaskFromSprint(parts[1], parts[2]);
                    break;
                case "DisplaySprintSnapshot":
                    planner.displaySprintSnapshot(parts[1]);
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}