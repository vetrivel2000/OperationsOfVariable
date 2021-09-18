import logical.LogicalLayer;

import java.util.HashMap;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        LogicalLayer logical = new LogicalLayer();
        int choice;
        do {
            System.out.println("1.SET\n2.GET\n3.UNSET\n4.UPDATE\n5.COUNT\n6.BEGIN\n7.ROLLBACK\n8.COMMIT");
            System.out.println("Enter choice");
            choice=scan.nextInt();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("SET");
                    char variableName=scan.next().charAt(0);
                    System.out.println("Value=");
                    int value = scan.nextInt();
                    logical.setData(variableName,value);
                    break;
                }
                case 2:
                {
                    System.out.println("GET");
                    char variableName=scan.next().charAt(0);
                    HashMap<Character,Integer> data= logical.getData();
                    System.out.println(data.get(variableName));
                    break;
                }
                case 3:
                {
                    System.out.println("UNSET");
                    char variableName=scan.next().charAt(0);
                    logical.unSetData(variableName);
                    break;
                }
                case 4:
                {
                    System.out.println("UPDATE");
                    char variableName=scan.next().charAt(0);
                    HashMap<Character,Integer> data= logical.getData();
                    if(!(data.containsKey(variableName)))
                    {
                        System.out.println("No variable named '"+variableName+"'");
                        return;
                    }
                    System.out.println("Value=");
                    int value = scan.nextInt();
                    logical.updateData(variableName,value);
                    break;
                }
                case 5:
                {
                    System.out.println("COUNT");
                    int value= scan.nextInt();
                    int count=logical.countValues(value);
                    System.out.println(count);
                    break;
                }
                case 6:
                {
                    System.out.println("BEGIN");
                    logical.beginTransaction();
                    break;
                }
                case 7:
                {
                    System.out.println("ROLLBACK");
                    logical.rollbackTransaction();
                    break;
                }
                case 8:
                {
                    System.out.println("COMMIT");
                    logical.commitTransaction();
                    break;
                }
            }
        }while (choice<9);
    }
}
