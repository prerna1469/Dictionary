package dictionary;
import java.util.*;
public class Bst {
    private Node root;
    public Bst()
    {
        root=null;
    }
    void create_bst()
    {
        Scanner sc=new Scanner(System.in);
        Node ptr;
        char ch='\0';
        String key="\0";
        String mean="\0";
        do
        {
            Node temp=new Node();
            System.out.println("Enter a keyword");
            key=sc.next();
            temp.setKeyword(key);
            System.out.println("Enter its meaning");
            String str=sc.nextLine();
            mean=sc.nextLine();
            temp.setMeaning(mean);
            if(root==null)
            {
                root=temp;

            }
            else
            {
                ptr=root;
                while(ptr!=null)
                {
                    if(ptr.getKeyword().compareTo(temp.getKeyword())>0)
                    {
                        if(ptr.getLeft() ==null)
                        {
                            ptr.setLeft(temp);
                            break;
                        }
                        else
                        {
                            ptr= ptr.getLeft();
                        }
                    }
                    else
                    {
                        if(ptr.getRight() ==null)
                        {
                            ptr.setRight(temp);
                            break;
                        }
                        else
                        {
                            ptr= ptr.getRight();
                        }
                    }
                }
            }

            System.out.println("Do you want to continue? y or n");
            ch=sc.next().charAt(0);
        }while(ch=='y');
    }
    private void inOrder(Node localRoot)
    {
        if(localRoot!=null)
        {
            inOrder(localRoot.getLeft());
            System.out.print(" "+ localRoot.getKeyword());
            inOrder(localRoot.getRight());
        }
    }
    void func_inOrder()
    {
        inOrder(root);
    }

    private void inOrder1(Node localRoot)
    {
        if(localRoot!=null)
        {
            inOrder1(localRoot.getLeft());
            System.out.println("Word - "+ localRoot.getKeyword() +" Meaning - "+ localRoot.getMeaning());
            inOrder1(localRoot.getRight());
        }
    }
    void func_inOrder1()
    {
        inOrder1(root);
    }

    void search()
    {
        Scanner sc=new Scanner(System.in);
        int flag=0;
        String key="\0";
        Node ptr;
        System.out.println("\nEnter keyword to be searched");
        key=sc.nextLine();
        ptr=root;
        while(ptr!=null)
        {
            if(key.equals(ptr.getKeyword()))
            {
                flag=1;
                break;
            }
            if(key.compareTo(ptr.getKeyword())<0)
            {
                ptr= ptr.getLeft();
            }
            else
            {
                ptr= ptr.getRight();
            }
        }
        if(flag==1)
        {
            System.out.println(key+" is found ");
            System.out.println("Meaning is ");
            System.out.println(ptr.getMeaning());
        }
        else
        {
            System.out.println(key+" is not found ");
        }
    }
    void update()
    {
        Scanner sc=new Scanner(System.in);
        int flag=0;
        String key="\0";
        String mean="\0";
        Node ptr;
        System.out.println("\nEnter keyword whose meaning is to be changed ");
        key=sc.nextLine();
        ptr=root;
        while(ptr!=null)
        {
            if(key.equals(ptr.getKeyword()))
            {
                flag=1;
                break;
            }
            if(key.compareTo(ptr.getKeyword())<0)
            {
                ptr= ptr.getLeft();
            }
            else
            {
                ptr= ptr.getRight();
            }
        }
        if(flag==1)
        {
            System.out.println(key+" is found ");
            System.out.println("Meaning is ");
            System.out.println(ptr.getMeaning());
            System.out.println("Enter new meaning");
            mean=sc.nextLine();
            ptr.setMeaning(mean);
        }
        else
        {
            System.out.println(key+" is not found ");
        }
    }
    void delete()
    {
        Node parent;
        Node ptr;
        int flag=0;
        Scanner sc=new Scanner(System.in);
        String str;
        System.out.println("Enter key to be deleted");
        str=sc.next();
        ptr=root;
        parent=root;
        while(str.compareTo(ptr.getKeyword())!=0)
        {
            parent=ptr;
            if(str.compareTo(ptr.getKeyword())<0)
            {
                ptr= ptr.getLeft();
            }
            else
            {
                ptr= ptr.getRight();
            }
        }
        if(ptr.getLeft() ==null && ptr.getRight() ==null)
        {
            if(ptr== parent.getLeft())
            {
                parent.setLeft(null);
            }
            else
            {
                parent.setRight(null);
            }
            flag=1;
        }
        if(ptr.getLeft() ==null && ptr.getRight() !=null)
        {
            if(ptr== parent.getLeft())
                parent.setLeft(ptr.getRight());
            else
                parent.setRight(ptr.getRight());
            flag=1;
        }
        if(ptr.getLeft() !=null && ptr.getRight() ==null)
        {
            if(ptr== parent.getLeft())
                parent.setLeft(ptr.getLeft());
            else
                parent.setRight(ptr.getLeft());
            flag=1;
        }
        if(ptr.getLeft() !=null && ptr.getRight() !=null)
        {
            Node temp= ptr.getLeft();
            parent=ptr;
            while(temp.getRight() !=null)
            {
                parent=temp;
                temp= temp.getRight();
            }
            if(parent.getLeft() ==temp)
            {
                parent.setLeft(temp.getLeft());
                parent.setKeyword(temp.getKeyword());
                parent.setMeaning(temp.getMeaning());
            }
            else
            {
                parent.setLeft(temp.getLeft());
                parent.setKeyword(temp.getKeyword());
                parent.setMeaning(temp.getMeaning());
            }
            temp=null;
            flag=1;
            System.out.println("Word deleted");
        }
        if(flag==0)
        {
            System.out.println("Not found");
        }
    }
}
