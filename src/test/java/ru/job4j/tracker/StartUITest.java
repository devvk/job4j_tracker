package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"100", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 - 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. FindById" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + "Item {id=" + item.getId()
                        + ", name='" + item.getName() + "', "
                        + "created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. FindById" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "New item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findByName(item.getName())[0].getName(), is("New item"));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. FindByName" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by name ====" + System.lineSeparator()
                        + "Item {id=" + item.getId()
                        + ", name='" + item.getName() + "', "
                        + "created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. FindByName" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        //assertThat(tracker.findByName(item.getName())[0].getName(), is("New item"));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. FindAll" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find all items ====" + System.lineSeparator()
                        + "Item {id=" + item.getId()
                        + ", name='" + item.getName() + "', "
                        + "created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. FindAll" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    /**
     * 1. Трекер загружается с одним действием - "выйти".
     * 2. На консоль выводится пункт "Выйти".
     * 3. В тесте проверяем, что StubInput содержит вывод меню.
     */
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    /**
     * 1. Показать меню.
     * 2. Выбрать пункт "Создание заявки"
     * 3. Выбрать пункт "Выйти"
     * 4. Проверить, что в объект Tracker появилась новая заявка с именем "Item name".
     */
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}
