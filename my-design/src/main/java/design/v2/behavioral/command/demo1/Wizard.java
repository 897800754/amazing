package design.v2.behavioral.command.demo1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 巫师
 */
public class Wizard {
    /**
     * Runnable 太经典了
     * start 一根线程 runnable就是一种命令模式
     */
    private final Deque<Runnable> undoStack = new LinkedList<>();
    private final Deque<Runnable> redoStack = new LinkedList<>();

    public Wizard() {
    }

    /**
     * 释放咒语
     *
     * @param runnable
     */
    public void castSpell(Runnable runnable) {
        runnable.run();
        undoStack.offerLast(runnable);
    }

    /**
     * 撤销上次咒语
     */
    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Runnable previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    /**
     * 重做上次咒语
     */
    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Runnable previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
