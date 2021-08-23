import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloMysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Connection conn = DriverManager.getConnection("jdbc:mysql://dijkstra.cs.bilkent.edu.tr:3306/mert_duran", "mert.duran", "mkyRf3AL");
		System.out.println("Connected To Database");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
		stmt.executeUpdate("DROP TABLE IF EXISTS student");
		stmt.executeUpdate("DROP TABLE IF EXISTS company");
		stmt.executeUpdate("DROP TABLE IF EXISTS apply");
		stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");


		String sql = "CREATE TABLE student " +
                "(sid char(12) UNIQUE, " +
                " sname VARCHAR(50), " + 
                " bdate DATE, " + 
                " address VARCHAR(50), " + 
                " scity VARCHAR(20), " + 
                " year char(20), " + 
                " gpa FLOAT, " + 
                " nationality VARCHAR(20), "+
                " PRIMARY KEY (sid))";
		stmt.executeUpdate(sql);

		sql = "CREATE TABLE company "+
				"(cid char(8) UNIQUE, " +
				"cname VARCHAR(20), " +
				"quota INT," +
				"PRIMARY KEY (cid))";

		stmt.executeUpdate(sql);

		sql = "CREATE TABLE apply "+
				"(sid char(12), " +
				"cid char(8), " +
        		"PRIMARY KEY (sid, cid)," + 
        		"CONSTRAINT fk_student FOREIGN KEY (sid)" +  
        		"REFERENCES student(sid)" +
        		" ON DELETE CASCADE" +
        		" ON UPDATE CASCADE," +
				" CONSTRAINT fk_company FOREIGN KEY (cid)" +  
				" REFERENCES company(cid)" +	
				" ON DELETE CASCADE" +
				" ON UPDATE CASCADE)"; 


		stmt.executeUpdate(sql);

		stmt.executeUpdate("ALTER TABLE apply ENGINE=InnoDB;");
		
		stmt.executeUpdate("INSERT INTO student VALUES(21000001, 'John', '1999-05-14', 'Windy', 'Chicago', 'senior', 2.33, 'US');");
		stmt.executeUpdate("INSERT INTO student VALUES(21000002, 'Ali', '2001-09-30', 'Nisantasi', 'Istanbul', 'junior', 3.26, 'TC');");
		stmt.executeUpdate("INSERT INTO student VALUES(21000003, 'Veli', '2003-02-25', 'Nisantasi', 'Istanbul', 'freshman', 2.41, 'TC');");
		stmt.executeUpdate("INSERT INTO student VALUES(21000004, 'Ayse', '2003-01-15', 'Tunali', 'Ankara', 'freshman', 2.55, 'TC');");
		stmt.executeUpdate("INSERT INTO company VALUES('C101', 'microsoft', 2);");
		stmt.executeUpdate("INSERT INTO company VALUES('C102', 'merkez bankasi', 5);");
		stmt.executeUpdate("INSERT INTO company VALUES('C103', 'tai', 3);");
		stmt.executeUpdate("INSERT INTO company VALUES('C104', 'tubitak', 1);");
		stmt.executeUpdate("INSERT INTO company VALUES('C105', 'aselsan', 3);");
		stmt.executeUpdate("INSERT INTO company VALUES('C106', 'havelsan', 4);");
		stmt.executeUpdate("INSERT INTO company VALUES('C107', 'milsoft', 2);");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000001, 'C101');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000001, 'C102');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000001, 'C103');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000002, 'C101');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000002, 'C105');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000003, 'C104');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000003, 'C105');");
		stmt.executeUpdate("INSERT INTO apply VALUES(21000004, 'C107');");
		
        ResultSet rS = stmt.executeQuery("SELECT * FROM student");
        while (rS.next()) {

            System.out.println(rS.getString("sid") +" "+ rS.getString("sname") +" "+ rS.getString("bdate") +" "+ 
            rS.getString("address") +" "+ rS.getString("scity") +" "+ rS.getString("year")+" "+
            		rS.getString("gpa") +" " + rS.getString("nationality"));
        }

		}catch(Exception e)
		{
		System.err.println(e);
		System.out.println("Could not connected.");
		}

	}

}
