import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    // code
    
    int rb[]=new int[arr.length];
    Stack<Integer>strb=new Stack<>();
    strb.push(arr.length-1);
    rb[arr.length-1]=arr.length;
    for(int i=arr.length-2;i>=0;i--)
    {
         while(strb.size()!=0 && arr[i]<=arr[strb.peek()])
         {
             strb.pop();
         }
         
         if(strb.size()==0) 
         {
             rb[i]=arr.length;
         }
         else{
             rb[i]=strb.peek();
         }
         
         
         strb.push(i);
    }

    int lb[]=new int[arr.length];
        Stack<Integer>stlb=new Stack<>();
    stlb.push(0);
       lb[0]=-1;
    for(int i=1;i<arr.length;i++)
    {
         while(stlb.size()!=0 && arr[i]<=arr[stlb.peek()])
         {
             stlb.pop();
         }
         
         if(stlb.size()==0)
         {
             lb[i]=-1;
         }
         else{
             lb[i]=stlb.peek();
         }
         
         
         stlb.push(i);
    }
    
    
    
    int maxArea=0;
    
    for(int i=0;i<arr.length;i++)
    {
        int width=rb[i]-lb[i]-1;
        
        int area=arr[i]*width;
        
        if(area>maxArea)
        {
            maxArea=area;
        }
    }
    
    System.out.print(maxArea);
 }
}
