package dictionary
import java.util.*;

fun main(args: Array<String>) {
    // TODO Auto-generated method stub
    val obj = Bst()
    val sc = Scanner(System.`in`)
    var choice = 0
    //System.out.println("\nEnter keyword to be searched");
    //String key=sc.nextLine();
    //obj.delete(key);
    //obj.func_inOrder();
    do {
        do {
            println("\nMenu")
            println("1.Create a bst or insert new word in it ")
            println("2.Display of words ")
            println("3.Display words with their meaning")
            println("4.Search a keyword")
            println("5.Update a keyword")
            println("6.Delete a keyword")
            println("0.Exit")
            println("Enter choice: ")
            choice = sc.nextInt()
        } while (choice < 0 && choice > 6)
        when (choice) {
            1 -> obj.create_bst()
            2 -> {
                println("\nInorder traversal")
                obj.func_inOrder()
            }
            3 -> {
                println("\nInorder traversal with meaning")
                obj.func_inOrder1()
            }
            4 -> obj.search()
            5 -> obj.update()
            6 -> obj.delete()
            0 -> println("End of program.Thank you")
            else -> println("Invalid input")
        }
    } while (choice != 0)
}