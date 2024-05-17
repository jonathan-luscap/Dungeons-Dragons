package com.dnd.connection;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccessObject {

    public int add(Object obj)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public Object getObject(int id)
        throws SQLException;
    public List<Object> getObjects()
        throws SQLException;
    public void update(Object obj)
        throws SQLException;
}
