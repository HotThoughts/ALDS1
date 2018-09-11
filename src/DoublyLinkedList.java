import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;


class DoublyLinkedList {

    class Node{
        Node prev, next;
        int value;

        Node (int value){
            this(null,null,value);
        }

        Node(Node prev, Node next, int value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    Node head;

    DoublyLinkedList(){
        head = new Node(-1);
        head.next = head.prev = head;
    }

    /**
     * insert an element with key x into the front of the list.
     */
    void insert(int x){
        Node newNode = new Node(head,head.next,x);
        head.next.prev = head.next= newNode;
    }

    /**
     * delete the first element which has the key of x from the list.
     * If there is not such element, you need not do anything.
     */
    void delete(int x){
        Node p = head.next;
        while(p != head){
            if (p.value == x){
                p.prev.next = p.next;
                p.next.prev = p.prev;
                break;
            }
            p = p.next;
        }
    }

    /**
     * delete the first element from the list.
     */
    void deleteFirst(){
        head.next.next.prev = head;
        head.next = head.next.next;
    }

    /**
     * delete the last element from the list.
     */
    void deleteLast(){
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
    }
    void print(){
        Node p = head.next;

        StringBuilder s = new StringBuilder();
        while(p != head) {
            if (p.next == head)
                s.append(p.value);//System.out.print(p.value + "\n");
            else
                s.append(p.value).append(" ");//System.out.print(p.value + " ");
            p = p.next;
        }

        System.out.println(s);
    }


    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));



        int n = Integer.parseInt(br.readLine());
        DoublyLinkedList DL = new  DoublyLinkedList();



        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if(operation.equals("insert")) DL.insert(Integer.parseInt(st.nextToken()));
            else if(operation.equals("delete")) DL.delete(Integer.parseInt(st.nextToken()));
            else if(operation.equals("deleteFirst")) DL.deleteFirst();
            else DL.deleteLast();
        }

        DL.print();
    }
}
