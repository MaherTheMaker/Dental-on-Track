package com.Maker.service;



import com.Maker.model.MoneySafe;

import java.util.List;

public interface MoneySafeService {

    MoneySafe addMoneySafe(MoneySafe illness,int uID);
    MoneySafe editMoneySafe(int id,MoneySafe illness);
    MoneySafe getMoneySafe(String username);
    MoneySafe getMoneySafe(int id);
    List<MoneySafe> getAllMoneySafe();
}
