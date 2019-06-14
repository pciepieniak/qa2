package com.jsystems.qa2.api.database;

import com.jsystems.qa2.api.model.user.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public static UserDb getOneById(Long id)
    {
        String sql = "SELECT * FROM testuser  WHERE id = " + id;

        UserDb userDb =  new UserDb();

        try
        {
            Statement statment = DatabaseConnector.getConnection().createStatement();
            ResultSet resultSet =  statment.executeQuery(sql);

            while (resultSet.next())
            {
                userDb.setId(resultSet.getLong(1));
                userDb.setName(resultSet.getString(2));
                userDb.setSurname(resultSet.getString(3));
            }

            resultSet.close();
            statment.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return userDb;
    }
}
