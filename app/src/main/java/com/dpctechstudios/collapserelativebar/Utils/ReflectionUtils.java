package com.dpctechstudios.collapserelativebar.Utils;

import java.lang.reflect.Field;


public class ReflectionUtils {
    public static Field getOriginalField(Object targetInstance, String fieldName) throws NoSuchFieldException {
        Class<?> cls = targetInstance.getClass();
        Field f = null;
        while (f == null) {
            try {
                f = cls.getDeclaredField(fieldName);
                f.setAccessible(true);
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        f.setAccessible(true);
        return f;
    }
}
