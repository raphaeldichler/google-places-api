package net.plyse.api.google.places.util;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public final class Utility {

    private Utility() {
        throw new IllegalCallerException();
    }

    public static Set<Class> loadAllClassesInProject() throws IOException {
        return ClassPath.from(ClassLoader.getSystemClassLoader())
                .getAllClasses()
                .stream()
                .filter(clazz -> clazz.getPackageName().startsWith("net.plyse.api.google"))
                .map(ClassPath.ClassInfo::load)
                .collect(Collectors.toSet());
    }

}
