class Demo
{
    public static void main(String[] args)
    {
        int nums[] = {5,2,1,3,9,7,6};
        int size = nums.length;
        System.out.println("Before sortings");
        for(int num: nums)
        {
            System.out.print(num + " ");
        }
        for(int i=0; i<size-1; i++)
        {
            int flag =0;
            for(int j=0;j<size-i-1; j++)
            {
                if(nums[j+1]<nums[j])
                {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    flag++;
                }
               
                
            }
             System.out.println();
             for(int num: nums)
             {
                    System.out.print(num + " ");
             }
            if(flag==0)
            {
                break;
            }
        }

        System.out.println();
        System.out.println("After sortings");
        for(int num: nums)
        {
            System.out.print(num+" ");
        }
    }
}