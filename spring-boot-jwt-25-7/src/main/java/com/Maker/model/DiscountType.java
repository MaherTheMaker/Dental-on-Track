package com.Maker.model;


public enum DiscountType{
    noDiscount(0.0f)
    ,family_Friends(0.2f)
    ,Dentist(0.25f)
    ,students(0.15f);


        public final float value;

        private DiscountType(float value) {
            this.value = value;
        }



}