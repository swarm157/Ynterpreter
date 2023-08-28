package ru.nightmare.code.tree;

import ru.nightmare.code.tree.call.Callable;

import java.util.ArrayList;

/**
 * VarType универсальный класс база для пользовательских типов данных.
 * Используется для размещения и обработки данных пользователя.
 * Способ обработки задается и контролируется пользователем посредством размещаемых Callable.
 */
public abstract class VarType implements Callable {
    /**
     * Имя типа внутри интерпретатора
     */
    protected String name;
    protected ArrayList<Callable> functions;
    protected ArrayList<Callable> methods;
    protected ArrayList<Variable> variables;
    protected ArrayList<Variable> fields;

    /**
     * ОБЯЗАТЕЛЬНО ДОБАВИТЬ ВО ВСЕ КОНСТРУКТОРЫ ВАШЕГО КЛАССА
     */
    protected void init() {
        functions = functions();
        methods = methods();
        fields = fields();
        variables = variables();
    }

    /**
     * Стандартный конструктор с добавкой обязательного для вызова метода init
     */
    public VarType() {
        init();
    }


    /**
     * Получить методы типа данных.
     * Возвращает методы экземпляра класса которым первым аргументом всегда будет передаваться ссылка на обьект принадлежания метода
     * @return методы
     *
     */
    public ArrayList<Callable> getMethods() {
        return methods;
    }

    /**
     * Вовзращает функции привязанные лишь к конкретному типу данных, но не к конкретному экземпляру.
     * @return функции
     */
    public ArrayList<Callable> getFunctions() {
        return functions;
    }

    /**
     * Используется для связывания абстрактного интерфейсного доступа VarType с конкретной реализацией
     * Определите здесь свои поля.
     * @return поля
     */
    protected abstract ArrayList<Variable> fields();
    /**
     * Используется для связывания абстрактного интерфейсного доступа VarType с конкретной реализацией
     * Определите здесь свои переменные.
     * @return переменные
     */
    protected abstract ArrayList<Variable> variables();
    /**
     * Используется для связывания абстрактного интерфейсного доступа VarType с конкретной реализацией
     * Определите здесь свои методы.
     * @return методы
     */
    protected abstract ArrayList<Callable> methods();
    /**
     * Используется для связывания абстрактного интерфейсного доступа VarType с конкретной реализацией
     * Определите здесь свои функции.
     * @return функции
     */
    protected abstract ArrayList<Callable> functions();
    protected String doc = "Стандартная документация абстрактного обьекта типа VarType, пожалуйста, разместите свою собственную.";

    /**
     * Возвращает документацию
     * @return возвращает значение переменной String doc
     */
    @Override
    public String getDocumentation() {
        return doc;
    }
    /**
     * Возвращает имя типа внутри интерпретатора
     * @return возвращает значение переменной String name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Берет значение переменной и пробует конвертировать к своему типу данных
     * @param variable Переменная которую нужно привести к данному типу данных.
     * @return Результат автоматической конвертации.
     * @warning ВНИМАНИЕ!!! НЕЛЬЗЯ МЕНЯТЬ ПОЛЯ variable ВНУТРИ МЕТОДА autoCast!!!
     * НАРУШЕНИЕ ПРИВЕДЕТ К НЕПРЕДСКАЗУЕМЫМ ПРОБЛЕМАМ В РАБОТЕ ИНТЕРПРЕТАТОРА!!!
     */
    public abstract String autoCast(Variable variable);
    /**
     * Вовзращает поля экземпляра типа данных.
     * @return поля
     */
    public ArrayList<Variable> getFields() {
        return fields;
    }

    /**
     * Возвращает поля экземпляра класса по имени и типу возвращаемого значения
     * @param name имя поля
     * @param type тип возвращаемого значения
     * @return поле
     */
    public Variable getFieldByNameAndVarType(String name, VarType type) {
        Variable var = new Variable(type, name, "null");
        for (Variable field: fields) {
            if (field.type.name.equals(type.getName())&&name.equals(field.getName())) {
                return field;
            }
        }
        return null;
    }
    /**
     * Возвращает переменную не привязанную к экземпляру класса по имени и типу возвращаемого значения
     * @param name имя переменной
     * @param type тип возвращаемого значения
     * @return переменная
     */
    public Variable getVariableByNameAndVarType(String name, VarType type) {
        Variable var = new Variable(type, name, "null");
        for (Variable v: variables) {
            if (v.type.name.equals(type.getName())&&name.equals(v.getName())) {
                return v;
            }
        }
        return null;
    }
    /**
     * Вовзращает переменные привязанные к типу данных, но не к конкретному экземпляру.
     * @return переменные
     */
    public ArrayList<Variable> getVariables() {
        return variables;
    }
}
