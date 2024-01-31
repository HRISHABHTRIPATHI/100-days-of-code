//{ Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class SortedStack{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
         public void solution(Stack<Integer> st){
            if(st.size() == 1){
                return ;
            }
            
            int temp = st.pop();
            solution(st);
            
            // Rearrange
            
            put(st, temp);
            
        }
        
        public void put(Stack<Integer> st, int val){
            if(st.isEmpty() || st.peek() <= val){
                st.push(val);
                return;
            }
            
            int temp = st.pop();
            put(st, val);
            
            // backTracking.
            st.push(temp);
        }
        
    public Stack<Integer> sort(Stack<Integer> s)
    {
    // Without Recursion.
     
    /*int[] arr = new int[s.size()];
    int i = 0;
    while(!s.isEmpty()){
       arr[i++] = s.pop();
    }
    for(i = 0; i < arr.length-1; i++){
       for(int j = i+1; j > 0; j--){
           if(arr[j] < arr[j-1]){
               int temp = arr[j];
               arr[j] = arr[j-1];
               arr[j-1] = temp;
           }
       }
    }
    for(int el : arr)s.push(el);
    return s; */
     
    // With the help of Recursion.
     
    solution(s);
    return s;
    }
    }