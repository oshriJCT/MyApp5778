package com.example.coshri.myapp5778.model.backend;

import com.example.coshri.myapp5778.model.datasourse.List_DBManager;
import com.example.coshri.myapp5778.model.datasourse.MySQL_DBManager;

/**
 * Created by mailo on 13/11/2017.
 */

public class DBManagerFactory {

    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null)
        {
          //  manager = new List_DBManager();
            manager = new MySQL_DBManager();
        }
        return manager;
    }

}
