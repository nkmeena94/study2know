package com.study2know.core;

import com.study2know.exceptions.*;

/**
 * Created by Anuj on 7/8/15.
 */

public class Types {

    public enum Role implements BaseTypeDef {
        USER, BUSINESS, ADMIN;

        public static Role fromId(String id) throws com.study2know.exceptions.InvalidTypeException {
            try {
                return Role.valueOf(id);
            } catch (IllegalArgumentException e) {
                throw new InvalidTypeException(e);
            }
        }
    }

    public enum Gender implements BaseTypeDef {
        MALE, FEMALE, NA;

        public static Gender fromId(String id) throws InvalidTypeException {
            try {
                return Gender.valueOf(id);
            } catch (IllegalArgumentException e) {
                throw new InvalidTypeException(e);
            }
        }
    }

    public enum DataType implements BaseTypeDef {
        STRING, NUMBER, DATE, INTEGER, LIST;

        public static DataType fromId(String id) throws InvalidTypeException {
            try {
                return DataType.valueOf(id);
            } catch (IllegalArgumentException e) {
                throw new InvalidTypeException(e);
            }
        }
    }

    public enum FilterOps implements BaseTypeDef {
        EQUALS, LIKE, STARTS, ENDS, LESSTHAN, GREATERTHAN, BETWEEN, BEFORE, AFTER;

        public static FilterOps fromId(String id) throws InvalidTypeException {
            return FilterOps.valueOf(id);
        }
    }


    public enum TIMEUNIT implements BaseTypeDef {
        MINUTE , HOUR, DAY, WEEK, MONTH;

        public static TIMEUNIT fromId(String id) throws InvalidTypeException {
            return TIMEUNIT.valueOf(id);
        }
    }



}

