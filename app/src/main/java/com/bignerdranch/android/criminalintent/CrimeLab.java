package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private Map<UUID, Crime> mCrimes;

    private CrimeLab(Context context){
        mCrimes = new LinkedHashMap<>();
        for(int i=0; i<100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 == 0);
            crime.setmRequiresPolice(i % 3 == 0);
            mCrimes.put(crime.getmID(), crime);
        }

    }

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes(){
        return new ArrayList<>(mCrimes.values());
    }

    public Crime getCrime(UUID id) {
//        for(Crime crime : mCrimes) {
//            if(crime.getmID().equals(id)) {
//                return crime;
//            }
//        }
        return mCrimes.get(id);
    }

}
