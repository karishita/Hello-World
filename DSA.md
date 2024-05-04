**REVERSE THE ARRAY** 
```java
import java.util.* ;

import java.io.*; 

import java.util.ArrayList;

  

public class Solution 

{

    public static void reverseArray(ArrayList<Integer> arr, int m)

    {

       int i;

       int j=arr.size()-1;

       for(i=m+1;i<j;i++)

           {

                int temp = arr.get(i);

            arr.set(i, arr.get(j));

            arr.set(j, temp);

                j--;

                 }

}

}

```


**Sum of max and min**
```java
import java.util.* ;

import java.io.*; 

public class Solution {

  public static int sumOfMaxMin(int[] arr, int n) {

    int max=arr[0];

    int min=arr[0];

    for(int i=1;i<n;i++)

    {

      if(arr[i]>=max)

      max=arr[i];

      else if(arr[i]<=min)

       min=arr[i];

    }

    return max+min;

  }

}

```

**Kth smallest and larget element**

```java
import java.util.ArrayList;

import java.util.Collections;

  

public class Solution {

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {

    Collections.sort(arr);

      ArrayList<Integer> num = new ArrayList<Integer>(); 

      int small=arr.get(k-1);

      int large=arr.get(n-k);

      num.add(small);

      num.add(large);

      return num;

    }

}
```
how to decrease runtime??

**sort 0s 1s and 2s**

```java
import java.util.* ;

import java.io.*; 

public class Solution 

{

    public static void sort012(int[] arr)

    {

        int i;

        int s=arr.length;

        int c0=0,c1=0,c2=0;

        for(i=0;i<s;i++)

        {

          if(arr[i]==0)

            c0++;

            else if(arr[i]==1)

            c1++;

            else

            c2++;

        }

        for(i=0;i<s;i++)

        {

            if(c0!=0)

           {

               arr[i]=0;

               c0--;

           }

           else if(c1!=0)

           {

               arr[i]=1;

               c1--;

           }

           else

           {

               arr[i]=2;

               c2--;

           }

  

        }

    }

}
```
[[can runtime be decreased]]


**Move all negative nos to beginning and positive to end**

approach1:(Sorting)
```java
import java.util.Arrays;

public class Solution {

    public static int[] separateNegativeAndPositive(int a[]) {

        Arrays.sort(a);

        return a;

  

    }

}
```
**approach 2(two pointer)**
```java
public class Solution {

    public static int[] separateNegativeAndPositive(int a[]) {

  

        int curr=0;

        int neg=-1;

        for(curr=0;curr<a.length;curr++)

      {

          if(a[curr]<0)

          {

              neg++;

              int t=a[neg];

              a[neg]=a[curr];

              a[curr]=t;

       }

      }

      return a;

  

    }

}
```

![[Drawing 2024-03-29 23.40.11.excalidraw]]

find union and intersection number of 2 arrays
```java
import java.util.* ;

import java.io.*; 

import java.util.ArrayList;

  

public class Solution {

    public static ArrayList<Integer> findSimilarity(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {

    int i,j;

    int c=0;

    for(i=0;i<n;i++)

    {

        for( j=0;j<m;j++)

        {

            if(arr1.get(i).equals(arr2.get(j)))

            c++;

        }

    }

        int u=n+m-c;

         ArrayList<Integer> result=new ArrayList<Integer>();

         result.add(c);

         result.add(u);

         return result;

  
  

    }

}
```
[[another way for union and intersection]]

**Rotate array to left by k**
```java
import java.util.ArrayList;

  

public class Solution {

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {

      int s= arr.size();

      int i;

      ArrayList<Integer> result=new ArrayList<Integer>();

      k=k%s;

      for(i=k;i<s;i++)

      {

         result.add(arr.get(i));

  

      }

      for(i=0;i<k;i++)

      {

          result.add(arr.get(i));

      }

      return result;

    }

}
```

