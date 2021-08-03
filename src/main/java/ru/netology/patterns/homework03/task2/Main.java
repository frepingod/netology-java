package ru.netology.patterns.homework03.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        String command;

        printHead();
        printField(frog);

        while (true) {
            command = SCANNER.nextLine();

            if (command.equals("0")) {
                System.out.println("Bye!");
                SCANNER.close();
                break;
            }

            switch (command) {
                case "<<":  /*пользователь хочет отменить действие*/
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                    break;
                case ">>":  /*пользователь хочет повторить действие*/
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего повторять!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).doIt();
                    }
                    break;
                case "!!":  /*пользователь хочет повторить последнюю команду*/
                    if (curCommand < 0) {
                        System.out.println("Нечего повторять!");
                    } else {
                        commands.get(curCommand).doIt();
                        commands.add(commands.get(curCommand));
                        curCommand++;
                    }
                    break;
                default:  /*пользователь ввёл новое движение для лягушки*/
                    if (curCommand != commands.size() - 1) {
                        List<FrogCommand> delete = commands.subList(curCommand + 1, commands.size());
                        commands.removeAll(delete);
                    }

                    FrogCommand cmd = FrogCommands.jumpCommand(frog, Integer.parseInt(command));
                    curCommand++;
                    commands.add(cmd);
                    cmd.doIt();
                    break;
            }

            printField(frog);
        }
    }

    private static void printHead() {
        System.out.println("Есть поле - одномерный массив из 11 клеток, посередине сидит лягушка. Мы можем давать ей команды:\n" +
                "\t+N - прыгни на N шагов направо\n" +
                "\t-N - прыгни на N шагов налево\n" +
                "\t<< - Undo (отмени последнюю команду)\n" +
                "\t>> - Redo (повтори отменённую команду)\n" +
                "\t!! - повтори последнюю команду\n" +
                "\t 0 - выход"
        );
    }

    private static void printField(Frog frog) {
        for (char c : frog.field()) {
            System.out.print(c);
        }
        System.out.println();
    }
}