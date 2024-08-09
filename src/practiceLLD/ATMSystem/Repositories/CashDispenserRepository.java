package practiceLLD.ATMSystem.Repositories;

import practiceLLD.ATMSystem.Models.CashDispenser;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CashDispenserRepository {

    Map<Long, CashDispenser> cashDispensersMap;

    public CashDispenserRepository() {
        this.cashDispensersMap = new ConcurrentHashMap<>();
    }

    public void add(CashDispenser cashDispenser){

        cashDispensersMap.put(cashDispenser.getId(), cashDispenser);

    }
}
