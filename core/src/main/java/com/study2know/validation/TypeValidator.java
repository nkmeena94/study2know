package com.study2know.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by anuj on 29/9/15.
 */
public class TypeValidator implements ConstraintValidator<VerifyType, String> {

    Class enumClass;

    public void initialize(final VerifyType enumObject) {
        enumClass = enumObject.value();

    }

    public boolean isValid(final String myval, final ConstraintValidatorContext constraintValidatorContext) {

        if ((myval != null) && (enumClass != null)) {
            Object[] enumValues = enumClass.getEnumConstants();
            Object enumValue;

            for (Object enumerable : enumValues) {

                if (myval.equals(enumerable.toString())) return true;
                enumValue = getEnumValue(enumerable);
                if ((enumValue != null)
                        && (myval.toString().equals(enumValue.toString()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Invokes the getValue() method for enum if present
     *
     * @param enumerable The Enum object
     * @return returns the value of enum from getValue() or
     * enum constant
     */
    private Object getEnumValue(Object enumerable) {
        try {
            for (Method method : enumerable.getClass().getDeclaredMethods()) {
                if (method.getName().equals("getValue")) {
                    return method.invoke(enumerable);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
