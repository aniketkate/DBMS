import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.mongodb.*;

public class Mg {
    public static void main(String[] args) {
        try {
            int ch, i = 0;
            String str;
            MongoClient client = new MongoClient();
            DB db = client.getDB("Mydb");
            DBCollection col = db.getCollection("info");
            BasicDBObject obj1 = new BasicDBObject().append("Name", "ABC");
            BasicDBObject obj3 = new BasicDBObject().append("Name", "XYZ");
            col.save(obj1);
            col.save(obj3);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("1.Insert\n2.Display\n3.update\n4.Drop\n5.Exit");
                System.out.println("Enter Choice");
                ch = Integer.parseInt(br.readLine());
                switch (ch) {
                    case 1:
                        System.out.println("Enter name:");
                        str = br.readLine();
                        BasicDBObject obj4 = new BasicDBObject().append("Name", str);
                        col.save(obj4);
                        System.out.println("inserted");
                        break;
                    case 2:
                        DBCursor cur = col.find();
                        while (cur.hasNext()) {
                            System.out.println(cur.next());
                        }
                        break;
                    case 3:
                        System.out.println("Enter name:");
                        str = br.readLine();
                        BasicDBObject obj5 = new BasicDBObject().append("Name", str);
                        col.update(obj1, obj5);
                        System.out.println("updated");
                        break;
                    case 4:
                        col.drop();
                        System.out.println("Deleted");
                        break;
                    case 5:
                        System.exit(0);
                }
                System.out.println("Enter 1 to continuee");
                i = Integer.parseInt(br.readLine());
            } while (i == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
