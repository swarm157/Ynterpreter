package ru.nightmare.code.tree.call;

import ru.nightmare.code.tree.VarType;
import ru.nightmare.code.tree.Variable;

public interface Callable {
    Variable call(Variable... args);
    Variable[] getParametersList();
    String getDocumentation();
    VarType getReturnType();
    String getName();

    static boolean validateArgs(Callable callable, Variable... args) {
        if (callable.getParametersList().length==args.length) {
            for (int i = 0; i < callable.getParametersList().length; i++) {
                if (callable.getParametersList()[i].getType().equals(args[i].getType())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
