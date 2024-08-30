/**
 * Task with no date/time attached.
 */
public class TaskTodo extends Task {
    TaskTodo(String name) throws TorneInvalidCommandException {
        super(name);
    }

    @Override
    public String toString() {
        String status = isDone ? "X" : " ";

        // format based on the toString output of `Task`
        return String.format("[T]%s", super.toString());
    }

    @Override
    public String toStorageString() {
        return String.format(
                "%s / %d / %s",
                "T",
                isDone ? 1 : 0,
                name);
    }
}
