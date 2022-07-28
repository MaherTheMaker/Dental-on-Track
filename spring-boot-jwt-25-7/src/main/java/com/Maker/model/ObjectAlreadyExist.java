package com.Maker.model;

public class ObjectAlreadyExist extends RuntimeException {

        private String message;

    public ObjectAlreadyExist() {}

    public ObjectAlreadyExist(String msg)
        {
            super(msg);
            this.message = msg;
        }

}
