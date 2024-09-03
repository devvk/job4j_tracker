package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleTask {

    private final PriorityQueue<Task> queue;

    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    /**
     * Добавляет переданную задачу в очередь.
     *
     * @param task Задача.
     */
    public void addTask(Task task) {
        queue.offer(task);
    }

    /**
     * Читает элемент из головы очереди без удаления
     *
     * @return Задача.
     */
    public Task readTask() {
        return queue.peek();
    }

    /**
     * Возвращает задачу из головы очереди с удалением.
     *
     * @return Задача.
     */
    public Task getTask() {
        return queue.poll();
    }
}
