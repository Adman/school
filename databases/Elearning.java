package elearning;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Date;

public class Elearning {
    
    private static Timestamp getCurrentTimestamp() {
        Date today = new Date();
        return new Timestamp(today.getTime());
    }

    public static void main(String[] args) {
        Connection c = null;
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/matejov9",
                                            "matejov9", "test");
                        
            PreparedStatement login_stmt = c.prepareStatement("SELECT * FROM student WHERE prihlasovacie_meno=?");
            
            int studentid;
            
            System.out.print("Login: ");
            String login = s.nextLine().toLowerCase();
            while (true) {
                login_stmt.setString(1, login);
                ResultSet rs = login_stmt.executeQuery();
                
                if (rs.next()) {
                    studentid = rs.getInt("studentid");
                    rs.close();
                    break;
                }
                System.out.print("No such user found. Login: ");
                login = s.nextLine().toLowerCase();
            }
            login_stmt.close();
            
            PreparedStatement tests = c.prepareStatement("WITH max_vysledok AS ("
                + "SELECT v.pridelenieid, MAX(v.skore) as skore FROM vysledok v GROUP BY v.pridelenieid)"
                + "SELECT p.pridelenieid, t.nazov, u.meno, u.priezvisko, p.cas_pridelenia, m.skore, t.testid"
                + " FROM pridelenie p LEFT JOIN max_vysledok m ON p.pridelenieid=m.pridelenieid, "
                    + "ucitel u, test t"
                + " WHERE p.ucitelid=u.ucitelid AND p.studentid=? AND p.testid=t.testid",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            tests.setInt(1, studentid);
            ResultSet asg = tests.executeQuery();
            int testcount = 0;

            for (; asg.next(); testcount++) {
                String skore = asg.getString("skore");
                if (asg.wasNull())
                    skore = "not result yet";
                else
                    skore = skore + "%";
                System.out.println(testcount+1 + ". " + asg.getString("nazov") + ", "
                    + asg.getString("meno") + " " + asg.getString("priezvisko") + ", "
                    + asg.getString("cas_pridelenia") + ", " + skore);
            }
            
            if (testcount == 0) {
                System.out.println("No test assigments found for this user");
                return;
            }

            int x;
            while (true) {
                System.out.print("Number of test you want to start: ");
                try {
                    String line = s.nextLine();
                    x = Integer.parseInt(line);
                    if (x >= 1 && x <= testcount)
                        break;
                    System.out.println("Test not available!");
                } catch (Exception e) {
                    System.out.println("Not a number!");
                }
            }
            
            asg.absolute(x);

            PreparedStatement q = c.prepareStatement("SELECT * FROM otazka WHERE testid=?",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            q.setInt(1, asg.getInt("testid"));
            
            ResultSet quest = q.executeQuery();
                        
            /* Count number of questions */
            double all_count = 0;
            while (quest.next())
                all_count++;
            quest.absolute(0);
            
            double correct = 0;

            PreparedStatement stmt = c.prepareStatement(
                    "INSERT INTO vysledok(cas_vypracovania, skore, pridelenieid) VALUES"
                    + "(?,?,?) RETURNING vysledokid");
            stmt.setTimestamp(1, getCurrentTimestamp());
            stmt.setInt(2, 0);
            stmt.setInt(3, asg.getInt("pridelenieid"));
            ResultSet insert = stmt.executeQuery();
            insert.next();
            int vysledokid = insert.getInt(1);

            PreparedStatement ansstmt = c.prepareStatement(
                    "INSERT INTO odpoved(text, vysledokid, otazkaid) VALUES(?,?,?)");
            ansstmt.setInt(2, vysledokid);
            
            PreparedStatement resultupd = c.prepareStatement(
                    "UPDATE vysledok SET cas_vypracovania=?, skore=?"
                    + "WHERE vysledokid=?");
            resultupd.setInt(3, vysledokid);
            resultupd.setInt(2, 0);

            while (quest.next()) {
                String[] answers = {quest.getString("spravne"), quest.getString("nespravne1"),
                                     quest.getString("nespravne2"), quest.getString("nespravne3")};
                
                Collections.shuffle(Arrays.asList(answers));
                
                ArrayList<String> possible = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "n"));
                
                System.out.println(quest.getString("text"));
                System.out.println("a) " + answers[0]);
                System.out.println("b) " + answers[1]);
                System.out.println("c) " + answers[2]);
                System.out.println("d) " + answers[3]);
                System.out.print("Answer (or n to skip): ");
                String a = s.nextLine().toLowerCase();
                
                while (possible.indexOf(a) == -1) {
                    System.out.print("Cannot accept answer. Answer (or n to skip): ");
                    a = s.nextLine().toLowerCase();
                }
                
                int ans_num;
                switch (a) {
                    case "a":
                        ans_num = 0;
                        break;
                    case "b":
                        ans_num = 1;
                        break;
                    case "c":
                        ans_num = 2;
                        break;
                    case "d":
                        ans_num = 3;
                        break;
                    default:
                        ans_num = 4;
                        break;
                }
                
                if (ans_num != 4) {
                    if (quest.getString("spravne").equals(answers[ans_num])) {
                        correct++;
                        resultupd.setInt(2, (int)((correct/all_count)*100.0));
                    }
                    ansstmt.setString(1, answers[ans_num]);
                    ansstmt.setInt(3, quest.getInt("otazkaid"));
                    ansstmt.executeUpdate();
                }
                
                resultupd.setTimestamp(1, getCurrentTimestamp());
                resultupd.executeUpdate();
            }
            
            System.out.println("Test result: " + (int)((correct/all_count)*100.0) + "%");

            
            quest.close();
            q.close();
            asg.close();
            tests.close();
            ansstmt.close();
            resultupd.close();

            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}