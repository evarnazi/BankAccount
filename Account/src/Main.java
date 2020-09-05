import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        if (age < 18) throw new AgeNotInRangeException(null);
        System.out.println("Salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Job: ");
        String job = scanner.nextLine();
        PersonalInformation pI = new PersonalInformation(name, age, salary, address, job);
        File file = serializePersonalInfo(pI);
        PersonalInformation pID = deserialize(file);

        System.out.println("Name: " + pID.getName());
        System.out.println("Age: " + pI.getAge());
        System.out.println("Salary: " + pI.getSalary());
        System.out.println("Address: " + pI.getAdress());
        System.out.println("Job: " + pI.getJob());
        //createTable(null);
        
    }

    private static Connection getConnected() throws Exception{
    	try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:orcl" , "system", "system");
        
        } catch(SQLException e) {
        e.printStackTrace();
        }
		return null;
    }
    
    private static void createTable(Connection con) throws Exception{
    	Statement stmt = con.createStatement();
    	try{
    	stmt = con.createStatement();
        String record="INSERT INTO users (Name, Age, Salary, Adress, Job) "
            + "VALUES (John, 30, 10000, New York, Banker)";
        stmt.executeUpdate(record);

      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          if (stmt != null) {
            stmt.close();
          }
          if (con != null) {
            con.close();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }}
 
    
    private static File serializePersonalInfo(PersonalInformation pI) throws Exception{
        File file = new File("PI.txt");
        if (!file.exists())
            file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        System.out.println("Serialized");
        objectOutputStream.writeObject(pI);
        fileOutputStream.close();
        objectOutputStream.close();
        return file;
    }

    private static PersonalInformation deserialize(File file) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println("Deserializing...");
        PersonalInformation personalInfo = (PersonalInformation) objectInputStream.readObject();
        return personalInfo;
    }
    }