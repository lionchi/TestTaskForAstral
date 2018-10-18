package com.gavrilov.common;

import java.sql.*;

/*
 Использую хелпер jdbc, чтобы вытащить из бд картинку, т.к в сервелетах не рекомендуется делать привязку к дао или на прямую к entityManager.
 Да и работать она будет так как сервелет не входит в контекст спринга.
 */
public class HelperJdbc {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/astral?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8&&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "root";

    public static byte[] main(Long id) {
        Connection connection;
        Statement statement;
        byte[] bytes = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            String query = String.format("SELECT image FROM Note where id = %s", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                bytes = resultSet.getBytes("image");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return bytes;
    }
}
