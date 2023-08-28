package ru.nightmare.code.tree.call;

import ru.nightmare.code.tree.VarType;
import ru.nightmare.code.tree.Variable;

public class Print implements Callable{
    @Override
    public Variable call(Variable... args) {
        return null;
    }

    @Override
    public Variable[] getParametersList() {
        return new Variable[0];
    }

    @Override
    public String getDocumentation() {
        return null;
    }

    @Override
    public VarType getReturnType() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