![[Drawing 2024-03-30 00.47.37.excalidraw]]
**Rotate array left by k places**
```java
class Solution {
    public void rotate(int[] nums, int k) {
        
        int s=nums.length;
        k=k%s;
        
        int[] temp=new int[s];
        int i,j=0;
        for(i=s-k;i<s;i++)
            {
            temp[j]=nums[i];
            j++;
            }
        for(i=0;i<=s-k-1;i++)
            {
          temp[j]=nums[i];
            j++;
            }
       for(i=0;i<s;i++)
           {
           nums[i]=temp[i];
           }
        
```
**Move Zeros to the end**


![[Drawing 2024-04-03 21.31.46.excalidraw]]                                        
```java
class Solution {
    public void moveZeroes(int[] nums) {
        
        int i;
        int j=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[j]=nums[i];
                j++;
            }
        }
        for(i=j;i<nums.length;i++)
        {
            nums[i]=0;
            
        }
        
    }
}

```



Find Union of 2 arrays

```java
import java.util.*;

public class Solution {

    public static List< Integer > sortedArray(int []a, int []b) {

        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0, k;

        Integer lastAdded = null; // Track the last added element to prevent duplicates

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {

                if (lastAdded == null || !lastAdded.equals(a[i])) {

                    res.add(a[i]);

                    lastAdded = a[i];

                }

                i++;

            } else if (a[i] == b[j]) {

                if (lastAdded == null || !lastAdded.equals(a[i])) {

                    res.add(a[i]);

                    lastAdded = a[i];

                }

                i++;

                j++;

            } else {

                if (lastAdded == null || !lastAdded.equals(b[j])) {

                    res.add(b[j]);

                    lastAdded = b[j];

                }

                j++;

            }

        }

        while (i < a.length) {

            if (lastAdded == null || !lastAdded.equals(a[i])) {

                res.add(a[i]);

                lastAdded = a[i];

            }

            i++;

        }

        while (j < b.length) {

            if (lastAdded == null || !lastAdded.equals(b[j])) {

                res.add(b[j]);

                lastAdded = b[j];

            }

            j++;

        }

        return res;

    }

}
```
[[can we do it using set?????]]

**Find missing numbers in an array**
```java
class Solution {
    public int missingNumber(int[] nums) {
        int i,j,c=0;
        for(i=0;i<=nums.length;i++)
        {
            c=0;
            for(j=0;j<nums.length;j++)
            {
                if(nums[j]==i)
                {
                    c=1;
                    break;
                }
            
            }
            if(c==0)
                    break;
        }
        return i;
        
    }
}
```

**Another Method**
```java
class Solution {
    public int missingNumber(int[] nums) {
       Arrays.sort(nums);
        int i=0;
        for(i=0;i<nums.length;i++)
        {
            if(i!=nums[i])
                break;
        }
        return i;
    }
}
```


**Maximum Consecutive ones**

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count=0,max_count=0;
        int i=0,j;
        while(i<nums.length)
        {
            
           if(nums[i]==1)
            {
                count=1;
                j=i+1;
                    while (j < nums.length && nums[j] == 1)
                {
                    count=count+1;
                    j=j+1;
                    
                }
               if(count>max_count)
            max_count=count;
             i=j;
            }
            
        else
        {
            i=i+1;
        }
      
        }
       return max_count; 
    }
}
```
The key difference lies in the condition inside the inner `while` loop. In the corrected version of the code, the condition `j < nums.length && nums[j] == 1` ensures that the loop will only continue iterating as long as both conditions are met: `j` is within the bounds of the array (`j < nums.length`) and the value at `nums[j]` is `1`.

This prevents the out of bounds error because if `j` exceeds the length of the array, the condition `j < nums.length` will become `false`, and the loop will terminate before attempting to access `nums[j]`.

In your original code, the condition `nums[j] == 1 && j < nums.length` could cause an out of bounds error because it first checks `nums[j] == 1`, potentially accessing `nums[j]` when `j` is already out of bounds, leading to an error.


**Find The number that appears once** 

```java
class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int i;
        for(i=0;i<nums.length;i=i+2)
        {
            if((i==nums.length-1 )|| (nums[i]!=nums[i+1] ))
            break;
        }
       return nums[i]; 
    }
}
```

```C
int singleNumber(int* nums, int numsSize){
  int i;
  int d=0;
  for(i=0;i<numsSize;i++)
  {
   d=d^nums[i];


  }
  return d;

}
```

