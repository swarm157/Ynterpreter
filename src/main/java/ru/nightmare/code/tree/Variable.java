package ru.nightmare.code.tree;

import ru.nightmare.code.tree.call.Callable;

import java.util.ArrayList;

/**
 * Класс представляющий из себя переменную.
 * Значение переменной представляет из себя строку.
 * Доступ к строке обрабатывается заданным классом типом переменной.
 * Тип переменной, абстрактный класс, позволяющий размещать внутри себя любые пользовательские типы данных.
 * От самовольно созданных примитивов до многомерных ООП конструкций.
 */
public class Variable {
    VarType type;
    String name;
    String value;


    public Variable(VarType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Variable(VarType type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public VarType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    /**
     * Добавляет к аргументам указатель на принадлежную переменную и вызывает наиболее подходящий метод, выбирает первый из нескольких или возвращает null
     * @param name имя вызываемого метода
     * @param setBeTo тип данных возвращаемый методом
     * @param args аргументы передаваемые методы
     * @return переменную с результатом работы метода
     */
    public Variable callMethod(String name, VarType setBeTo, Variable... args) {
        Variable result = new Variable(setBeTo, "result", "null");
        Variable[] argsWithRelatedSubject = new Variable[args.length+1];
        argsWithRelatedSubject[0] = this;
        for (int i = 1; i < args.length+1; i++) {
            argsWithRelatedSubject[i] = args[i];
        }
        ArrayList<Callable> passed = new ArrayList<>();
        for (Callable m: type.getMethods()) {
            if (Callable.validateArgs(m, argsWithRelatedSubject)&&m.getReturnType().equals(setBeTo.name))
                passed.add(m);
        }
        if (passed.isEmpty())
            return result;
        else
            return passed.get(0).call(argsWithRelatedSubject);
    }
    /**
     * Вызывает наиболее подходящую функцию, выбирает первую из нескольких или возвращает null
     * @param name имя вызываемой функции
     * @param setBeTo тип данных возвращаемый функцией
     * @param args аргументы передаваемые функции
     * @return переменную с результатом работы функции
     */
    public Variable callFunction(String name, VarType setBeTo, Variable... args) {
        Variable result = new Variable(setBeTo, "result", "null");
        ArrayList<Callable> passed = new ArrayList<>();
        for (Callable m: type.getFunctions()) {
            if (Callable.validateArgs(m, args)&&m.getReturnType().equals(setBeTo.name))
                passed.add(m);
        }
        if (passed.isEmpty())
            return result;
        else
            return passed.get(0).call(args);
    }

    /**
     * Метод для присваивания значений с автоматическим кастом к типу данных переменной
     * @param value переменная, чье значение будет присвоено данной переменной
     */
    public void setValue(Variable value) {
        this.value = this.getType().autoCast(value);
    }
}
