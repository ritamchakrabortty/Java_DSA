class Stack
{
    int stack[] = new int[5];
    int top = -1;
    public boolean isEmpty()
    {
        if(top == -1)
        {
            return true;
        }
        else
            return false;
    }
    public boolean isFull()
    {
        if(top ==stack.length-1)
        {
            return true;
        }
        else
            return false;
    }
    public void push(int data)
    {
        if(!isFull())
        {
            stack[++top] = data;
        }
        else{
            System.out.println("Stack is full");
        }
        
    }
    public void show()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            for(int i=0;i<=top;i++)
            {
                System.out.print(stack[i]+" ");
            }
        }
    }
    
    public int pop()
    {
        int data=-1;
        if(!isEmpty())
        {
            
            data = stack[top--];
           
        }
        else
        {
            System.out.println("Stack empty!");
        }
        return data;
       
    }
    public int peek()
    {
        if(!isEmpty())
            return  stack[top];
        else
        {
            System.out.println("Stack empty!");
            return -1;
        }
            
    }
    public int size()
    {

        return top+1;
    }
   
}



class Runner
{
    public static void main(String[] args)
    {
        Stack nums = new Stack();
        nums.push(15);
        nums.push(8);
        nums.push(10);
        nums.push(11);
        nums.push(7);
        nums.push(33);
        
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
        System.out.println("Popped element is: "+nums.pop());
        System.out.println("Peeked element is: "+nums.peek());
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
        System.out.println("Popped element is: "+nums.pop());
        System.out.println("Peeked element is: "+nums.peek());
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
        System.out.println("Popped element is: "+nums.pop());
        System.out.println("Peeked element is: "+nums.peek());
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
        System.out.println("Popped element is: "+nums.pop());
        System.out.println("Peeked element is: "+nums.peek());
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
        System.out.println("Popped element is: "+nums.pop());
        System.out.println("Peeked element is: "+nums.peek());
        System.out.print("Current stack is: ");
        nums.show();
        System.out.println();
        System.out.println("Size : "+nums.size());
       
        
    }
}