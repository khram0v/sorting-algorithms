package io.github.khram0v.ui;

import io.github.khram0v.input.InputHandler;
import io.github.khram0v.model.DataType;
import io.github.khram0v.model.SortableList;

public class MainMenu {
    private final InputHandler handler = new InputHandler();

    public void show() {
        System.out.println("""
                ~~~ Main Menu ~~~
                
                1. Manage list
                2. Sort list
                0. Exit
                """);
    }

    public void run() {
        DataType type = handler.askDataType();
        SortableList<?> list = createListFor(type);

        while (true) {
            handler.clearScreen();
            show(); // display UI

            int choice = handler.readRangeChoice(0, 2, "> ");

            // Exit the app
            if (choice == 0) {
                System.out.println("Bye!");
                return;
            }

            switch (choice) {
                case 1 -> new ListMenu(handler).run(list, type);
                case 2 -> new SortingMenu(handler).run(list);
            }
        }
    }

    private SortableList<?> createListFor(DataType type) {
        return switch (type) {
            case INTEGER -> new SortableList<Integer>();
            case DOUBLE -> new SortableList<Double>();
            case STRING -> new SortableList<String>();
        };
    }
}