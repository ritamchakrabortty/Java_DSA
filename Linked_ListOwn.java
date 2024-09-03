class Node
{
    int data;
    Node next;
}
class LinkedList
{
    Node head;
    public void insert(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null)
        {
            head = node;
        }
        else
        {
            Node n = head;
            while (n.next != null)
            {
                n = n.next;
            }
            n.next = node;
        }
    }
    public void insertAtStart(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }
    public void show()
    {
        Node node = head;
        while(node.next != null)
        {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
    public void insertAt(int index, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        Node n = head;
        for(int i=0; i<index-1; i++)
        {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }
}
class Demo
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(12);
        list.insert(6);
        list.insert(9);
        list.insertAtStart(3);
        list.insertAtStart(8);
        list.insertAt(2,55);

        list.show();
    }
}