package com.Maker.service;



import com.Maker.model.MoneySafe;

import java.util.List;

public interface MoneySafeService {

    MoneySafe addMoneySafe(MoneySafe illness,int uID);
    MoneySafe editMoneySafe(int id,MoneySafe illness);

    MoneySafe AddBalancedMoneySafe(int id, float balance);

    MoneySafe TakeBalancedMoneySafe(int id, float balance);

    MoneySafe getMoneySafe(String username);
    MoneySafe getMoneySafe(int id);
    List<MoneySafe> getAllMoneySafe();
}
